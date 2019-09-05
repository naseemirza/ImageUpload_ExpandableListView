package com.example.user.dialogbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

public class AutoComplTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_compl_text);

        final AutoCompleteTextView countrySearch = (AutoCompleteTextView) findViewById(R.id.search);
        final AutocompleteAdapter adapter = new AutocompleteAdapter(this,android.R.layout.simple_dropdown_item_1line);
        countrySearch.setAdapter(adapter);

        //when autocomplete is clicked
        countrySearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String countryName = adapter.getItem(position).getName();
                countrySearch.setText(countryName);
            }
        });
    }
}
