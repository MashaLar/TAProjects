package models.complex;

import java.util.Objects;

public class ComplexNumber {
    // Class for realization complex number (z=a+bi)

    private double real;
    private double imagine;

    public ComplexNumber(double a, double b) {
        if ((a == 0 && b == 0)) {
            System.out.println("All params can`t equal 0!");
        }
        else {
            this.real = a;
            this.imagine = b;
        }
    }

    public ComplexNumber(String val) {
        try {
            if (val.matches("(-?\\d+(\\.\\d)?i?[-+]?)*")) {
                String nums[] = val.split("(\\+|(?=-))");
                for (String num : nums) {
                    if (num.contains("i")) {
                        num = num.replaceAll("i", "");
                        this.imagine += Double.parseDouble(num);
                    }
                    if (!num.contains("i")) {
                        this.real += Double.parseDouble(num);
                    }
                }
            } else {
                System.out.println("---Wrong expression!---");
            }
        }catch (Exception e){System.out.println("---Wrong expression!---");}
    }

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
                    imagine +
                    "i ;";
        }
        else {
            return "z = " +
                    real +
                    " + " + imagine +
                    "i ;";
        }
    }


}
