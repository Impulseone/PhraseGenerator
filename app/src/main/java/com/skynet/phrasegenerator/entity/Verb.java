package com.skynet.phrasegenerator.entity;

public class Verb {
    private String singular;
    private String plural;
    private String possessiveSingularMale;
    private String possessiveSingularFemale;
    private String possessivePlural;

    public Verb(String singular, String plural, String possessiveSingularMale, String possessiveSingularFemale, String possessivePlural) {
        this.singular = singular;
        this.plural = plural;
        this.possessiveSingularMale = possessiveSingularMale;
        this.possessiveSingularFemale = possessiveSingularFemale;
        this.possessivePlural = possessivePlural;
    }

    public String getSingular() {
        return singular;
    }

    public String getPlural() {
        return plural;
    }

    public String getPossessiveSingularMale() {
        return possessiveSingularMale;
    }

    public String getPossessiveSingularFemale() {
        return possessiveSingularFemale;
    }

    public String getPossessivePlural() {
        return possessivePlural;
    }
}
