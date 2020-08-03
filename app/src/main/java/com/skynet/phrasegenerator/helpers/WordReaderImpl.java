package com.skynet.phrasegenerator.helpers;

import android.content.Context;

import com.skynet.phrasegenerator.entity.Adjective;
import com.skynet.phrasegenerator.entity.Noun;
import com.skynet.phrasegenerator.entity.Verb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class WordReaderImpl implements WordReader {

    @Inject
    public WordReaderImpl() {
    }

    @Override
    public void readAll(Context context) {
        WordsStore wordsStore = WordsStore.getInstance();
        wordsStore.setNouns(readNouns(context));
        wordsStore.setAdjectives(readAdjectives(context));
        wordsStore.setVerbs(readVerbs(context));
    }

    public List<Noun> readNouns(Context context) {
        ArrayList<Noun> nouns = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("nouns.json")));
            JSONArray jsonarray = new JSONArray(br.lines().collect(Collectors.joining()));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                nouns.add(new Noun(jsonobject.getString("singular"), jsonobject.getString("plural"), jsonobject.getString("genitive"),jsonobject.getString("instrumental"), jsonobject.getString("gender")));
            }
            return nouns;
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return nouns;
    }

    public List<Adjective> readAdjectives(Context context) {
        ArrayList<Adjective> adjectives = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("adjectives.json")));
            JSONArray jsonarray = new JSONArray(br.lines().collect(Collectors.joining()));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                adjectives.add(new Adjective(jsonobject.getString("singularMale"), jsonobject.getString("singularFemale"), jsonobject.getString("plural"), jsonobject.getString("instrumental")));
            }
            return adjectives;
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return adjectives;
    }

    public List<Verb> readVerbs(Context context) {
        ArrayList<Verb> verbs = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("verbs.json")));
            JSONArray jsonarray = new JSONArray(br.lines().collect(Collectors.joining()));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                verbs.add(new Verb(jsonobject.getString("singular"), jsonobject.getString("plural"), jsonobject.getString("possessiveSingularMale"), jsonobject.getString("possessiveSingularFemale"), jsonobject.getString("possessivePlural")));
            }
            return verbs;
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return verbs;
    }
}
