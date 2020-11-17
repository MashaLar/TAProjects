package util.complex;

import models.ComplexNumber;

public class ComplexMath {
    //class for operations on complex numbers (+,-,/,*)

    //add methods(CompNum+CompNum, real+CompNum, imagine+CompNum)
    public static ComplexNumber Add(ComplexNumber first, ComplexNumber second){
        return new ComplexNumber(first.getReal()+second.getReal(), first.getImagine()+second.getImagine());
    }
    public static ComplexNumber Add(double real, ComplexNumber ComplexNum){
        return new ComplexNumber(real+ComplexNum.getReal(), ComplexNum.getImagine());
    }
    public static ComplexNumber Add(ComplexNumber ComplexNum, double imagine){
        return new ComplexNumber(ComplexNum.getReal(), imagine+ComplexNum.getImagine());
    }

    //subtract methods(CompNum-CompNum, real-CompNum, imagine-CompNum, CompNum-real, CompNum-imagine)
    public static ComplexNumber Subtraction(ComplexNumber minuend, ComplexNumber subtrahend){
        return new ComplexNumber(minuend.getReal()-subtrahend.getReal(),
                minuend.getImagine()-subtrahend.getImagine());
    }
    public static ComplexNumber SubtractionReal(double minuend, ComplexNumber subtrahend){
        return new ComplexNumber(minuend-subtrahend.getReal(), -subtrahend.getImagine());
    }
    public static ComplexNumber SubtractionReal(ComplexNumber minuend, double subtrahend){
        return new ComplexNumber(minuend.getReal()-subtrahend, minuend.getImagine());
    }
    public static ComplexNumber SubtractionImagine(double minuend, ComplexNumber subtrahend){
        return new ComplexNumber(-subtrahend.getReal(), minuend-subtrahend.getImagine());
    }
    public static ComplexNumber SubtractionImagine(ComplexNumber minuend, double subtrahend){
        return new ComplexNumber(minuend.getReal(), subtrahend-minuend.getImagine());
    }

    //multiply methods(CompNum*CompNum, real*CompNum)
    public static ComplexNumber Multiply(ComplexNumber first, ComplexNumber second){
        return new ComplexNumber(first.getReal()*second.getReal()-first.getImagine()*second.getImagine(),
                first.getImagine()*second.getReal()+second.getImagine()*first.getReal());
    }
    public static ComplexNumber Multiply(ComplexNumber ComplexNum, double constant){
        return new ComplexNumber(ComplexNum.getReal()*constant,ComplexNum.getImagine()*constant);
    }

    //method for multiply complex number with itself but imagine part is negative
    private static double OppositeMultiply(ComplexNumber cn){
        return (double)(cn.getReal()*cn.getReal()+cn.getImagine()*cn.getImagine()) ;
    }

    //divide methods (CompNum/CompNum, CompNum/real)
    public static ComplexNumber Divide(ComplexNumber dividend, double divider){
        return new ComplexNumber(dividend.getReal()/divider,dividend.getImagine()/divider);
    }
    public static ComplexNumber Divide(ComplexNumber dividend, ComplexNumber divider){
        ComplexNumber numerator = Multiply(dividend, new ComplexNumber(divider.getReal(),-divider.getImagine()));
        double denominator = OppositeMultiply(divider);
        return Divide(numerator, denominator);
    }

}
