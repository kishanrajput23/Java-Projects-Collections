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

public class Found_Form extends AppCompatActivity {


    Button button;
    Spinner sp_item, sp_sub, sp_brand, sp_colour;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final CollectionReference collectionReference = db.collection("Found");


    ArrayList<String> arrayList_item;
    ArrayAdapter<String> arrayAdapter_item;

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
        setContentView(R.layout.activity_found_form);
        sp_item = (Spinner) findViewById(R.id.sp_item);
        sp_sub = (Spinner) findViewById(R.id.sp_sub);
        sp_brand = (Spinner) findViewById(R.id.sp_brand);
        sp_colour = (Spinner) findViewById(R.id.sp_colour);
        button = findViewById(R.id.button);

        arrayList_item = new ArrayList<>(Arrays.asList("Audio Devices","Laptop and Accessories","Wearables", "Footwear", "Bottles", "Keys", "Sports Equipment", "Any type of Card"));
        arrayAdapter_item = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_item);
        sp_item.setAdapter(arrayAdapter_item);

        //======== ArrayList of Individual Sub types=============
        arrayList_ad = new ArrayList<>(Arrays.asList("Select Sub-type", "Speakers", "Over-ear Headphones", "On-ear Headphones", "Collar Earphones", "Wired Earphones", "True Wireless Earphones", "Can't Specify"));
        arrayList_la = new ArrayList<>(Arrays.asList("Select Sub-type", "Laptop", "Keyboard", "Mouse", "Storage Devices", "Charger", "Laptop Sleeve", "Can't Specify"));
        arrayList_w = new ArrayList<>(Arrays.asList("Select Sub-type", "Spectacles", "Watches", "Jewellery", "Caps", "Mufflers", "Gloves", "Can't Specify"));
        arrayList_f = new ArrayList<>(Arrays.asList("Select Sub-type","Shoes", "Slippers", "Sandals", "Can't Specify"));
        arrayList_b = new ArrayList<>(Arrays.asList("Select Sub-type","Steel Bottles", "Gym Bottles", "Can't Specify"));
        arrayList_k = new ArrayList<>(Arrays.asList("Select Sub-type","Car Keys", "Room Keys", "Locker Keys", "Can't Specify"));
        arrayList_se = new ArrayList<>(Arrays.asList("Select Sub-type","Racquets", "Ball", "Shuttle Cock", "Can't Specify"));
        arrayList_c = new ArrayList<>(Arrays.asList("Select Sub-type","Credit/Debit Cards", "ID Card", "Can't Specify"));

        //======== ArrayList of Individual Sub type's Brand=============
        arrayList_adb = new ArrayList<>(Arrays.asList("Select Brand of Item","Bose", "Apple", "Boat", "Noise", "MI", "Realme","Can't Specify"));
        arrayList_lab = new ArrayList<>(Arrays.asList("Select Brand of Item","HP", "Dell", "Apple", "Lenovo", "Can't Specify"));
        arrayList_wb = new ArrayList<>(Arrays.asList("Select Brand of Item","Casio", "Titan Eye", "Oakley", "MI", "Apple","Titan","Rado", "G-Shock", "Can't Specify"));
        arrayList_fb = new ArrayList<>(Arrays.asList("Select Brand of Item","Nike", "Adidas", "Reebok", "Sparx", "Campus", "Crocs", "Decathlon", "Can't Specify"));
        arrayList_bb = new ArrayList<>(Arrays.asList("Select Brand of Item","Can't Specify"));
        arrayList_kb = new ArrayList<>(Arrays.asList("Select Brand of Item","Can't Specify"));
        arrayList_seb = new ArrayList<>(Arrays.asList("Select Brand of Item","Yonex", "Adidas", "Nike", "Puma", "Decathlon", "Cosco", "Can't Specify"));
        arrayList_cb = new ArrayList<>(Arrays.asList("Select Brand of Item","HDFC", "UCO Bank", "Slice", "Bennett ID", "Can't Specify"));

        //======== ArrayList of Colours=============
        arrayList_colour = new ArrayList<>(Arrays.asList("Select a base colour","Red", "Orange", "Pink", "Grey", "Black", "White", "Dark Green", "Light Green", "Yellow", "Light Blue", "Dark Blue", "Violet"));

        sp_item.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                sp_sub.setAdapter(arrayAdapter_sub);
                sp_brand.setAdapter(arrayAdapter_brand);
                arrayAdapter_colour = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_colour);
                sp_colour.setAdapter(arrayAdapter_colour);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem();
            }
        });

    }

    private void saveItem() {
        String Item = sp_item.getSelectedItem().toString().trim();
        String Sub = sp_sub.getSelectedItem().toString().trim();
        String Brand = sp_brand.getSelectedItem().toString().trim();
        String Color = sp_colour.getSelectedItem().toString().trim();

        Journal journal = new Journal();
        journal.setItem(Item);
        journal.setSub(Sub);
        journal.setBrand(Brand);
        journal.setColor(Color);

        collectionReference.add(journal)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Intent i = new Intent(Found_Form.this,FoundFragment.class);
                        startActivity(i);
                    }
                });
    }
}