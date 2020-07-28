package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.words.WordsStore;

import java.util.Random;

public class SecondLevelGenerator extends Generator {

    private WordsStore wordsStore;
    private Random random = new Random();


    public SecondLevelGenerator(WordsStore wordsStore) {
       this.wordsStore = wordsStore;
    }

    @Override
    public String generatePhrase() {
        int k = 1 + random.nextInt(4);
        if (k == randomPhraseNumber) return generatePhrase();
        else randomPhraseNumber = k;
        switch (k) {
            case 1:
                return firstFigure();
            case 2:
                return secondFigure();
            case 3:
                return thirdFigure();
            case 4:
                return fourthFigure();
        }
        return firstFigure();
    }

    private String firstFigure() {

        //Пускающие объекты сделаны из изголовий.
        //Цапли пускают.

        int possessiveNumber = random.nextInt(wordsStore.getPossessives().size() - 1);
        String possessiveA = wordsStore.getPossessives().get(possessiveNumber).getPlural();
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getGenitive();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String verbA = wordsStore.getVerbs().get(possessiveNumber).getPlural();
        if (checkEquals(new String[]{nounA, nounB})) return firstFigure();
        return toFirstUpperCase(possessiveA) + " объекты сделаны из " + nounA + "." + "\n" + toFirstUpperCase(nounB) + " " + verbA + ". ";
    }

    private String secondFigure() {

        //Некоторые веники делятся на телефонные и поэтические.
        //Взгляды и дятлы обладают свойством телефонный и поэтический.

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC})) return secondFigure();

        int adjANumber = random.nextInt(wordsStore.getAdjectives().size() - 1);
        int adjBNumber = random.nextInt(wordsStore.getAdjectives().size() - 1);

        String adjA = wordsStore.getAdjectives().get(adjANumber).getPlural();
        String adjB = wordsStore.getAdjectives().get(adjBNumber).getPlural();

        if (checkEquals(new String[]{adjA, adjB})) return secondFigure();

        String adjC = wordsStore.getAdjectives().get(adjANumber).getSingular();
        String adjD = wordsStore.getAdjectives().get(adjBNumber).getSingular();

        return "Некоторые " + nounA + " делятся на " + adjA + " и " + adjB + "." + "\n" + toFirstUpperCase(nounB) + " и " + nounC + " обладают свойством " + adjC + " и " + adjD + ".";
    }

    private String thirdFigure() {

        //Либо только мемориалы, либо только искорки - это линолеумы.
        //Линолеумы - это зяблики.

        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounC = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounD = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();

        if (checkEquals(new String[]{nounA, nounB, nounC, nounD})) return thirdFigure();

        return "Либо только " + nounA + ", либо только " + nounB + " - это " + nounC + '.' + "\n" + toFirstUpperCase(nounC) + " - это " + nounD + '.';
    }

    private String fourthFigure() {

        //Изобилия сделаны из иголочек.
        //Некоторые объекты из иголочек излагают.
        String nounA = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getPlural();
        String nounB = wordsStore.getNouns().get(random.nextInt(wordsStore.getNouns().size() - 1)).getGenitive();
        String verbA = wordsStore.getVerbs().get(random.nextInt(wordsStore.getVerbs().size() - 1)).getPlural();

        return toFirstUpperCase(nounA) + " сделаны из " + nounB + ". " + "\n" + "Некоторые объекты из " + nounB + " " + verbA + ".";
    }

}
