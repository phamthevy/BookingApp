package com.bku.appbooking;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class utils {
    public static ArrayList<Product> product = new ArrayList<>();
    public static void getJsonFromUrl(final Context context, String url){
        url = "https://style.vihey.com/api/category.php?id=1&fbclid=IwAR1bCQ_67xmkA8s2T_zULgBeYVnCPlOrGHkhzqaix7q5PK5gq60n6soueCo";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Toast.makeText(context, "Get json Success", Toast.LENGTH_LONG).show();
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(context, "Some error occurred!!", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(context);
        rQueue.add(request);
    }
    private static void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            Iterator<String> keys = object.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Log.v("list key", key);
                if(object.get(key) instanceof JSONObject) {
                    JSONObject product_json = object.getJSONObject(key);
                    String tilte = product_json.optString("tieude");
                    String price = product_json.optString("price");
                    String imgUrl = product_json.optString("image");
                    product.add(new Product(tilte, price, imgUrl, ""));
                } else if (object.get(key) instanceof String){
                    String value = object.getString("type");
                    Log.v("key = type", "value = " + value);
                }
            }
        } catch (JSONException e) {

        }
    }
}
