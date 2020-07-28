package com.skynet.phrasegenerator.words;

public class Adjective {

    private String singular;
    private String plural;
    private String instrumental;

    public Adjective(String singular, String plural, String instrumental) {
        this.singular = singular;
        this.plural = plural;
        this.instrumental = instrumental;
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

    public String getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(String instrumental) {
        this.instrumental = instrumental;
    }
}
