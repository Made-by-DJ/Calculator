package nl.madebydj.calculator;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Integer value1 = 0, value2 = 0;
    String operator = "", output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        Button button = (Button) view;
        String input = button.getText().toString();

        if (input.matches(".*\\d.*") && operator.equals("")) {
            output = output + input;
            value1 = value1 + Integer.valueOf(input);
        } else if (!input.matches(".*\\d.*") && !value1.equals(0) && operator.equals("")) {
            output = output + input;
            operator = input;
        } else if (input.matches(".*\\d.*") && !value1.equals(0) && !operator.equals("")) {
            output = output + input;
            value2 = value2 + Integer.valueOf(input);
        }
        ((TextView) findViewById(R.id.textView)).setText(output);
        //Log.d("testid", value1);
    }
}