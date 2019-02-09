import static java.lang.Character.isDigit;
import java.util.ArrayList;
public class LeetcodeSolution {
    public int myAtoi(String str) {
        boolean isDigit = false;
        char[] c = str.toCharArray();


        ArrayList num = new ArrayList();


        if (str == null){
            return 0;
        }


        for (int i = 0; i<c.length; i++){
            if(isDigit==true){ //如果当前是数字，那么只能输入数字，其他都不行
                if (isDigit(c[i])){
                    num.add(c[i]);
                }
                else{
                    return getNum(num);
                }
            }
            if (isDigit==false){ //如果当前还不是数字，那么可以接受 空格，+-和数字
                if(c[i] ==' '){
                    continue;
                }
                else if(c[i]=='+' || c[i]=='-' || isDigit(c[i]) ){
                    isDigit = true;
                    num.add(c[i]);
                }
                else{
                    return 0;
                }

            }

        }
        return getNum(num);
    }
    public int getNum(ArrayList lis){
        //将Arraylist转化成int
        if (lis.isEmpty()){
            return 0;
        }
        String s = "";
        for (Object item : lis){
            s+=item;
        }
        int result = 0;
        try{
            if (s.length()==1 && (s.equals("+") || s.equals("-"))){
                return 0;
            }
            result = Integer.parseInt(s);
            return result;
        }catch(NumberFormatException e){
            if (s.charAt(0)=='-'){
                return Integer.MIN_VALUE;
            }
            else if(s.charAt(0)>0){
                return Integer.MAX_VALUE;
            }
        }
        return result;
    }

    public int myAtoi_2(String str){
        int num = 0;
        str = str.trim();
        if (str.isEmpty()){
            return 0;
        }
        int sign=1;
        int i=0;
        if (str.charAt(i)=='+' || str.charAt(i)=='-'){
            sign = str.charAt(i++)=='+'?1:-1;  //先判断后加一
        }

        for (; i<str.length(); i++){
            if (isDigit(str.charAt(i))){
                int tmp = str.charAt(i)-'0';
                if (num > Integer.MAX_VALUE /10
                        || (num == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else
                    num = num * 10 + tmp;
            }
            else{
                return sign * num;
            }
        }

        return sign * num;
    }
    public static void main(String[] args){
        String s = "words and 987";
        LeetcodeSolution s1 = new LeetcodeSolution();
        System.out.print(s1.myAtoi_2(s));

    }
}