package com.example.proect;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity{

    private SharedPreferences sPref;
    public EditText Edit;

    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Edit = (EditText) findViewById(R.id.Edit);
        Button bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String s = Edit.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("message", s);
                Fragment1 fragInfo = new Fragment1();
                fragInfo.setArguments(bundle);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.cont, fragInfo);
                transaction.commit();
            }
        });
        //Button sox = findViewById(R.id.button3);
        //sox.setOnClickListener(new View.OnClickListener(){
        //     @Override
        //    public void onClick(View view){
        //        saveText();
        //    }
        //});
    }

    public void saveText(){
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, Edit.getText().toString());
        ed.commit();
        Toast.makeText(MainActivity.this, "Сохранено!", Toast.LENGTH_SHORT).show();
    }

    //@Override
    //protected void onDestroy() {
    //    super.onDestroy();
    //    saveText();
    //}

}