package com.example.user.dialogbox;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
     Button imgupldbutton ,buttonReg,buttonnewrg,buttonexp,buttonDlg,buttonUploadimg, buttonpdf;
    TextView ampmtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ampmtextView=(TextView)findViewById(R.id.ampmtext);

        buttonpdf = (Button) findViewById(R.id.buttonpdf);
        buttonpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PDFViewverActivity.class));
            }
        });

        buttonDlg = (Button) findViewById(R.id.buttonDlg1);
        buttonDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                                  //DialogActivity
                startActivity(new Intent(MainActivity.this,NewUploadImgActivity.class));
            }
        });


        buttonUploadimg = (Button) findViewById(R.id.buttonupldimg);

        buttonUploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                                                             //ImageUploadActivity
                     startActivity(new Intent(MainActivity.this,WebviewActivity.class));
            }
        });



        imgupldbutton = (Button) findViewById(R.id.imgupld);
        imgupldbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UploadImgActivity.class));
            }
        });



        buttonReg = (Button) findViewById(R.id.buttonR);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegActivity.class));
            }
        });

        buttonnewrg = (Button) findViewById(R.id.buttonreg);
        buttonnewrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegActivity.class));
            }
        });

        buttonexp = (Button) findViewById(R.id.buttonexp);
        buttonexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ExpandableActivity.class));
            }
        });


//        button.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//
//                final Dialog dialog = new Dialog(context);
//                dialog.setContentView(R.layout.custom);
//
//                TextView am=(TextView)dialog.findViewById(R.id.amtext);
//                final String amser=am.getText().toString();
//
//               TextView pm=(TextView)dialog.findViewById(R.id.pmtext);
//               final String pmser=pm.getText().toString();
//
//                Log.e("Id", amser);
//
//                am.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ampmtextView.setText(amser);
//                        dialog.dismiss();
//                    }
//                });
//
//                pm.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ampmtextView.setText(pmser);
//                        dialog.dismiss();
//                    }
//                });
//
//                dialog.getWindow().setDimAmount(0.90f);
//
//                ImageView dialogButton = (ImageView) dialog.findViewById(R.id.button_d);
//                dialogButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        dialog.dismiss();
//                    }
//                });
//
//                dialog.show();
//            }
//        });
    }

    }



