package com.skynet.phrasegenerator.words;

import com.skynet.phrasegenerator.WordReader;
import com.skynet.phrasegenerator.WordReaderImpl;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class WordReaderModule {
    @Binds
    public abstract WordReader bindWordReader(WordReaderImpl wordReader);
}
