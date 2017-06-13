package com.yee.speedymath;

/*
* Deanna Yee
* CIS 135 OL
* File Name: MainMenuActivity.java
* File Description: contains the class definition for the main menu activity
* Assignment #: final
* Date: 5/18/17
*/

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button startButton;
    private Button instructionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        startButton = (Button) findViewById(R.id.start);
        instructionButton = (Button) findViewById(R.id.instructions);

        startButton.setOnClickListener(this);
        instructionButton.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.start:
                createIntent();
                break;
            case R.id.instructions:
                createInstructionDialog();
                break;
        }
    }

    //create intent to go to choose symbol activity
    public void createIntent(){
        Intent intent = new Intent(MainMenuActivity.this, SymbolActivity.class);
        startActivity(intent);
    }

    //create and show dialog to start the game
    public void createInstructionDialog(){
        AlertDialog.Builder alertStartDialogBuilder = new AlertDialog.Builder(this);
        alertStartDialogBuilder.setTitle("Instructions");
        alertStartDialogBuilder.setMessage("Click the start button to begin choosing your " +
                "mathematical symbol, time, and number. Click the button with the mathematical" +
                "symbol you would like to use. Click the number you would like to use. Click the" +
                "menu button at the top right corner to change the timer. The default timer is 1" +
                "minute. Solve as many problems as you can within the time limit. Answer the" +
                "problems by putting your answer in the answer box and hitting the check mark." )
                .setCancelable(false)
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        AlertDialog alertStartDialog = alertStartDialogBuilder.create();
        alertStartDialog.show();
    }
}
