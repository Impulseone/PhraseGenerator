package com.skynet.phrasegenerator;

import android.content.Context;

import com.skynet.phrasegenerator.words.Adjective;
import com.skynet.phrasegenerator.words.Noun;
import com.skynet.phrasegenerator.words.Possessive;
import com.skynet.phrasegenerator.words.Verb;
import com.skynet.phrasegenerator.words.WordsStore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WordReaderImpl implements WordReader {
    @Override
    public WordsStore readAll(Context context) {
        WordsStore wordsStore = new WordsStore();
        wordsStore.setNouns(readNouns(context));
        wordsStore.setAdjectives(readAdjectives(context));
        wordsStore.setVerbs(readVerbs(context));
        wordsStore.setPossessives(readPossessives(context));
        return wordsStore;
    }

    private List<Possessive> readPossessives(Context context) {
        ArrayList<Possessive> possessives = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("possessives.json")));
            JSONArray jsonarray = new JSONArray(br.lines().collect(Collectors.joining()));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                possessives.add(new Possessive(jsonobject.getString("singular"), jsonobject.getString("plural")));
            }
            return possessives;
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return possessives;
    }

    public List<Noun> readNouns(Context context) {
        ArrayList<Noun> nouns = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("nouns.json")));
            JSONArray jsonarray = new JSONArray(br.lines().collect(Collectors.joining()));
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                nouns.add(new Noun(jsonobject.getString("singular"), jsonobject.getString("plural"), jsonobject.getString("genitive")));
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
                adjectives.add(new Adjective(jsonobject.getString("singular"), jsonobject.getString("plural"), jsonobject.getString("instrumental")));
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
                verbs.add(new Verb(jsonobject.getString("singular"), jsonobject.getString("plural")));
            }
            return verbs;
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
        return verbs;
    }
}
