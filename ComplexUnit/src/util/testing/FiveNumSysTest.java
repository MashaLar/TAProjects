import util.fivenumsys.NumSysTranslate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiveNumSysTest {
    //class for unit testing of methods from class NumSysTranslate

    @Test
    public void FiveNumSysInt_From() {

        //Input
        String fromFiveNumSysInt = NumSysTranslate.FromFiveNumSysInt("1334243400",16);

        //Expect
        String expected = "345ABC";

        //Output
        assertEquals("(4+5i)(6+5i) = -1+50i",expected,fromFiveNumSysInt);

    }

    @Test
    public void FiveNumSysInt_To() {

        //Input
        String toFiveNumSysInt = NumSysTranslate.ToFiveNumSysInt("345ABC",16);

        //Expect
        String expected = "1334243400";

        //Output
        assertEquals("(4+5i)(6+5i) = -1+50i",expected,toFiveNumSysInt);

    }

    @Test
    public void FiveNumSysFract_From() {

        //Input
        String fromFiveNumSysFract = NumSysTranslate.FromFiveNumSysFract("20.2132",2,16);

        //Expect
        String expected = "A.77";

        //Output
        assertEquals("(4+5i)(6+5i) = -1+50i",expected,fromFiveNumSysFract);


    }

    @Test
    public void FiveNumSysFract_To() {

        //Input
        String toFiveNumSysFract = NumSysTranslate.ToFiveNumSysFract("A.78",16,4);

        //Expect
        String expected = "20.2132";

        //Output
        assertEquals("(4+5i)(6+5i) = -1+50i",expected,toFiveNumSysFract);

    }
}
