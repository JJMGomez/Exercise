public class LeetcodeSolution_10 {
    //第一种解法，递归fa
    public boolean isMatch(String s, String p) {
        //首先判断pattern为空的情况
        if (p.isEmpty()){
            return s.isEmpty();
        }
        //处理pattern长度为1的情况
        if (p.length()==1){
            //s的长度必须为1
            if (s.length() != 1){
                return false;
            }
            else
                return p.charAt(0)==s.charAt(0) || p.charAt(0)=='.';
        }
        //处理pattern长度大于1的情况
        //情况1：如果pattern的第二位不为*，那么只需要匹配一位
        if (p.charAt(1) != '*'){
            //考虑s的长度
            if (s.isEmpty()){
                return false;
            }
            else
                //需要同时满足两个条件：1.第一位相同；2.从第二位开始匹配结果也为true
                return (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1),p.substring(1));
        }
        //下面处理第二位为*的情况 这时不能立即判断s是否为空，因为可能存在*匹配了零次的情况
        else{
            while (!s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.')){
                //处理*为重复零次的情况
                if (isMatch(s,p.substring(2))){
                    return true;
                }
                //如果*不是匹配零次，则从
                s = s.substring(1);
            }
        }
        return isMatch(s,p.substring(2));
    }

    public static void main(String[] args){
        String s = "a";
        String p = "ab*";
        LeetcodeSolution_10 solution = new LeetcodeSolution_10();
        System.out.print(solution.isMatch(s,p));
    }
}
