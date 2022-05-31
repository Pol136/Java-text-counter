package com.example.proect;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class Fragment1 extends Fragment {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    public static double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
    public String na, napis, proiz, chten, sim, cl, p;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String s = bundle.getString("message");
        int n = s.length();
        int simvol=n, clova=1, pred=1;
        for (int i=0; i<n; i++){
            if (s.charAt(i)==' ') {
                simvol-=1;
                clova+=1;
            }
            if ((s.charAt(i)=='.') || (s.charAt(i)=='!') || (s.charAt(i)=='?') ||
                    ((i+2<n)&&(s.charAt(i)=='.')&&(s.charAt(i+1)=='.')&&(s.charAt(i+2)=='.'))){
                pred+=1;
            }
        }
        if (s.charAt(n-1)==' ') clova-=1;
        double nap=68.0, pro=180.0, cht=275.0;

        napis = String.format("%.2f", n/nap);
        proiz = String.format("%.2f", n/pro);
        chten = String.format("%.2f", n/cht);


        na = String.valueOf(n);
        sim = String.valueOf(simvol);
        cl = String.valueOf(clova);
        p = String.valueOf(pred);



        return inflater.inflate(R.layout.fragment_1, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView textView2 = (TextView) getView().findViewById(R.id.textView2);
        textView2.setText(na);
        TextView textView4 = (TextView) getView().findViewById(R.id.textView4);
        textView4.setText(sim);
        TextView textView5 = (TextView) getView().findViewById(R.id.textView5);
        textView5.setText(cl);
        TextView textView6 = (TextView) getView().findViewById(R.id.textView6);
        textView6.setText(p);
        TextView textView12 = (TextView) getView().findViewById(R.id.textView12);
        textView12.setText(chten);
        TextView textView11 = (TextView) getView().findViewById(R.id.textView11);
        textView11.setText(proiz);
        TextView textView19 = (TextView) getView().findViewById(R.id.textView19);
        textView19.setText(napis);

        Button ok= (Button) getView().findViewById(R.id.button2);
        Fragment me = this;
        ok.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                getActivity().getSupportFragmentManager().beginTransaction().remove(me).commit();
            }
        });

        Context thist = getActivity();
        mDBHelper = new DatabaseHelper(thist);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        String[] product = new String[12];
        product[0]="В «Русском орфографическом словаре» (самом полном словаре) около 200 тысяч слов";
        product[1]="День и Ленин- самые частоупотребляемые слова в текстах песен Егора Летова.";
        product[2]="Ночь встречается в песнях группы Кино чаще остальных.";
        product[3]="Лингвисты подсчитали, что существительных мужского рода всего около 40,5%, женского рода — 43% и среднего рода — около 16,5%";
        product[4]="Ближайшие родственники русского языка — украинский и белорусский. Когда-то эти три языка представляли единый общевосточнославянский язык.";
        product[5]="Когда-то в нашем языке не было такой части речи — числительное. Слова два, три, четыре были прилагательными, а пять, шесть  — существительными.";
        product[6]="Слова мертвец и покойник в русском языке — одушевленные существительные, а труп — неодушевленное.";
        product[7]="Долгое время в русском языке не существовало буквы «ё» — вплоть до 1873 года.";
        product[8]="Выражение гвоздь программы появилось во время Всемирной выставки 1889 года, которая проходила в Париже. Там гвоздем была Эйфелева башня.";
        product[9]="Раньше подлинником называли палку, которой на суде дубасили неразговорчивого свидетеля, чтобы в прямом смысле выбить из него показания";
        product[10]="Слово «банк» происходит от итальянского «banca», что означает «скамья», так как ранее финансовые операции совершались частными лицами на специальных скамьях. ";
        product[11]="На сленге мафиози 40-х годов прилагательным «stand-up» характеризовали надёжных людей — например, бойцов, на которых всегда можно положиться.";
        int k=(int)getRandomIntegerBetweenRange(0,11);
        TextView textView = (TextView) getView().findViewById(R.id.textView);
        textView.setText(product[k]);

    }



}