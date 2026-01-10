package com.application.bufinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.application.bufinder.models.Journal;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

public class Lost_Form extends AppCompatActivity {
    Button button1;
    Spinner sp_item1, sp_sub1, sp_brand1, sp_colour1;
    ArrayList<String> arrayList_item;
    ArrayAdapter<String> arrayAdapter_item;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final CollectionReference collectionReference = db.collection("Lost");

    ArrayList<String> arrayList_ad;
    ArrayList<String> arrayList_la;
    ArrayList<String> arrayList_w;
    ArrayList<String> arrayList_f;
    ArrayList<String> arrayList_b;
    ArrayList<String> arrayList_k;
    ArrayList<String> arrayList_se;
    ArrayList<String> arrayList_c;
    ArrayAdapter<String> arrayAdapter_sub;

    ArrayList<String> arrayList_adb;
    ArrayList<String> arrayList_lab;
    ArrayList<String> arrayList_wb;
    ArrayList<String> arrayList_fb;
    ArrayList<String> arrayList_bb;
    ArrayList<String> arrayList_kb;
    ArrayList<String> arrayList_seb;
    ArrayList<String> arrayList_cb;
    ArrayAdapter<String> arrayAdapter_brand;

    ArrayList<String> arrayList_colour;
    ArrayAdapter<String> arrayAdapter_colour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_form);
        sp_item1 = (Spinner) findViewById(R.id.sp_item1);
        sp_sub1 = (Spinner) findViewById(R.id.sp_sub1);
        sp_brand1 = (Spinner) findViewById(R.id.sp_brand1);
        sp_colour1 = (Spinner) findViewById(R.id.sp_colour1);
        button1 = findViewById(R.id.button1);

        arrayList_item = new ArrayList<>(Arrays.asList("Audio Devices","Laptop and Accessories","Wearables", "Footwear", "Bottles", "Keys", "Sports Equipment", "Any type of Card"));
        arrayAdapter_item = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_item);
        sp_item1.setAdapter(arrayAdapter_item);

        //======== ArrayList of Individual Sub types=============
        arrayList_ad = new ArrayList<>(Arrays.asList("Select Sub-type", "Speakers", "Over-ear Headphones", "On-ear Headphones", "Collar Earphones", "Wired Earphones", "True Wireless Earphones", "Other"));
        arrayList_la = new ArrayList<>(Arrays.asList("Select Sub-type", "Laptop", "Keyboard", "Mouse", "Storage Devices", "Charger", "Laptop Sleeve", "Other"));
        arrayList_w = new ArrayList<>(Arrays.asList("Select Sub-type", "Spectacles", "Watches", "Jewellery", "Caps", "Mufflers", "Gloves", "Other"));
        arrayList_f = new ArrayList<>(Arrays.asList("Select Sub-type","Shoes", "Slippers", "Sandals", "Other"));
        arrayList_b = new ArrayList<>(Arrays.asList("Select Sub-type","Steel Bottles", "Gym Bottles", "Other"));
        arrayList_k = new ArrayList<>(Arrays.asList("Select Sub-type","Car Keys", "Room Keys", "Locker Keys", "Other"));
        arrayList_se = new ArrayList<>(Arrays.asList("Select Sub-type","Racquets", "Ball", "Shuttle Cock", "Other"));
        arrayList_c = new ArrayList<>(Arrays.asList("Select Sub-type","Credit/Debit Cards", "ID Card", "Other"));

        //======== ArrayList of Individual Sub type's Brand=============
        arrayList_adb = new ArrayList<>(Arrays.asList("Select Brand of Item","Bose", "Apple", "Boat", "Noise", "MI", "Realme","Other"));
        arrayList_lab = new ArrayList<>(Arrays.asList("Select Brand of Item","HP", "Dell", "Apple", "Lenovo", "Other"));
        arrayList_wb = new ArrayList<>(Arrays.asList("Select Brand of Item","Casio", "Titan Eye", "Oakley", "MI", "Apple","Titan","Rado", "G-Shock", "Other"));
        arrayList_fb = new ArrayList<>(Arrays.asList("Select Brand of Item","Nike", "Adidas", "Reebok", "Sparx", "Campus", "Crocs", "Decathlon", "Other"));
        arrayList_bb = new ArrayList<>(Arrays.asList("Select Brand of Item","Other"));
        arrayList_kb = new ArrayList<>(Arrays.asList("Select Brand of Item","Other"));
        arrayList_seb = new ArrayList<>(Arrays.asList("Select Brand of Item","Yonex", "Adidas", "Nike", "Puma", "Decathlon", "Cosco", "Other"));
        arrayList_cb = new ArrayList<>(Arrays.asList("Select Brand of Item","HDFC", "UCO Bank", "Slice", "Bennett ID", "Other"));

        //======== ArrayList of Colours=============
        arrayList_colour = new ArrayList<>(Arrays.asList("Select a base colour","Red", "Orange", "Pink", "Grey", "Black", "White", "Dark Green", "Light Green", "Yellow", "Light Blue", "Dark Blue", "Violet"));

        sp_item1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_ad);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_adb);
                }
                if(position == 1){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_la);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_lab);
                }
                if(position == 2){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_w);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_wb);
                }
                if(position == 3){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_f);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_fb);
                }
                if(position == 4){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_b);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_bb);
                }
                if(position == 5){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_k);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_kb);
                }
                if(position == 6){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_se);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_seb);
                }
                if(position == 7){
                    arrayAdapter_sub = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_c);
                    arrayAdapter_brand = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_cb);
                }
                sp_sub1.setAdapter(arrayAdapter_sub);
                sp_brand1.setAdapter(arrayAdapter_brand);
                arrayAdapter_colour = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_colour);
                sp_colour1.setAdapter(arrayAdapter_colour);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem();
            }
        });

    }

    private void saveItem() {
        String Item1 = sp_item1.getSelectedItem().toString().trim();
        String Sub1 = sp_sub1.getSelectedItem().toString().trim();
        String Brand1 = sp_brand1.getSelectedItem().toString().trim();
        String Color1 = sp_colour1.getSelectedItem().toString().trim();

        Journal journal = new Journal();
        journal.setItem(Item1);
        journal.setSub(Sub1);
        journal.setBrand(Brand1);
        journal.setColor(Color1);

        collectionReference.add(journal)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent i1 = new Intent(Lost_Form.this,LostFragment.class);
                        startActivity(i1);
                    }
                });
    }
}