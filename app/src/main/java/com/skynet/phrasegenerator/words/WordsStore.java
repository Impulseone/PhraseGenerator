package com.skynet.phrasegenerator.words;

import java.util.List;

public class WordsStore {
    private List<Noun> nouns;
    private List<Verb> verbs;
    private List<Adjective> adjectives;
    private List<Possessive> possessives;

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

    public List<Possessive> getPossessives() {
        return possessives;
    }

    public void setPossessives(List<Possessive> possessives) {
        this.possessives = possessives;
    }
}
