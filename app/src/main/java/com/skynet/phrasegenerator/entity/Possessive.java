package com.skynet.phrasegenerator.entity;

public class Possessive {
    private String singular;
    private String plural;

    public Possessive(String singular, String plural) {
        this.singular = singular;
        this.plural = plural;
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
}
