package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomNumberGenerator()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }
    public void onGuess(View view)
    {
        String message = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if (guessedNumber < 1 || guessedNumber > 20)
                message = "Tebak antara 1 - 20 !!";
            else if (guessedNumber > randomNumber)
                message = "Lebih rendah !!";
            else if (guessedNumber < randomNumber)
                message = "Lebih tinggi !!";
            else {
                message = "Yeayyy kamu benar !!";
                randomNumberGenerator();
            }
        } catch (Exception e){
            message = "isi tebakan mu";
        } finally {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}