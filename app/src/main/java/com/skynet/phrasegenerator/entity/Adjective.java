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

    public void setSingularMale(String singularMale) {
        this.singularMale = singularMale;
    }

    public String getSingularFemale() {
        return singularFemale;
    }

    public void setSingularFemale(String singularFemale) {
        this.singularFemale = singularFemale;
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(String instrumental) {
        this.instrumental = instrumental;
    }
}
