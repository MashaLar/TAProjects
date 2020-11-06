package models.complex;

public class ComplexMath {
    //class for operations on complex numbers (+,-,/,*)

    public static ComplexNumber Add(ComplexNumber first, ComplexNumber second){
        return new ComplexNumber(first.getReal()+second.getReal(), first.getImagine()+second.getImagine());
    }

    public static ComplexNumber Add(double real, ComplexNumber ComplexNum){
        return new ComplexNumber(real+ComplexNum.getReal(), ComplexNum.getImagine());
    }

    public static ComplexNumber Add(ComplexNumber ComplexNum, double imagine){
        return new ComplexNumber(ComplexNum.getReal(), imagine+ComplexNum.getImagine());
    }


    public static ComplexNumber Subtraction(ComplexNumber minuend, ComplexNumber subtrahend){
        return new ComplexNumber(minuend.getReal()-subtrahend.getReal(),
                minuend.getImagine()-subtrahend.getImagine());
    }

    public static ComplexNumber SubtractionReal(double minuend, ComplexNumber subtrahend){
        return new ComplexNumber(minuend-subtrahend.getReal(), subtrahend.getImagine());
    }

    public static ComplexNumber SubtractionReal(ComplexNumber minuend, double subtrahend){
        return new ComplexNumber(minuend.getReal()-subtrahend, minuend.getImagine());
    }

    public static ComplexNumber SubtractionImagine(double minuend, ComplexNumber subtrahend){
        return new ComplexNumber(subtrahend.getReal(), minuend-subtrahend.getImagine());
    }

    public static ComplexNumber SubtractionImagine(ComplexNumber minuend, double subtrahend){
        return new ComplexNumber(minuend.getReal(), subtrahend-minuend.getImagine());
    }


    public static ComplexNumber Multiply(ComplexNumber first, ComplexNumber second){
        return new ComplexNumber(first.getReal()*second.getReal()-first.getImagine()*second.getImagine(),
                first.getImagine()*second.getReal()+second.getReal()*first.getReal());
    }

    public static ComplexNumber Multiply(ComplexNumber ComplexNum, double constant){
        return new ComplexNumber(ComplexNum.getReal()*constant,ComplexNum.getImagine()*constant);
    }


    private static double OppositeMultiply(ComplexNumber cn){
        return (double)(cn.getReal()*cn.getReal()+cn.getImagine()*cn.getImagine()) ;
    }


    public static ComplexNumber Devide(ComplexNumber dividend, double divider){
        return new ComplexNumber(dividend.getReal()/divider,dividend.getImagine()/divider);
    }

    public static ComplexNumber Devide(ComplexNumber dividend, ComplexNumber divider){
        ComplexNumber numerator = Multiply(dividend, divider);
        double denominator = OppositeMultiply(divider);
        return Devide(numerator, denominator);
    }


}
