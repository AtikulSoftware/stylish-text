package com.creativestyle.stylishtext;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private RecyclerView recyclerView;
    private StylishTextAdapter adapter;
    private HashMap<Character, String[]> alphabetMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize
        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StylishTextAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        initAlphabetMap();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();
                List<String> stylishTexts = generateStylishTexts(input);
                adapter.updateStylishTexts(stylishTexts);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

    } // onCreate end here ==========

    private void initAlphabetMap() {
        alphabetMap = new HashMap<>();
        alphabetMap = new HashMap<>();
        alphabetMap.put('a', new String[]{"𝓐", "𝔄", "𝔸", "🅰","\uD83D\uDC9D"});
        alphabetMap.put('b', new String[]{"𝓑", "𝔅", "𝔹", "🅱", "\uD83D\uDC9D"});
        alphabetMap.put('c', new String[]{"𝓒", "𝔇", "ℂ", "🅲","\uD83D\uDC9D"});
    }

    private List<String> generateStylishTexts(String input) {
        List<String> stylishTexts = new ArrayList<>();
        if (input.isEmpty()) return stylishTexts;

        StringBuilder style1 = new StringBuilder();
        StringBuilder style2 = new StringBuilder();
        StringBuilder style3 = new StringBuilder();
        StringBuilder style4 = new StringBuilder();
        StringBuilder style5 = new StringBuilder();

        for (char c : input.toLowerCase().toCharArray()) {
            if (alphabetMap.containsKey(c)) {
                style1.append(alphabetMap.get(c)[0]);
                style2.append(alphabetMap.get(c)[1]);
                style3.append(alphabetMap.get(c)[2]);
                style4.append(alphabetMap.get(c)[3]);
                style5.append(alphabetMap.get(c)[4]);
            } else {
                style1.append(c);
                style2.append(c);
                style3.append(c);
                style4.append(c);
                style5.append(c);
            }
        }

        stylishTexts.add(style1.toString());
        stylishTexts.add(style2.toString());
        stylishTexts.add(style3.toString());
        stylishTexts.add(style4.toString());
        stylishTexts.add(style5.toString());

        return stylishTexts;
    }


} // public class end here ==================