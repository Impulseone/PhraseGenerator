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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
