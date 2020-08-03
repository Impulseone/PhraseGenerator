package com.skynet.phrasegenerator.entity;

public class Noun {
    private String singular;
    private String plural;
    private String genitive;
    private String instrumental;
    private String gender;

    public Noun(String singular, String plural, String genitive, String instrumental, String gender) {
        this.singular = singular;
        this.plural = plural;
        this.genitive = genitive;
        this.instrumental = instrumental;
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

    public String getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(String instrumental) {
        this.instrumental = instrumental;
    }

    public String getGender() {
        return gender;
    }
}
