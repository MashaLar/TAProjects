package util.fivenumsys;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumSysTranslate {
    // Class for translate in any number system

    // Translate to 10 number system an integer number
    private static BigInteger ToTenNumSysInt (String str, int system){
        BigInteger sys = BigInteger.valueOf(system);
        BigInteger integer = new BigInteger("0");
        str = str.toUpperCase(); //make lower case to upper for right number of letter
        str = new StringBuffer(str).reverse().toString(); //make reverse version of string
        char[] strArr = str.toCharArray(); //divide all symbols to array

        for (int c = 0; c<strArr.length; c++) {
            int num = strArr[c]-'0'; //get real number of symbol (nine symbol is equal 9 if subtract '0')
            BigInteger temp = new BigInteger("0");
            if(num <=9){
                //if number symbol doesn`t need letter, then new number equal
                //(systemIn^index_of_num)*number+previous_new_number
                temp = sys.pow(c);
                temp = temp.multiply(BigInteger.valueOf(num));
                integer= integer.add(temp);
            }
            else if((num-7)>9 && (num-7)<system && system>10){
                //if number symbol does need letter and system is bigger than 10, then new number equal
                //(systemIn^index_of_num)*(number-7)+previous_new_number
                //because number of letter is bigger for 7 degrees than system need (A equal 17, not 10)
                temp = sys.pow(c);
                temp = temp.multiply(BigInteger.valueOf(num-7));
                integer= integer.add(temp);
            }
            else{
                System.out.println("Wrong symbol!");
                integer= BigInteger.valueOf(0);
                break;
            }
        }

        return integer;
    }

    // Translate to 10 number system a fractional number
    private static BigDecimal ToTenNumSysFract (String str, int system){
        BigDecimal sys = BigDecimal.valueOf(system);
        BigDecimal fractInt = new BigDecimal("0");
        str = str.toUpperCase(); //make lower case to upper for right number of letter
        char[] strArr = str.toCharArray(); //divide all symbols to array

        for (int c = 0; c<strArr.length; c++) {
            int num = strArr[c]-'0'; //get real number of symbol (nine symbol is equal 9 if subtract '0')
            BigDecimal temp = new BigDecimal("0");
            if(num <=9){
                //if number symbol doesn`t need letter, then new number equal
                //previous_new_number+number/(systemIn^(index_of_num+1))
                temp = (BigDecimal.valueOf(num)).divide(sys.pow((c+1)));
                fractInt= fractInt.add(temp);
            }
            else if((num-7)>9 && (num-7)<system && system>10){
                //if number symbol does need letter and system is bigger than 10, then new number equal
                //previous_new_number+(number-7)/(systemIn^(index_of_num+1))
                //because number of letter is bigger for 7 degrees than system need (A equal 17, not 10)
                temp = BigDecimal.valueOf(num-7).divide(sys.pow((c+1)));
                fractInt= fractInt.add(temp);
                System.out.println(temp.toString());
            }
            else{
                System.out.println("Wrong symbol!");
                fractInt= BigDecimal.valueOf(0);
                break;
            }
        }

        return fractInt;
    }

    // Checking remainder for while cycle
    private static String CheckForWhileInToAnyNumSysInt(BigInteger num, int systemOut){
        String result ="";
        // translate num, to integer, because remainder is always will be less than 35
        int intValue = num.intValue();
        if(intValue <=9) {
            //if number symbol doesn`t need letter
            result = num.toString();
        }
        else if(intValue>9 && intValue<systemOut && systemOut>10){
            //if number symbol does need letter and system is bigger than 10
            result = Character.valueOf((char) ((intValue+7)+'0')).toString();
        }
        else{
            System.out.println("Something went wrong!");
        }
        return result;
    }

    // Translate in any number system an integer number
    public static String ToAnyNumSysInt (String str, int systemIn, int systemOut){
        BigInteger TenFol = ToTenNumSysInt(str,systemIn); //get number in 10 system
        //divide integer and fractional parts of result number_in10sys/systemOut
        BigInteger nums[] = TenFol.divideAndRemainder(BigInteger.valueOf(systemOut));
        String FiveFol = "";

        while(true)
        {
            //adding remainder in translated system
            FiveFol += CheckForWhileInToAnyNumSysInt(nums[1],systemOut);
            //new divide integer and fractional parts of result number_in10sys/systemOut
            nums = nums[0].divideAndRemainder(BigInteger.valueOf(systemOut));
            if(nums[0] == BigInteger.valueOf(0)){
                //do while remainder don`t equal zero
                //if remainder equals zero, then add remainder in translated system for the last time
                FiveFol += CheckForWhileInToAnyNumSysInt(nums[1],systemOut);
                break;
            }
        }

        return new StringBuffer(FiveFol).reverse().toString();
    }

    // Translate to any number system a fractional number
    public static String ToAnyNumSysFract (String str, int systemIn, int dote, int systemOut){
        String subStr[] = str.split("\\."); // get fractional and integer parts
        //Translate integer part of number
        String anyFol = ToAnyNumSysInt(subStr[0], systemIn, systemOut).replaceAll("^0","")+".";
        //start translating fractional part (translate to 10 number system)
        BigDecimal tenFolFract = ToTenNumSysFract(subStr[1],systemIn);
        BigDecimal temp = tenFolFract;
        //do cycle for user count of numbers after dote
        for(int i = 0; i < dote; i++){
            //multiply number to translated system
            temp = temp.multiply(BigDecimal.valueOf(systemOut));
            //get integer part
            BigInteger intPart = temp.toBigInteger();
            if(intPart.compareTo(BigInteger.valueOf(10))==-1){
                //if number symbol doesn`t need letter
                anyFol += intPart.toString();
            }
            else if(systemOut >10 && intPart.compareTo(BigInteger.valueOf(systemOut))==-1
                    && intPart.compareTo(BigInteger.valueOf(9))==1){
                //if number symbol does need letter and system is bigger than 10
                int intValue = intPart.intValue()+7;
                anyFol+= Character.valueOf((char) (intValue+'0'));
            }
            else{
                System.out.println("Something went wrong!");
            }
            //get only fractional part
            temp = temp.subtract(BigDecimal.valueOf(intPart.longValue()));
        }

        return anyFol;
    }

    // Translate to 5 number system an integer number
    public static String ToFiveNumSysInt (String str, int systemIn){

        return ToAnyNumSysInt(str,systemIn,5);
    }

    // Translate to 5 number system a fractional number
    public static String ToFiveNumSysFract (String str, int systemIn, int dote){

        return ToAnyNumSysFract(str,systemIn,dote,5);
    }

    // Translate from 5 number system an integer number
    public static String FromFiveNumSysInt (String str, int systemOut){

        return ToAnyNumSysInt(str,5,systemOut);
    }

    // Translate from 5 number system a fractional number
    public static String FromFiveNumSysFract (String str, int dote, int systemOut){

        return ToAnyNumSysFract(str,5,dote,systemOut);
    }

}

