package com.example.baiso2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuanLyCa extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ConCa> arrayList;
    private ConCaAdapter adtCa;
    private Button btnback;
    FirebaseDatabase fdb;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyca);

        btnback = findViewById(R.id.btnBackk);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });

        arrayList = new ArrayList<>();
        getData();
        adtCa = new ConCaAdapter(QuanLyCa.this, R.layout.layout_item, arrayList);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adtCa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent();
                    intent.setClass(QuanLyCa.this, ChiTietCa.class);
                    startActivity(intent);
                } else if (i == 1){
                    Intent intent = new Intent();
                    intent.setClass(QuanLyCa.this, ChiTietCa.class);
                    startActivity(intent);
                } else if (i == 2){
                    Intent intent = new Intent();
                    intent.setClass(QuanLyCa.this, ChiTietCa.class);
                    startActivity(intent);
                }
            }
        });

        private  void getData(){
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("QuanLyCacLoaiCa");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot data : snapshot.getChildren()){
                        ConCa ca = data.getValue(ConCa.class);
                        if(ca != null){
                            ca.setId(data.getKey());
                            adtCa.add(ca);
                        }
                    }
                    Toast.makeText(getApplicationContext(),"Thành công !",Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(),"Thất bại !" + error.toString(),Toast.LENGTH_SHORT).show();
                    Log.d("MYTAG","onCancelled: " + error.toString());
                }
            });
        }

        fdb = FirebaseDatabase.getInstance();
        ref = fdb.getReference("ConCa");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {

                   ConCa ca = ds.getValue(ConCa.class);
                    arrayList.add(ca);
                }
                listView.setAdapter(adtCa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void logIn() {
        Intent intent = new Intent(QuanLyCa.this, LogIn.class);
        startActivity(intent);
    }
}