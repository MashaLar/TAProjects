import models.complex.ComplexMath;
import models.complex.ComplexNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexMathTest {
    //class for unit testing of methods from class ComplexMath

    @Test
    public void add_4CN5iPlus6CN5i_10Result10i() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        ComplexNumber expected = new ComplexNumber(10, 10);

        assertEquals("4+5i + 6+5i = 10+10i", expected, ComplexMath.Add(c1, c2));
    }

    @Test
    public void add_4CN5iPlus5i_4Result10i() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 5;

        ComplexNumber expected = new ComplexNumber(4, 10);

        assertEquals("4+5i + 5i = 4+10i", expected, ComplexMath.Add(c1, c2));

    }

    @Test
    public void subtractionReal_5Minus4CN5i_1ResultNeg5i() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 5;

        ComplexNumber expected = new ComplexNumber(1, -5);

        assertEquals("5 - (4+5i) = 1-5i", expected, ComplexMath.SubtractionReal(c2, c1));

    }

    @Test
    public void subtractionImagine_6iMinus4CN5i_Neg4Result1i() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 6;

        ComplexNumber expected = new ComplexNumber(-4, 1);

        assertEquals("6i - (4+5i) = -4+1i", expected, ComplexMath.SubtractionImagine(c2, c1));

    }

    @Test
    public void Multiply_4CN5iMult6CN5i_Neg1Result50i() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        ComplexNumber expected = new ComplexNumber(-1, 50);

        assertEquals("(4+5i)(6+5i) = -1+50i", expected, ComplexMath.Multiply(c1, c2));

    }

    @Test
    public void Devide_4CN5iDev6CN5i_49dev61Result10idev61() {

        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        ComplexNumber expected = new ComplexNumber(49, 10);

        assertEquals("(4+5i)/(6+5i) = (49+10i)/61", ComplexMath.Divide(expected,61), ComplexMath.Divide(c1, c2));

    }

}