package models.fivenumsys;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumSysTranslate {
    // Class for translate in anyfold number system

    private static BigInteger ToTenNumSysInt (String str, int system){

        BigInteger sys = BigInteger.valueOf(system);
        BigInteger integer = new BigInteger("0");
        str = str.toUpperCase();
        str = new StringBuffer(str).reverse().toString();
        char[] strArr = str.toCharArray();

        for (int c = 0; c<strArr.length; c++) {
            int num = strArr[c]-'0';
            BigInteger temp = new BigInteger("0");

            if(num <=9){
                temp = sys.pow(c);
                temp = temp.multiply(BigInteger.valueOf(num));
                integer= integer.add(temp);
            }
            else if((num-7)>9 && (num-7)<system && system>10){
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

    private static BigDecimal ToTenNumSysFract (String str, int system){

        BigDecimal sys = BigDecimal.valueOf(system);
        BigDecimal fractInt = new BigDecimal("0");
        str = str.toUpperCase();
        char[] strArr = str.toCharArray();

        for (int c = 0; c<strArr.length; c++) {
            int num = strArr[c]-'0';
            BigDecimal temp = new BigDecimal("0");

            if(num <=9){
                temp = (BigDecimal.valueOf(num)).divide(sys.pow((c+1)));
                fractInt= fractInt.add(temp);
            }
            else if((num-7)>9 && (num-7)<system && system>10){
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

    private static String CheckForWhileInToAnyNumSysInt(BigInteger num, int systemOut){
        String result ="";
        int intValue = num.intValue();
        if(intValue <=9) {
            result = num.toString();
        }
        else if(intValue>9 && intValue<systemOut && systemOut>10){
            result = Character.valueOf((char) ((intValue+7)+'0')).toString();
        }
        else{
            System.out.println("Something went wrong!");
        }
        return result;
    }


    public static String ToAnyNumSysInt (String str, int systemIn, int systemOut){

        BigInteger TenFol = ToTenNumSysInt(str,systemIn);
        BigInteger nums[] = TenFol.divideAndRemainder(BigInteger.valueOf(systemOut));
        String FiveFol = "";

        while(true)
        {

            FiveFol += CheckForWhileInToAnyNumSysInt(nums[1],systemOut);
            nums = nums[0].divideAndRemainder(BigInteger.valueOf(systemOut));

            if(nums[0] == BigInteger.valueOf(0)){
                FiveFol += CheckForWhileInToAnyNumSysInt(nums[1],systemOut);
                break;
            }
        }

        return new StringBuffer(FiveFol).reverse().toString();
    }

    public static String ToAnyNumSysFract (String str, int systemIn, int dote, int systemOut){

        String subStr[] = str.split("\\.");

        String anyFol = ToAnyNumSysInt(subStr[0], systemIn, systemOut)+".";

        BigDecimal tenFolFract = ToTenNumSysFract(subStr[1],systemIn);
        int fractLenght = tenFolFract.toString().length();
        BigDecimal temp = tenFolFract;

        for(int i = 0; i <= dote; i++){
            temp = temp.multiply(BigDecimal.valueOf(systemOut));
            String tempL = temp.toString();

            if(fractLenght < tempL.length()){
                int a = tempL.length() - fractLenght;
                BigInteger intPart = new BigInteger(tempL.substring(0,a));

                if(intPart.compareTo(BigInteger.valueOf(10))==-1){
                    anyFol += intPart.toString();
                }
                else if(systemOut >10 && intPart.compareTo(BigInteger.valueOf(systemOut))==-1
                        && intPart.compareTo(BigInteger.valueOf(9))==1){
                    int intValue = intPart.intValue()+7;
                    anyFol+= Character.valueOf((char) (intValue+'0'));

                }
                else{
                    System.out.println("Something went wrong!");
                }

                temp = new BigDecimal(tempL.substring(a));
            }
            if(fractLenght >= tempL.length()&&i>0){
                anyFol+="0";
            }
        }

        return anyFol;
    }


    public static String ToFiveNumSysInt (String str, int systemIn){

        return ToAnyNumSysInt(str,systemIn,5);
    }

    public static String ToFiveNumSysFract (String str, int systemIn, int dote){

        return ToAnyNumSysFract(str,systemIn,dote,5);
    }

    public static String FromFiveNumSysInt (String str, int systemOut){

        return ToAnyNumSysInt(str,5,systemOut);
    }

    public static String FromFiveNumSysFract (String str, int dote, int systemOut){

        return ToAnyNumSysFract(str,5,dote,systemOut);
    }

}

