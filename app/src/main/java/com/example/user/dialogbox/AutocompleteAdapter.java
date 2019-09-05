package com.example.user.dialogbox;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by User on 31-Oct-18.
 */

public class AutocompleteAdapter extends ArrayAdapter implements Filterable {
    private ArrayList mCountry;
    private String COUNTRY_URL = "https://ae.priceomania.com/assets/search/compare.json?";

    public AutocompleteAdapter(Context context, int resource) {
        super(context, resource);
        mCountry = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mCountry.size();
    }

    @Override
    public Country getItem(int position) {
        return (Country) mCountry.get(position);
    }

    @Override
    public Filter getFilter() {
       Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if(constraint != null){
                    try{
                        //get data from the web
                        String term = constraint.toString();
                        //mCountry = new DownloadCountry().execute(term).get();
                    }catch (Exception e){
                        Log.d("HUS","EXCEPTION "+e);
                    }
                    filterResults.values = mCountry;
                    filterResults.count = mCountry.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if(results != null && results.count > 0){
                    notifyDataSetChanged();
                }else{
                    notifyDataSetInvalidated();
                }
            }
        };

        return myFilter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.auto_complete_layout,parent,false);

        //get Country
        Country contry = (Country) mCountry.get(position);

        TextView countryName = (TextView) view.findViewById(R.id.countryName);

        countryName.setText(contry.getName());

        return view;
    }

    //download mCountry list
    private abstract class DownloadCountry extends AsyncTask{


        protected ArrayList doInBackground(String... params) {
            try {
                //Create a new COUNTRY SEARCH url Ex "search.php?term=india"
                String NEW_URL = COUNTRY_URL + URLEncoder.encode(params[0],"UTF-8");
                Log.d("HUS", "JSON RESPONSE URL " + NEW_URL);

                URL url = new URL(NEW_URL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null){
                    sb.append(line).append("\n");
                }

                //parse JSON and store it in the list
                String jsonString =  sb.toString();
                ArrayList countryList = new ArrayList<>();

                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    //store the country name
                    Country country = new Country();
                    country.setName(jo.getString("label"));
                    countryList.add(country);
                }

                //return the countryList
                return countryList;

            } catch (Exception e) {
                Log.d("HUS", "EXCEPTION " + e);
                return null;
            }
        }
    }

}
