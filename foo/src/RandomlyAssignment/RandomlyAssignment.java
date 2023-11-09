package RandomlyAssignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class RandomlyAssignment {
    public static int solution(String n, int b){
        HashMap<String,Integer> resultMap = new HashMap<>();
        int count = 0;
        String nextOne = getNextOne(n,b);
        while(null == resultMap.get(nextOne)){
            resultMap.put(nextOne,count);
            count++;
            nextOne = getNextOne(nextOne,b);
        }
        if (null != resultMap.get("0")){
            return 1;
        }else{
            return count-resultMap.get(nextOne);
        }
    }

    public static String getNextOne(String n, int b){
        char[] charList = n.toCharArray();
        int length = charList.length;
        List<Integer> numList = new ArrayList<>();
        for (int i=0; i<charList.length; i++){
            numList.add(Integer.parseInt(String.valueOf(charList[i])));
        }

        //min->max
        numList.sort(Comparator.naturalOrder());
        //b=10
        int minNum = 0;
        for (int i=0; i<numList.size(); i++){
            minNum += numList.get(i) * Math.pow(b,length-i-1);
        }


        //max>min
        numList.sort(Comparator.reverseOrder());
        int maxNum = 0;
        for (int i=0; i<numList.size(); i++){
            maxNum += numList.get(i) * Math.pow(b,length-i-1);
        }
        String diff = Integer.toString(maxNum-minNum,b);
        return diff;
    }

    public static void main(String[] args) {
        int result = solution("1211",10);
        System.out.println(result);
    }
}
