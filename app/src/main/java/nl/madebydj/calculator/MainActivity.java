package nl.madebydj.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Numbers numbers = new Numbers("", "");
    Helpers helpers = new Helpers("", false, false,true,false, false,false, true,false);
    String output = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleClick(View view) {
        Button button = (Button) view;
        String input = button.getText().toString();

        if (input.matches(".*\\d.*") && !helpers.getValue1() && !helpers.getIsEqual()) {

            output = helpers.handleValue(true, input, numbers);

        } else if (input.equals("+/-") && !helpers.getIsEqual()) {

            output = helpers.handlePlusMinus(numbers);

        } else if (input.equals(".") && !helpers.getIsEqual()) {

            output = helpers.handlePeriod(numbers, input);

        } else if ((input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) && !helpers.getValue1() && !helpers.getIsEqual()) {

            output = helpers.handleOperator(input, numbers);

        } else if (input.matches(".*\\d.*") && helpers.getIsOperator() && !helpers.getValue2() && !helpers.getIsEqual()) {

            output = helpers.handleValue(false, input, numbers);

        } else if (input.equals("=") && !helpers.getValue2() && !helpers.getIsEqual()) {

            output = numbers.calculate(helpers.getOperator(), numbers);
            helpers.setValue2(true);
            helpers.setIsEqual(true);

        } else if (input.equals("C")) {
            helpers.reset(numbers);
            output = "";
        }
        ((TextView) findViewById(R.id.textView)).setText(output);
    }
}