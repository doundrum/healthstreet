package com.example.healthstreet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.ObjectsCompat;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ListView;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AboutUs extends AppCompatActivity {
    private Button btnBack;
    private Context context;
    ListView listView;
    TextView linkTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        linkTextView=findViewById(R.id.activity_about_link);

        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        listView = findViewById(R.id.listView);
        //create date
        ArrayList<Person> arrayList = new ArrayList<>();

        arrayList.add(new Person(R.drawable.auni, "NUR AUNI QISTINA BINTI MOHD ZAKRI", "2021102241 ", "NETCENTRIC(CS251)"));
        arrayList.add(new Person(R.drawable.mirah, "NURUL AMIRAH BINTI MOHAMAD ASRI", "2021115109  ","NETCENTRIC(CS251)"));
        arrayList.add(new Person(R.drawable.ika, "NURZALIKHA IZZATIE BINTI ZAIDI", "2021100633 ","NETCENTRIC(CS251)"));
        arrayList.add(new Person(R.drawable.ain, "TENGKU NUR AIN NADHIRAH BINTI TENGKU NAZMUDIN ", "2021156079  ","NETCENTRIC(CS251)"));


        // make custom adapter
        PersonAdapter personAdapter =  new PersonAdapter(this,R.layout.list_row,arrayList);

        listView.setAdapter(personAdapter);

        btnBack =findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}