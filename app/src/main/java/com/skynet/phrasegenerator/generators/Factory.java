package com.skynet.phrasegenerator.generators;

import com.skynet.phrasegenerator.words.WordsStore;

public class Factory {
    public Generator createGenerator(Generatorlevel generatorlevel, WordsStore wordsStore) {
        if (generatorlevel instanceof Generatorlevel.First) return new FirstLevelGenerator(wordsStore);
        else if (generatorlevel instanceof Generatorlevel.Second)
            return new SecondLevelGenerator(wordsStore);
        else if (generatorlevel instanceof Generatorlevel.Third)
            return new ThirdLevelGenerator(wordsStore);
        else if (generatorlevel instanceof Generatorlevel.Fourth)
            return new FourthLevelGenerator(wordsStore);
        else return new FirstLevelGenerator(wordsStore);
    }
}