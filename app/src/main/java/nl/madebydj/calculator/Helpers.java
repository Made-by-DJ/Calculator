package nl.madebydj.calculator;

public class Helpers {

    private String operator;
    private Boolean isValue1, isPeriodValue1, isPositiveValue1, isOperator, isValue2, isPeriodValue2, isPositiveValue2, isEqual;

    public Helpers(String operator, Boolean isValue1, Boolean isPeriodValue1, Boolean isPositiveValue1, Boolean isOperator, Boolean isValue2, Boolean isPeriodValue2, Boolean isPositiveValue2, Boolean isEqual) {
        this.operator = operator;
        this.isOperator = isOperator;
        this.isValue1 = isValue1;
        this.isPeriodValue1 = isPeriodValue1;
        this.isPositiveValue1 = isPositiveValue1;
        this.isValue2 = isValue2;
        this.isPeriodValue2 = isPeriodValue2;
        this.isPositiveValue2 = isPositiveValue2;
        this.isEqual = isEqual;
    }

    public String getOperator() {
        return operator;
    }

    public Boolean getIsOperator() {
        return isOperator;
    }

    public Boolean getValue2() {
        return isValue2;
    }

    public void setValue2(Boolean isValue2) {
        this.isValue2 = isValue2;
    }

    public Boolean getIsEqual() {
        return isEqual;
    }

    public void setIsEqual(Boolean isEqual) {
        this.isEqual = isEqual;
    }

    public Boolean getValue1() {
        return isValue1;
    }

    public String handleValue(Boolean firstvalue, String input, Numbers numbers) {
        String output;
        if (firstvalue) {
            if (numbers.getValue1() == null) {
                numbers.setValue1(input);
            } else {
                numbers.setValue1(numbers.getValue1() + input);
            }
            output = numbers.getValue1();
        } else {
            if (numbers.getValue2() == null) {
                numbers.setValue2(input);
            } else {
                numbers.setValue2(numbers.getValue2() + input);
            }
            output = numbers.getValue1() + " " + operator + " " + numbers.getValue2();
        }
        return output;
    }

    public String handlePlusMinus(Numbers numbers) {
        String output = "";
        if (!isValue1) {
            if (isPositiveValue1.equals(true)) {
                numbers.setValue1("-" + numbers.getValue1());
                isPositiveValue1 = false;

            } else if (isPositiveValue1.equals(false)) {
                numbers.setValue1(numbers.getValue1().replace("-", ""));
                isPositiveValue1 = true;
            }
            output = numbers.getValue1();

        } else if (isOperator) {
            if (isPositiveValue2.equals(true)) {
                numbers.setValue2("-" + numbers.getValue2());
                isPositiveValue2 = false;

            } else if (isPositiveValue2.equals(false)) {
                numbers.setValue2(numbers.getValue2().replace("-", ""));
                isPositiveValue2 = true;
            }
            output = numbers.getValue1() + " " + operator + " " + numbers.getValue2();
        }
        return output;
    }

    public String handlePeriod(Numbers numbers, String input) {
        String output = "";
        if (!isValue1 && !isPeriodValue1 && !numbers.getValue1().contains(".")) {
            output = numbers.getValue1() + input;
            numbers.setValue1(output);
            isPeriodValue1 = true;
        } else if (!isValue1 && isPeriodValue1 && numbers.getValue1().contains(".")) {
            output = numbers.getValue1();
        } else if (isValue1 && !isPeriodValue2 && !numbers.getValue2().contains(".")) {
            output = numbers.getValue1() + " " + operator + " " + numbers.getValue2() + input;
            numbers.setValue2(numbers.getValue2() + input);
            isPeriodValue2 = true;
        } else if (isValue1 && isPeriodValue2 && numbers.getValue2().contains(".")) {
            output = numbers.getValue1() + " " + operator + " " + numbers.getValue2();
        }
        return output;
    }

    public String handleOperator(String input, Numbers numbers) {
        String output = numbers.getValue1() + " " + input + " ";
        operator = input;
        isValue1 = true;
        isOperator = true;
        return output;
    }

    public void reset(Numbers numbers) {
        numbers.setValue1("");
        numbers.setValue2("");
        isValue1 = false;
        isPeriodValue1 = false;
        isPositiveValue1 = true;
        isOperator = false;
        operator = "";
        isValue2 = false;
        isPeriodValue2 = false;
        isPositiveValue2 = true;
        isEqual = false;
    }
}
