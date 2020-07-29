package com.skynet.phrasegenerator.helpers;

import android.content.Context;

import com.skynet.phrasegenerator.helpers.WordsStore;

public interface WordReader {
    WordsStore readAll(Context context);
}
