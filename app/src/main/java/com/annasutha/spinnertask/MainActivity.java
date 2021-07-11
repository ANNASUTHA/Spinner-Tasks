package com.annasutha.spinnertask;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private JSONArray jsonCountryArray;
    private Spinner countrySpinner;
    private Spinner stateSpinner;
    private Spinner citySpinner;

    private ArrayAdapter<String> countryAdapter;
    private ArrayAdapter<String> stateAdapter;
    private ArrayAdapter<String> cityAdapter;
    private String[] country;
    //private String[] stateVal;
    //private List<String> stateVal;
    ArrayList<String> CountryVal = new ArrayList<>();
    ArrayList<String[]> StateVal = new ArrayList<String[]>();
    ArrayList<String[]> CityVal = new ArrayList<String[]>();
    ArrayList<String> FCV = new ArrayList<>();
    List<String> numbers = new ArrayList<String>();
    List<String> myList = new ArrayList<>();
    String resultCountryValue;
    List<String> head;
    String[] finalCountryValue;
    String[] finalStateValue;
    String[] finalCityValue;
    private String[] state;
    private ImageButton imgBttn;
    private String[] k;
    private String c2;
    String source =
            "~IN*TN>CHENNAI>MADURAI>KOVAI>ERODE*AP>ONGOLE>TENALI>VIZAG" +
                    "*TS>HYDERABAD>WARANGAL>VIKARABAD~USA*ALASKA>JUNEAU>SITKA>KENAI" +
                    "~CHINA*HAINAN>HAIKOU>SANYA>DONGFANG*HUNAN>CHANGHSA>YUEYANG>" +
                    "CHANGDE";
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setTitle("Choose Your Area");
        countrySpinner = findViewById(R.id.spinner_country);
        stateSpinner = findViewById(R.id.spinner_state);
        citySpinner = findViewById(R.id.spinner_city);
        imgBttn = findViewById(R.id.imgBtn);

        imgBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

        country = source.split("~");
        for (String splitCountry: country) {
            String x = Arrays.toString(splitCountry.split("[*]"));
            CountryVal.add(x);
            countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, CountryVal);
            countrySpinner.setAdapter(countryAdapter);
        }
        for (String result: CountryVal){
            finalStateValue = result.split(">");
            StateVal.add(finalCountryValue);
            stateAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, CountryVal);
            stateSpinner.setAdapter(stateAdapter);
        }
        for (String results: CountryVal){
            finalCityValue = results.split(">");
            CityVal.add(finalCountryValue);
            cityAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, CountryVal);
            citySpinner.setAdapter(cityAdapter);
        }
        /*for (String splitCountry: country){
            //boolean y = splitCountry.startsWith(String.valueOf(0));
            String x = Arrays.toString(splitCountry.split("[*]"));
            CountryVal.add(x);
            countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, CountryVal);
            countrySpinner.setAdapter(countryAdapter);

            List<List<String>> output = new ArrayList<List<String>>();
            *//*for (int i=0; i < CountryVal.size()+1; i++) {
                String group = CountryVal.get(0);
                FCV.add(String.valueOf(group));
                //output.add(group);
                countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, FCV);
                countrySpinner.setAdapter(countryAdapter);
            }*//*
            //resultCountryValue = CountryVal.get(0);
            *//*System.out.println(resultCountryValue);
            for (int i = 0; i < CountryVal.size(); i++) {
                String current = myList.get(i);
                FCV.add(current);

                String grade = current.split(",")[0].substring(1);
            }*//*
                //resultCountryValue = CountryVal.indexOf(0);
                //Country Value is Final AANswer
                *//*countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, CountryVal);
                countrySpinner.setAdapter(countryAdapter);*//*
                //numbers.add(resultCountryValue);
                //head = Collections.singletonList(numbers.get(1));
                *//*countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, numbers);
                countrySpinner.setAdapter(countryAdapter);*//*
                //List<String> tail = numbers. subList(4, 8);
               *//* //resultCountryValue = c1.concat("");
                if(c1.contains(">")){
                    resultCountryValue = CountryVal.get(0);

                }*//*


                //finalCountryValue = c1.split("[>]");


        }*/

    /*national = source.split(~);
    state [];
    for x in national
                y = x.split(*);
    state.appnd(y)
            city
                    for in in range
                for m in navigateUpTo(k=m.split(>))
        city.appen(k)*/
        /*boolean countryList = source.startsWith("~");
        System.out.println( countryList);
        ArrayList<Boolean> countryList1 = new ArrayList<>();
        countryList1.add(countryList);
        countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,countryList1);
        countrySpinner.setAdapter(countryAdapter);*/
        /*String[] countrySplitValue = source.split("[~]");
        for ( int i= 0; i<countrySplitValue.length; i++){

        }*/
        //String countrySplitValue = String.valueOf(source.startsWith("~"));
        /*if(countrySplitValue.endsWith("*")){
            ArrayList<String> countryList = new ArrayList<>();
            countryList.add(countrySplitValue);
            countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,countryList);
            countrySpinner.setAdapter(countryAdapter);

        }*/
        //get country data
        //String splitValue = source.replaceAll("[~]","");
        //String[] splitValue = source.split("[~]" );
        /* for (int i = 0; i < splitValue.length; i++){
            if(i != 0){
                splitValue[i] = "~" + splitValue[i];
                ArrayList<String> countryList = new ArrayList<>();
                countryList.add(splitCountry);
            }
        }*/
        /*String[] splitValue = source.split("[~]");
        for (String splitCountry: splitValue) {
            //String split = splitValue[1];
            System.out.println(splitCountry);
            if ( splitCountry.contains("*")){
                String splitValue1 = source.replaceAll("[~*]","");
                splitValue1.endsWith("*");
                ArrayList<String> countryList = new ArrayList<>();
                countryList.add(splitValue1);

                countryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,countryList);
                countrySpinner.setAdapter(countryAdapter);
            }

        }*/
    }
    private void getCountryData() {

    }
    private void getStateData() {
        //get State data
        String[] splitValue = source.split("[*]");
        for (String splitState: splitValue) {
            System.out.println(splitState);
            ArrayList<String> stateList = new ArrayList<>();
                stateList.add(splitState);
                System.out.println(stateList);

        }


    }
    private void getCitiesData() {
        //get Cities data
        String[] splitValue = source.split("[>]");
        for (String splitCities: splitValue) {
            System.out.println(splitCities);
            ArrayList<String> cityList = new ArrayList<>();
            cityList.add(splitCities);
            System.out.println(cityList);
        }
    }

    /*private void populateSpinner(){
        countrySpinner.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }*/

}