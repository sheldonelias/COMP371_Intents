/*

Intents

App designed to demonstrate how when one switches Activities, data can manually transfer from one
Activity to another. Or, if Activity is implicit, only required data transferred is allowed.

 */

package com.example.comp371_intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;

import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Passes the input_text EditText XML object to the variable
        inputText = findViewById(R.id.input_text);
    }


    public void onImplicitButtonClicked(View view)
    {
        //Uri type is for Uniform Resource Identifier, of with URL is one kind.
        Uri url = Uri.parse("http://www.google.com");

        //This constructor takes one of the Action constants known in the Android
        //user action group
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        //Calls the next activity, no specific Activity is called. By giving the ACTION_VIEW value
        //combined with a URL, all other components are excluded and by implicit deduction,
        //Android knows to start the external activity of a default browser.
        this.startActivity(intent);
    }

    public void onExplicitButtonClicked(View view)
    {
        String msg = "";

        //Recall inputText has in it input_text from the XML file
        // Asks if the inputText object NOT isEmpty(). An empty textbox does not give a string ""
        // like it does in other APIs or Python.
        if(!(inputText.getText().toString().isEmpty()))
        {
            //Loads the text in the inputText into msg
            msg =  inputText.getText().toString();
        } else
            // If the the inputText was empty, gives msg a value
            msg = "Hello from MainActivity";

        // Used to demonstrate data can transfer that user never sees.
        int localVar = 25;

        // Use of Explicit constructor with this Activity and next Activity.
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        // Sends the user defined manually given variable as key-value pair. First arg
        // is the name of the variable to travel to the next Activity.
        intent.putExtra("message", msg);

        // Sends the user defined manually given variable as key-value pair. First arg
        // is the name of the variable to travel to the next Activity.
        intent.putExtra("local variable", localVar);

        // Calls the next activity, a specific Activity is called. By giving an Intent object
        // that specifies MainActivity component, Intent can preserve last state and carry
        // forward any data from first intent to next. Second arg is the new Activity named
        // SecondActivity.
        this.startActivity(intent);
    }
}