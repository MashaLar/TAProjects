import models.complex.ComplexMath;
import models.fivenumsys.NumSysTranslate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FiveNumSysTest {
    //class for unit testing of methods from class NumSysTranslate

    @Test
    public void FiveNumSysInt_16Num345ABC_Result() {

        String toFiveNumSysInt = NumSysTranslate.ToFiveNumSysInt("345ABC",16);
        String fromFiveNumSysInt = NumSysTranslate.FromFiveNumSysInt("1334243400",16);

        assertEquals("(4+5i)(6+5i) = -1+50i","345ABC",fromFiveNumSysInt);
        assertEquals("(4+5i)(6+5i) = -1+50i","1334243400",toFiveNumSysInt);

    }

    @Test
    public void FiveNumSysFract_16Num345ABC_Result() {

        String toFiveNumSysFract = NumSysTranslate.ToFiveNumSysFract("A.78",16,4);
        String fromFiveNumSysFract = NumSysTranslate.FromFiveNumSysFract("20.2132",2,16);

        assertEquals("(4+5i)(6+5i) = -1+50i","A.77",fromFiveNumSysFract);
        assertEquals("(4+5i)(6+5i) = -1+50i","20.2132",toFiveNumSysFract);

    }
}
