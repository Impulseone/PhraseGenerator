package com.skynet.phrasegenerator.words;

public class Noun {
    private String singular;
    private String plural;
    private String genitive;

    public Noun(String singular, String plural, String genitive) {
        this.singular = singular;
        this.plural = plural;
        this.genitive = genitive;
    }

    public String getSingular() {
        return singular;
    }

    public void setSingular(String singular) {
        this.singular = singular;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getGenitive() {
        return genitive;
    }

    public void setGenitive(String genitive) {
        this.genitive = genitive;
    }
}
