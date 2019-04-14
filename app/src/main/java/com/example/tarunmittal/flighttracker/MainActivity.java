package com.example.tarunmittal.flighttracker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarunmittal.flighttracker.Adapter.ArrivalListAdapter;
import com.example.tarunmittal.flighttracker.ApiClient.ApiClient;
import com.example.tarunmittal.flighttracker.Interface.ApiInterface;
import com.example.tarunmittal.flighttracker.Model.Arrival;
import com.example.tarunmittal.flighttracker.Model.Data;
import com.example.tarunmittal.flighttracker.Model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    ArrivalListAdapter mArrivalListAdapter;

    EditText flightText;

    Button submit;

    ProgressDialog progressDoalog;

    RecyclerView flightList;

    ApiInterface mApiInterface;

    private String TAG = MainActivity.class.toString();

    private String api_key = "9568a0-8ff8d3";

    TextView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flightText = findViewById(R.id.edittext);
        submit = findViewById(R.id.submit);
        mView=findViewById(R.id.flight_data);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Please Wait..");
                progressDoalog.setTitle("Loading!");
                progressDoalog.show();
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<Data> call = mApiInterface.getArrivalFlights(flightText.getText().toString());

                call.enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                        progressDoalog.dismiss();
                        String display="";
                        Data data=response.body();
                        List<Arrival> arrivalList=data.arrivalList;
                        for(Arrival arrival:arrivalList)
                        {
                            String a=arrival.getIataCode();
                            String b=arrival.getIcaoCode();
                            display =a+b;
                        }
                        mView.setText(display);
                     }

                    @Override
                    public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {

                        progressDoalog.dismiss();
                        Toast.makeText(MainActivity.this, "Error in Parsing", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void getArrivalFlights(List<Arrival> arrivalList) {

        mArrivalListAdapter = new ArrivalListAdapter(this, arrivalList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        flightList.setLayoutManager(layoutManager);
        flightList.setAdapter(mArrivalListAdapter);
    }

}
