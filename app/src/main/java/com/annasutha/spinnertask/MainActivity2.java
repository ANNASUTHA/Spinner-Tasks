package com.annasutha.spinnertask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private JSONArray jsonCountryArray;
    private Spinner countrySpinner1;
    private Spinner stateSpinner1;
    private Spinner citySpinner1;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        countrySpinner1 = findViewById(R.id.spinner_country1);
        stateSpinner1 = findViewById(R.id.spinner_state1);
        citySpinner1 = findViewById(R.id.spinner_city1);
        populateSpinner();
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void populateSpinner() {
        try {
            jsonCountryArray = new JSONObject(loadJSONFromAsset()).optJSONArray("country");

            ArrayList<String> countryList = new ArrayList<>();

            for (int i = 0; i < jsonCountryArray.length(); i++) {
                countryList.add(jsonCountryArray.optJSONObject(i).optString("name"));
            }

            ArrayAdapter<String> countryListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countryList);

            countrySpinner1.setAdapter(countryListAdapter);

            countrySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ArrayList<String> stateArray = new ArrayList<>();

                    final JSONArray jsonStateArray = jsonCountryArray.optJSONObject(position).optJSONArray("state");

                    for (int i = 0; i < jsonStateArray.length(); i++) {
                        stateArray.add(jsonStateArray.optJSONObject(i).optString("name"));
                    }

                    ArrayAdapter<String> stateListAdapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_spinner_dropdown_item, stateArray);

                    stateSpinner1.setAdapter(stateListAdapter);

                    stateSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final ArrayList<String> cityArray = new ArrayList<>();

                            final JSONArray jsonCityArray = jsonStateArray.optJSONObject(position).optJSONArray("city");

                            for (int i = 0; i < jsonCityArray.length(); i++) {
                                cityArray.add(jsonCityArray.optJSONObject(i).optString("name"));
                            }

                            ArrayAdapter<String> cityListAdapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_spinner_dropdown_item, cityArray);

                            citySpinner1.setAdapter(cityListAdapter);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getAssets().open("country.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void submit(View view) {
        int countryPosition = countrySpinner1.getSelectedItemPosition();
        int statePosition = stateSpinner1.getSelectedItemPosition();
        int cityPosition = citySpinner1.getSelectedItemPosition();

        int countryId = jsonCountryArray
                .optJSONObject(countryPosition)
                .optInt("id");

        int stateId = jsonCountryArray
                .optJSONObject(countryPosition)
                .optJSONArray("state")
                .optJSONObject(statePosition)
                .optInt("id");

        int cityId = jsonCountryArray
                .optJSONObject(countryPosition)
                .optJSONArray("state")
                .optJSONObject(statePosition)
                .optJSONArray("city")
                .optJSONObject(cityPosition)
                .optInt("id");

        try {
            JSONObject result = new JSONObject()
                    .put("countryId", countryId)
                    .put("stateId", stateId)
                    .put("cityId", cityId);


        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
}