package models;

import java.util.Objects;

public class ComplexNumber {
    // Class for realization complex number (z=a+bi)

    private double real; //real part of complex number (a)
    private double imagine; //imagine part of complex number (b)

    // Constructor for complex number which parametres is two double numbers
    public ComplexNumber(double a, double b) {
        if ((a == 0 && b == 0)) {
            System.out.println("All params can`t equal 0!");
        } else {
            this.real = a;
            this.imagine = b;
        }
    }

    // Constructor for complex number with string param
    public ComplexNumber(String val) {
        try {
            //check that string expression contains only +- between two numbers
            // which is not equal zero and can have 'i' after number
            if (val.matches("(-?[1-9]+(\\.\\d)?i?[-+]?)+|(-?\\d+(\\.\\d*[1-9]+)+i?[-+]?)+")) {
                //dividing string to array of numbers
                String[] nums = val.split("(\\+|(?=-))");
                for (String num : nums) {
                    if (num.contains("i")) {
                        //finding imagine numbers, replace 'i' from number and add to other part of imagine
                        num = num.replaceAll("i", "");
                        this.imagine += Double.parseDouble(num);
                    }
                    if (!num.contains("i")) {
                        //finding real numbers and add to other part of real
                        this.real += Double.parseDouble(num);
                    }
                }
            } else {
                System.out.println("---Wrong expression!---");
            }
        } catch (Exception e) {
            System.out.println("---Wrong expression!---");
        }
    }

    // Getters and Setters for class` variables
    public double getReal() {
        return real;
    }

    public void setReal(double a) {
        this.real = a;
    }

    public double getImagine() {
        return imagine;
    }

    public void setImagine(double b) {
        this.imagine = b;
    }

    // Overriding Object class methods for comparing two complex number and print it in string type
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.real, real) == 0 &&
                Double.compare(that.imagine, imagine) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imagine);
    }

    @Override
    public String toString() {
        if (imagine < 0) {
            return "z = " +
                    real +
                    " " + imagine +
                    "i";
        } else {
            return "z = " +
                    real +
                    " + " + imagine +
                    "i";
        }
    }
}

