package com.example.dingdong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    HelperAdapter2 helperAdapter2;
    RecyclerView recyclerViewsSecond,recyclerView1;
    Button primio,isporucio,vratise,pozovi;
    FirebaseDatabase firebaseDatabase,firebaseDatabase1,firebaseDatabase2,firebaseDatabase3;
    DatabaseReference databaseReference,databaseReference1,databaseReference2,databaseReference3;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    String time = format.format(calendar.getTime());
    String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
    ClipboardManager myClipboard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerViewsSecond=findViewById(R.id.recyclerViewSecond);
        recyclerView1=findViewById(R.id.recyclerView);
        primio=(Button)findViewById(R.id.primio);
        isporucio=(Button)findViewById(R.id.isporucio);
        vratise=(Button)findViewById(R.id.vratisenazad);
        pozovi=(Button)findViewById(R.id.pozovi);
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        final Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        final FetchData fetchData=(FetchData)bundle.getSerializable("key");
        recyclerViewsSecond.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add(fetchData.getAdresa());
        arrayList.add(fetchData.getBroj());
        arrayList.add(fetchData.getBrojtelefona());
        arrayList.add(fetchData.getIme());
        arrayList.add(fetchData.getInterfon());
        arrayList.add(fetchData.getKorisnik());
        arrayList.add(fetchData.getNapomena());
        final String broj2=fetchData.getBroj().toString();
        final String strNew = broj2.replace("Broj telefona:", "");
        arrayList.add(fetchData.getNaselje());
        arrayList.add(fetchData.getSprat());
        arrayList.add(fetchData.getStan());
        arrayList.add(fetchData.getVreme());
        arrayList.add(fetchData.getVremeporudzbine());

        helperAdapter2=new HelperAdapter2(arrayList);
        recyclerViewsSecond.setAdapter(helperAdapter2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("PrimljenePorudzbine");

        firebaseDatabase1 = FirebaseDatabase.getInstance();
        databaseReference1 = firebaseDatabase1.getReference("Vozac 7");

        firebaseDatabase2 = FirebaseDatabase.getInstance();
        databaseReference2 = firebaseDatabase2.getReference("ZavrsenePorudzbine");

        firebaseDatabase3 = FirebaseDatabase.getInstance();
        databaseReference3 = firebaseDatabase3.getReference("IzvrsenePorudzbine7");
        primio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String broj1=" "+fetchData.getBroj();
                String korisnik=fetchData.getKorisnik();
                String vozac="Dusko";
                post1();
                ClipData myClip;
                myClip = ClipData.newPlainText("text", strNew);
                myClipboard.setPrimaryClip(myClip);

            }
        });
        pozovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData myClip;
                myClip = ClipData.newPlainText("text", strNew);
                myClipboard.setPrimaryClip(myClip);

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+strNew));
                if (ActivityCompat.checkSelfPermission(SecondActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        vratise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
        isporucio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
                String key=fetchData.getKey();
                databaseReference1
                        .child(key)
                        .removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                startActivity(new Intent(SecondActivity.this,MainActivity.class));

            }
        });
    }

    private void post() {
        final Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();
        final FetchData fetchData=(FetchData)bundle.getSerializable("key");
        PostBrisanje postb=new PostBrisanje(fetchData.getAdresa().toString(),
                fetchData.getBroj().toString(),
                fetchData.getBrojtelefona().toString(),
                fetchData.getIme().toString(),
                fetchData.getInterfon().toString(),
                "key",fetchData.getKorisnik().toString(),
                fetchData.getNapomena().toString(),
                fetchData.getNaselje().toString(),
                fetchData.getSprat().toString(),
                fetchData.getStan().toString(),
                fetchData.getVreme().toString(),
                fetchData.getVremeporudzbine().toString(),
                time);

        databaseReference2.push().setValue(postb);
        databaseReference3.push().setValue(postb);
    }
    private void post1() {
        final Intent intent=this.getIntent();
        Bundle bundle=intent.getExtras();

        final FetchData fetchData=(FetchData)bundle.getSerializable("key");
        PostPrimljenePorudzbine postb=new PostPrimljenePorudzbine(fetchData.getAdresa().toString(),fetchData.getBroj().toString(),fetchData.getBrojtelefona().toString(),fetchData.getIme().toString(),fetchData.getInterfon().toString(),
                "key",fetchData.getKorisnik().toString(),fetchData.getNapomena().toString(),fetchData.getNaselje().toString(),fetchData.getSprat().toString(),fetchData.getStan().toString(),fetchData.getVreme().toString(),fetchData.getVremeporudzbine().toString(),time);

        databaseReference.push().setValue(postb);


    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }
}
