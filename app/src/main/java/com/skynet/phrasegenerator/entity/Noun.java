package com.skynet.phrasegenerator.entity;

public class Noun {
    private String singular;
    private String plural;
    private String genitive;
    private String gender;

    public Noun(String singular, String plural, String genitive, String gender) {
        this.singular = singular;
        this.plural = plural;
        this.genitive = genitive;
        this.gender = gender;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }

    public String getGenitive() {
        return genitive;
    }

    public String getGender() {
        return gender;
    }
}
