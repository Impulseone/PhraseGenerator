package com.skynet.phrasegenerator.entity;

public class Adjective {

    private String singularMale;
    private String singularFemale;
    private String plural;
    private String instrumental;

    public Adjective(String singularMale, String singularFemale, String plural, String instrumental) {
        this.singularMale = singularMale;
        this.singularFemale = singularFemale;
        this.plural = plural;
        this.instrumental = instrumental;
    }

    public String getSingularMale() {
        return singularMale;
    }

    public String getSingularFemale() {
        return singularFemale;
    }

    public String getPlural() {
        return plural;
    }

    public String getInstrumental() {
        return instrumental;
    }
}
