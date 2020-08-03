package com.skynet.phrasegenerator.generators;

import javax.inject.Inject;

public class Factory {

    @Inject
    public Factory() {
    }

    public Generator createGenerator(Generatorlevel generatorlevel) {
        if (generatorlevel instanceof Generatorlevel.First)
            return new FirstLevelGenerator();
        else if (generatorlevel instanceof Generatorlevel.Second)
            return new SecondLevelGenerator();
        else if (generatorlevel instanceof Generatorlevel.Third)
            return new ThirdLevelGenerator();
        else if (generatorlevel instanceof Generatorlevel.Fourth)
            return new FourthLevelGenerator();
        else return new FirstLevelGenerator();
    }
}