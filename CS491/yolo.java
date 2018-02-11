package com.app.intrinsic.intrinsicapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Random rand = new Random();
    int choco = 0,vanilla = 0,meatz = 0, drinkother = 0, drinksonly = 0, dessertsonly = 0, drinkvanilla = 0, drinkchoco = 0;
    int nosweets = 0, dessertchoco = 0, dessertvanilla = 0, dessertother = 0, nomeat = 0, food = 0, sweetsonly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button secondpbutton = (Button) findViewById(R.id.secondpbutton);
        Button rollgo = (Button) findViewById(R.id.roll);
        Button dietcheck = (Button) findViewById(R.id.vegetarian);
        Button chococheck = (Button) findViewById(R.id.choco);
        Button vanillacheck = (Button) findViewById(R.id.vanilla);
        Button drinkcheck = (Button) findViewById(R.id.onlydrink);
        Button dessertcheck = (Button) findViewById(R.id.onlydessert);
        Button sweetscheck = (Button) findViewById(R.id.sweetsnone);
        Button sweetsonlycheck = (Button) findViewById(R.id.onlysweets);

        //drinks
        String[] drinkothers = new String[]{"jasmine tea","latte","milk tea","taro bubble tea","green tea"};
        String[] drinkvanillas = new String[]{"vanilla milkshake","vanilla tea"};
        String[] drinkchocolates = new String[]{"chocolate milkshake","chocolate tea"};

        //desserts
        String[] dessertothers = new String[]{"cake","cupcake"};
        String[] dessertchocolates = new String[]{"choco cupcake", "choco cake"};
        String[] dessertvanillas = new String[]{"vanilla cupcake", "vanilla cake"};

        //savory
        String[] meats = new String[]{"cheeseburger","chicken"};
        String[] nonmeats = new String[]{"salad"};

        List<String> output = new ArrayList<>();

        //conditions
        sweetsonlycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweetsonlycheck.setBackgroundColor(Color.DKGRAY);
                if(sweetsonly == 1){
                    sweetsonlycheck.setBackgroundResource(R.drawable.button);
                    sweetsonly = 0;
                    meatz = 0;
                    nomeat = 0;
                    return;
                }
                sweetsonly = 1;
            }
        });
        sweetscheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sweetscheck.setBackgroundColor(Color.DKGRAY);
                if(nosweets == 1){
                    sweetscheck.setBackgroundResource(R.drawable.button);
                    nosweets = 0;
                    dessertvanilla = 0;
                    dessertchoco = 0;
                    dessertother = 0;
                    drinkvanilla = 0;
                    drinkchoco = 0;
                    drinkother = 0;
                    return;
                }
                nosweets = 1;
            }
        });
        dessertcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dessertcheck.setBackgroundColor(Color.DKGRAY);
                if(dessertsonly == 1){
                    dessertcheck.setBackgroundResource(R.drawable.button);
                    dessertsonly = 0;
                    drinkvanilla = 0;
                    drinkchoco = 0;
                    drinkother = 0;
                    meatz = 0;
                    nomeat = 0;
                    return;
                }
                dessertsonly = 1;
            }
        });
        drinkcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drinkcheck.setBackgroundColor(Color.DKGRAY);
                if(drinksonly == 1){
                    drinkcheck.setBackgroundResource(R.drawable.button);
                    drinksonly = 0;
                    dessertvanilla = 0;
                    dessertchoco = 0;
                    dessertother = 0;
                    meatz = 0;
                    nomeat = 0;
                    return;
                }
                drinksonly = 1;
            }
        });
        chococheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chococheck.setBackgroundColor(Color.DKGRAY);
                if(choco == 1){
                    chococheck.setBackgroundResource(R.drawable.button);
                    choco = 0;
                    dessertchoco = 0;
                    drinkchoco = 0;
                    meatz = 0;
                    nomeat = 0;
                    return;
                }
                choco = 1;
            }
        });

        vanillacheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vanillacheck.setBackgroundColor(Color.DKGRAY);
                if(vanilla == 1){
                    vanillacheck.setBackgroundResource(R.drawable.button);
                    vanilla = 0;
                    dessertvanilla = 0;
                    drinkvanilla = 0;
                    meatz = 0;
                    nomeat = 0;
                    return;
                }
                vanilla = 1;
            }
        });

        dietcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dietcheck.setBackgroundColor(Color.DKGRAY);
                if(meatz == 1){
                    dietcheck.setBackgroundResource(R.drawable.button);
                    meatz = 0;
                    return;
                }
                meatz = 1;
            }
        });

        secondpbutton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                goToMainActivity();

            }

        });

        rollgo.setOnClickListener(new View.OnClickListener() {

            @Override
            //concatenate food arrays
            public void onClick(View v) {

                if(nosweets == 1) {
                    dessertvanilla = 1;
                    dessertchoco = 1;
                    dessertother = 1;
                    drinkvanilla = 1;
                    drinkchoco = 1;
                    drinkother = 1;
                }
                if(sweetsonly == 1){
                    meatz = 1;
                    nomeat = 1;
                }
                if(dessertsonly == 1){
                    drinkvanilla = 1;
                    drinkchoco = 1;
                    drinkother = 1;
                    meatz = 1;
                    nomeat = 1;
                }
                if(drinksonly == 1){
                    dessertvanilla = 1;
                    dessertchoco = 1;
                    dessertother = 1;
                    meatz = 1;
                    nomeat = 1;
                }
                if(choco == 1){
                    dessertchoco = 1;
                    drinkchoco = 1;
                    meatz = 1;
                    nomeat = 1;
                }
                if(vanilla == 1){
                    dessertvanilla = 1;
                    drinkvanilla = 1;
                    meatz = 1;
                    nomeat = 1;
                }
                if(drinkvanilla == 0){
                    Collections.addAll(output,drinkvanillas);
                }
                if(drinkchoco == 0){
                    Collections.addAll(output,drinkchocolates);
                }
                if(dessertvanilla == 0){
                    Collections.addAll(output,dessertvanillas);
                }
                if(dessertchoco == 0){
                    Collections.addAll(output,dessertchocolates);
                }
                if(meatz == 0){
                    Collections.addAll(output,meats);
                }
                if(nomeat == 0){
                    Collections.addAll(output,nonmeats);
                }
                if(drinkother == 0){
                    Collections.addAll(output,drinkothers);
                }
                if(dessertother == 0){
                    Collections.addAll(output,dessertothers);
                }

                String[] finalArray = output.toArray(new String[output.size()]);
                TextView yolo = (TextView) findViewById(R.id.text);

                int random = rand.nextInt(finalArray.length);
                //yolo.setText(String.valueOf(finalArray[random]));
                yolo.setText(String.valueOf(finalArray.length));
                output.clear();

            }

        });

    }


    private void goToMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

    private void goToSecondActivity() {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);

    }
}

