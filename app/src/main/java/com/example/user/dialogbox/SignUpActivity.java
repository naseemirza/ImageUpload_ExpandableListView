package com.example.user.dialogbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextPassword;
    RadioGroup radioGroupGender;
    ProgressBar progressBar;
    Button button_rg;
    private static String REG_URL="https://www.itshades.com/appwebservices/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGender);
        button_rg=(Button)findViewById(R.id.buttonRegstr);

        button_rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));

//                int selectedId = radioGroupGender .getCheckedRadioButtonId();
//
//                // find the radio button by returned id
//                RadioButton radioButton = (RadioButton) findViewById(selectedId);
//                String gndr=radioButton.getText().toString();
//
//                Log.e("gender",gndr);
                //Regst();
            }
        });

    }

    private void Regst(){
        progressBar.setVisibility(View.VISIBLE);
        //button_rg.setVisibility(View.GONE);

        final String username = this.editTextUsername.getText().toString().trim();
        final String email = this.editTextEmail.getText().toString().trim();
        final String password = this.editTextPassword.getText().toString().trim();
        final String gender = ((RadioButton) findViewById(this.radioGroupGender.getCheckedRadioButtonId())).getText().toString();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, REG_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        try {
                            JSONObject obj = new JSONObject(response);
                            String aray= obj.getString("success");
                            if (aray.equals("1")){
                                Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(SignUpActivity.this,"Error"+e.toString(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            //button_rg.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUpActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        //button_rg.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
                params.put("gender", gender);
                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


       // VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

}
