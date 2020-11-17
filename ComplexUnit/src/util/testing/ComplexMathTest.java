import util.complex.ComplexMath;
import models.ComplexNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexMathTest {
    //class for unit testing of methods from class ComplexMath

    @Test
    public void add_ComplexPlusComplex_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        //Expect
        ComplexNumber expected = new ComplexNumber(10, 10);

        //Output
        assertEquals("4+5i + 6+5i = 10+10i", expected, ComplexMath.Add(c1, c2));
    }

    @Test
    public void add_ComplexPlusImagine_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 5;

        //Expect
        ComplexNumber expected = new ComplexNumber(4, 10);

        //Output
        assertEquals("4+5i + 5i = 4+10i", expected, ComplexMath.Add(c1, c2));

    }

    @Test
    public void subtractionReal_RealMinusComplex_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 5;

        //Expect
        ComplexNumber expected = new ComplexNumber(1, -5);

        //Output
        assertEquals("5 - (4+5i) = 1-5i", expected, ComplexMath.SubtractionReal(c2, c1));

    }

    @Test
    public void subtractionImagine_ImagineMinusComplex_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        double c2 = 6;

        //Expect
        ComplexNumber expected = new ComplexNumber(-4, 1);

        //Output
        assertEquals("6i - (4+5i) = -4+1i", expected, ComplexMath.SubtractionImagine(c2, c1));

    }

    @Test
    public void Multiply_ComplexMultiplyComplex_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        //Expect
        ComplexNumber expected = new ComplexNumber(-1, 50);

        //Output
        assertEquals("(4+5i)(6+5i) = -1+50i", expected, ComplexMath.Multiply(c1, c2));

    }

    @Test
    public void Divide_ComplexDivideComplex_ResultPass() {

        //Input
        ComplexNumber c1 = new ComplexNumber(4, 5);
        ComplexNumber c2 = new ComplexNumber(6, 5);

        //Expect
        ComplexNumber expected = new ComplexNumber(49, 10);

        //Output
        assertEquals("(4+5i)/(6+5i) = (49+10i)/61", ComplexMath.Divide(expected,61), ComplexMath.Divide(c1, c2));

    }

}