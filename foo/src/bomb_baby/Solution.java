package bomb_baby;

import java.math.BigInteger;

public class Solution {
    public static String solution(String x, String y){
        BigInteger intX = new BigInteger(x);
        BigInteger intY = new BigInteger(y);
        BigInteger count = BigInteger.valueOf(0);
        while(intX.compareTo(intY)!=0 && intX.compareTo(BigInteger.valueOf(1))>=0 && intY.compareTo(BigInteger.valueOf(1))>=0) {
            if (intX.compareTo(intY)>0){
                count = count.add(intX.subtract(BigInteger.valueOf(1)).divide(intY));
                intX = intX.subtract(intX.subtract(BigInteger.valueOf(1)).divide(intY).multiply(intY));
            }else{
                count = count.add(intY.subtract(BigInteger.valueOf(1)).divide(intX));
                intY = intY.subtract(intY.subtract(BigInteger.valueOf(1)).divide(intX).multiply(intX));
            }

        }
        if (intX.compareTo(BigInteger.valueOf(1))==0 && intY.compareTo(BigInteger.valueOf(1))==0) {
            return count.toString();
        }
        return "impossible";
    }
    public static String solutionA(String x, String y){
        BigInteger intX = new BigInteger(x);
        BigInteger intY = new BigInteger(y);
        BigInteger count = BigInteger.valueOf(0);
        while(intX.compareTo(BigInteger.valueOf(1))>=0 && intY.compareTo(BigInteger.valueOf(1))>=0){
            if (intX.compareTo(BigInteger.valueOf(1)) == 0 && intY.compareTo(BigInteger.valueOf(1)) == 0){
                break;
            }
            if (intX.compareTo(intY)>0){
                intX = intX.subtract(intY);
                count = count.add(BigInteger.valueOf(1));
                continue;
            }
            if (intX.compareTo(intY)<0){
                intY = intY.subtract(intX);
                count = count.add(BigInteger.valueOf(1));
                continue;
            }
            return "impossible";
        }
        if (intX.compareTo(BigInteger.valueOf(1))==0 && intY.compareTo(BigInteger.valueOf(1))==0) {
            return count.toString();
        }
        return "impossible";
    }

    public static void main(String[] args) {
        System.out.println(solution("2","1"));
    }
}
