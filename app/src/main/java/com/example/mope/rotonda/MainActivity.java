package com.example.mope.rotonda;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.mope.rotonda.MESSAGE";
    private Button button_sbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        button_sbm = (Button) findViewById(R.id.button_sbm);
        final EditText editText = (EditText) findViewById(R.id.edit_message);
//        button_sbm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(
//                        MainActivity.this,editText.getText(),Toast.LENGTH_SHORT
//                ).show();
//            }
//        });
        button_sbm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert_Builder = new AlertDialog.Builder(MainActivity.this);
                alert_Builder.setMessage("Do you really want to close this app?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("no",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                });
                AlertDialog alert = alert_Builder.create();
                alert.setTitle("Alert !!!");
                alert.show();

            }
        });


    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {

//        Intent sendIntent = new Intent();
//        sendIntent.setAction(Intent.ACTION_SEND);
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
//        sendIntent.setType("text/plain");
//        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));

        Intent intent = new Intent();
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setAction(Intent.ACTION_SEND);
        startActivity(intent.createChooser(intent,getResources().getText(R.string.app_name)));
    }
}
