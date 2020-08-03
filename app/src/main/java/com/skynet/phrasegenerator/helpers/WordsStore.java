package com.skynet.phrasegenerator.helpers;

import com.skynet.phrasegenerator.entity.Adjective;
import com.skynet.phrasegenerator.entity.Noun;
import com.skynet.phrasegenerator.entity.Verb;

import java.util.List;

public class WordsStore {

    private static WordsStore wordsStore;

    private List<Noun> nouns;
    private List<Verb> verbs;
    private List<Adjective> adjectives;

    public static WordsStore getInstance() {
        if (wordsStore == null) {
            wordsStore = new WordsStore();
        }
        return wordsStore;
    }

    private WordsStore() {
    }

    public List<Noun> getNouns() {
        return nouns;
    }

    public void setNouns(List<Noun> nouns) {
        this.nouns = nouns;
    }

    public List<Verb> getVerbs() {
        return verbs;
    }

    public void setVerbs(List<Verb> verbs) {
        this.verbs = verbs;
    }

    public List<Adjective> getAdjectives() {
        return adjectives;
    }

    public void setAdjectives(List<Adjective> adjectives) {
        this.adjectives = adjectives;
    }
}
