package com.skynet.phrasegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skynet.phrasegenerator.generators.Factory;
import com.skynet.phrasegenerator.generators.Generator;
import com.skynet.phrasegenerator.generators.Generatorlevel;
import com.skynet.phrasegenerator.words.WordsStore;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    Button generateButton;
    Button levelUpButton;
    Button levelDownButton;
    Button copyButton;
    Button reportButton;

    TextView logicPhrase;

    @Inject
    Factory factory;

    Generator generator;

    Generatorlevel generatorlevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WordsStore wordsStore = new WordReaderImpl().readAll(this);

        generateButton = (Button) findViewById(R.id.generate_button);
        levelUpButton = (Button) findViewById(R.id.level_up_button);
        levelDownButton = (Button) findViewById(R.id.level_down_button);
        copyButton = (Button) findViewById(R.id.copy);
        reportButton = (Button) findViewById(R.id.report_an_error);

        logicPhrase = (TextView) findViewById(R.id.logic_phrase);

        generator = factory.createGenerator(new Generatorlevel.First(), wordsStore);

        generateButton.setOnClickListener(view -> logicPhrase.setText(factory.createGenerator(generatorlevel, wordsStore).generatePhrase()));

        levelUpButton.setOnClickListener(view -> onClickLevelUp());

        levelDownButton.setOnClickListener(view -> onClickLevelDown());
        copyButton.setOnClickListener(view -> onClickCopy());
        reportButton.setOnClickListener(view -> onClickError());
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView phraseView = (TextView) findViewById(R.id.logic_phrase);
        outState.putString("logic_phrase", phraseView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String textViewText = savedInstanceState.getString("logic_phrase");
        TextView nameView = (TextView) findViewById(R.id.logic_phrase);
        nameView.setText(textViewText);
    }

    public void onClickLevelUp() {
        TextView currentLevelView = findViewById(R.id.current_level);
        String currentLevelString = currentLevelView.getText().toString();
        switch (currentLevelString) {
            case "начинающий": {
                generatorlevel = new Generatorlevel.Second();
                currentLevelView.setText("любитель");
                break;
            }
            case "любитель": {
                generatorlevel = new Generatorlevel.Third();
                currentLevelView.setText("профессионал");
                break;
            }
            case "профессионал": {
                generatorlevel = new Generatorlevel.Fourth();
                currentLevelView.setText("ниндзя");
                break;
            }
            case "ниндзя": {
                break;
            }
        }
    }

    public void onClickLevelDown() {
        TextView currentLevelView = findViewById(R.id.current_level);
        String currentLevelString = currentLevelView.getText().toString();
        switch (currentLevelString) {
            case "начинающий": {
                break;
            }
            case "любитель": {
                generatorlevel = new Generatorlevel.First();
                currentLevelView.setText("начинающий");
                break;
            }
            case "профессионал": {
                generatorlevel = new Generatorlevel.Second();
                currentLevelView.setText("любитель");
                break;
            }
            case "ниндзя": {
                generatorlevel = new Generatorlevel.Third();
                currentLevelView.setText("профессионал");
                break;
            }
        }
    }

    public void onClickCopy() {
        TextView textView = findViewById(R.id.logic_phrase);
        ClipboardManager clipboard = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", textView.getText().toString());
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Скопировано в буфер обмена", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Сгенерируйте фразу", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void onClickError() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"jazz98@mail.ru"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Ошибка в приложении генератор фраз");
        try {
            startActivity(Intent.createChooser(i, "Отправить с помощью..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Отсутствуют приложения для отправки сообщений.", Toast.LENGTH_SHORT).show();
        }
    }
}
