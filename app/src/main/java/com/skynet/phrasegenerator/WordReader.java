package com.skynet.phrasegenerator;

import android.content.Context;

import com.skynet.phrasegenerator.words.WordsStore;

public interface WordReader {
    WordsStore readAll(Context context);
}
