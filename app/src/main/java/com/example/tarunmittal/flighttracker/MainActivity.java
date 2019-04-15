package com.example.tarunmittal.flighttracker;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tarunmittal.flighttracker.Adapter.ArrivalListAdapter;
import com.example.tarunmittal.flighttracker.ApiClient.ApiClient;
import com.example.tarunmittal.flighttracker.Interface.ApiInterface;
import com.example.tarunmittal.flighttracker.Model.Departure;
import com.example.tarunmittal.flighttracker.Model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {

    ArrivalListAdapter mArrivalListAdapter;

    AutoCompleteTextView flightText;

    EditText flightNumber;

    Button submit, search;

    ProgressDialog progressDoalog;

    RecyclerView flightList;

    ApiInterface mApiInterface;

    List<Example> mExampleList;

    List<Example> getAllFlights;

    ListView mView;

    private String TAG = MainActivity.class.toString();

    private String api_key = "9568a0-8ff8d3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flightText = findViewById(R.id.edittext);
        submit = findViewById(R.id.submit);
        mView = findViewById(R.id.flight_data);
        search = findViewById(R.id.search);
        flightNumber = findViewById(R.id.flight_text);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Please Wait..");
                progressDoalog.setTitle("Loading!");
                progressDoalog.show();
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<List<Example>> call = mApiInterface.getFlight(flightNumber.getText().toString());
                call.enqueue(new Callback<List<Example>>() {

                    @Override
                    public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                        progressDoalog.dismiss();
                        getAllFlights = response.body();
                        String[] code = new String[getAllFlights.size()];

                        code[0] = getAllFlights.get(0).getDeparture().getIataCode();
                        mView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, code));
                    }

                    @Override
                    public void onFailure(Call<List<Example>> call, Throwable t) {

                        progressDoalog.dismiss();
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                progressDoalog = new ProgressDialog(MainActivity.this);
                progressDoalog.setMessage("Please Wait..");
                progressDoalog.setTitle("Loading!");
                progressDoalog.show();
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<List<Example>> call = mApiInterface.getArrivalFlights(flightText.getText().toString());
                call.enqueue(new Callback<List<Example>>() {

                    @Override
                    public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                        progressDoalog.dismiss();
                        String s = "";
                        mExampleList = response.body();
                        Departure[] examples = new Departure[mExampleList.size()];
                        String[] code = new String[mExampleList.size()];

                        for (int i = 0; i < mExampleList.size(); i++) {
                            examples[i] = mExampleList.get(i).getDeparture();
                            code[i] = mExampleList.get(i).getDeparture().getIataCode();
                        }
                        mView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, code));
                        int size = mExampleList.size();
                        String n = Integer.toString(size);

                    }

                    @Override
                    public void onFailure(Call<List<Example>> call, Throwable t) {

                        progressDoalog.dismiss();
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
