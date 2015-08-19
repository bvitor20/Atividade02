package com.example.aluno.atividade02;

import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEditNome;
    ListView mListView;
    ArrayList <String> mNomes;
    ArrayAdapter <String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNomes = new ArrayList<>();

        if (savedInstanceState != null){
            mNomes= savedInstanceState.getStringArrayList("nome");
        }
        mEditNome = (EditText)findViewById(R.id.editText);
        mListView = (ListView) findViewById(R.id.listViewNomes);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mNomes);
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nome", mNomes);
    }

    public void clickParaAddOnClick(View view) {
        String nome = mEditNome.getText().toString();
        mNomes.add(nome);
        mAdapter.notifyDataSetChanged();
    }
}
