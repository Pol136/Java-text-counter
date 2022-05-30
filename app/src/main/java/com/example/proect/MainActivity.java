package com.example.proect;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.text.BreakIterator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Edit = (EditText) findViewById(R.id.Edit);
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
    }






}