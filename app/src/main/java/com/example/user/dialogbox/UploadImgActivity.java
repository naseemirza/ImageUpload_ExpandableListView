package com.example.user.dialogbox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UploadImgActivity extends AppCompatActivity {

    ImageView image1, image2;
    //EditText imgname;
    Button choose, upload;
    int PICK_IMAGE_REQUEST = 111;
    int PICK_IMAGE_REQUEST1 = 222;
    public static final String URL ="https://www.itshades.com/appwebservices/test.php?";
    Bitmap bitmap, bitmap1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_img);

        image1 = (ImageView)findViewById(R.id.image1);
        image2 = (ImageView)findViewById(R.id.image2);
        //imgname=(EditText)findViewById(R.id.editTextname);
        //choose = (Button)findViewById(R.id.choose);
        upload = (Button)findViewById(R.id.upload);

       // opening image chooser option
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST1);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(UploadImgActivity.this);
                progressDialog.setMessage("Uploading, please wait...");
                progressDialog.show();
               // final String Imagename = imgname.getText().toString().trim();

                //Log.e("image", Imagename);

               // encode
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageBytes = baos.toByteArray();
                final String imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT);

                ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
                bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, baos1);
                byte[] imageBytes1 = baos1.toByteArray();
                final String imageString1 = Base64.encodeToString(imageBytes1, Base64.DEFAULT);

                //Log.e("image", String.valueOf(imageString));

                //URL
                String url="http://clonescriptsmart.com/redhealth/hs-api/phpexpert_hospital_image.php";
                StringRequest request = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>(){
                    @Override
                    public void onResponse(String s) {
                        Log.e("responce", s);
                        progressDialog.dismiss();

                        try {
                            JSONObject obj = new JSONObject(s);
//                            String success=obj.getString("s");
//                            String error=obj.getString("e");
//                            String msg=obj.getString("m");

                            String success=obj.getString("success");
                            String msg=obj.getString("success_msg");

                            if(success.equalsIgnoreCase("1")){
                            Toast.makeText(UploadImgActivity.this, msg, Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(UploadImgActivity.this, msg, Toast.LENGTH_LONG).show();
                        }

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(UploadImgActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                },new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(UploadImgActivity.this, volleyError.getMessage(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                       // parameters.put("imagename", Imagename);
                        parameters.put("hospital_image", imageString);
                        parameters.put("hospital_image2", imageString1);
                        return parameters;
                    }
                };

                RequestQueue rQueue = Volley.newRequestQueue(UploadImgActivity.this);
                rQueue.add(request);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                image1.setImageBitmap(bitmap);
               // image2.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (requestCode == PICK_IMAGE_REQUEST1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();

            try {

                bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //image1.setImageBitmap(bitmap);
                image2.setImageBitmap(bitmap1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


