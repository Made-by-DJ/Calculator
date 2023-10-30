package nl.madebydj.calculator;

import android.util.Log;

import java.text.DecimalFormat;

public class Numbers {

    private String value1;
    private String value2;

    Numbers(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String calculate(String operator, Numbers numbers) {

        Double calculated = 0d;
        Double convertedvalue1;
        Double convertedvalue2;

        if (value1.contains("-")) {
            convertedvalue1 = Double.parseDouble(value1);
        } else {
            convertedvalue1 = Double.valueOf(value1);
        }

        if (value2.contains("-")) {
            convertedvalue2 = Double.parseDouble(value2);
        } else {
            convertedvalue2 = Double.valueOf(value2);
        }

        switch(operator) {
            case "+":
                calculated = convertedvalue1 + convertedvalue2;
                break;
            case "-":
                calculated = convertedvalue1 - convertedvalue2;
                break;
            case "*":
                calculated = convertedvalue1 * convertedvalue2;
                break;
            case "/":
                calculated = convertedvalue1 / convertedvalue2;
        }
        DecimalFormat format = new DecimalFormat("0.####");
        return format.format(calculated);
    }
}
