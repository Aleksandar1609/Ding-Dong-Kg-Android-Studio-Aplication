package com.example.dingdong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int notificationId=1;
    Button refreshdugme;
    EditText email;
    RecyclerView recyclerView,recyclerView1;
    private NotificationManagerCompat notificationManager;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,databaseReference2,databaseReference3;

    List<FetchData> fetchData,fetchData1;
    HelperAdapter helperAdapter,helperAdapter1;
    DatabaseReference databaseReference1;

    Calendar calendar = Calendar.getInstance();
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    String time = format.format(calendar.getTime());
    String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshdugme=(Button)findViewById(R.id.refreshdugme);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView1=findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        notificationManager = NotificationManagerCompat.from(this);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("KrajSmene");


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          baza();
                                      }
                                  },
                0, 10000);
        refreshdugme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baza();
            }
        });


    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }



    public void baza(){
        fetchData=new ArrayList<>();
        databaseReference1= FirebaseDatabase.getInstance().getReference("Vozac 7");
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    FetchData fetchDatalist=ds.getValue(FetchData.class);
                    fetchData.add(fetchDatalist);
                }

                helperAdapter=new HelperAdapter(fetchData);
                recyclerView.setAdapter(helperAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        fetchData1=new ArrayList<>();
        databaseReference2= FirebaseDatabase.getInstance().getReference("IzvrsenePorudzbine7");
        databaseReference2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    FetchData fetchDatalist1=ds.getValue(FetchData.class);
                    fetchData1.add(fetchDatalist1);
                    Collections.reverse(fetchData1);

                }

                helperAdapter1=new HelperAdapter(fetchData1);
                recyclerView1.setAdapter(helperAdapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}