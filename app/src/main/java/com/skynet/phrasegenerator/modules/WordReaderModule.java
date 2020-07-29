package com.skynet.phrasegenerator.modules;

import com.skynet.phrasegenerator.helpers.WordReader;
import com.skynet.phrasegenerator.helpers.WordReaderImpl;

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
