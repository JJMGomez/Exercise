package enroute_salute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int solution(String s){
        Map<Integer,Integer> resultMap = new HashMap<>();
        ArrayList<Integer> directionList = new ArrayList<>();
        for (char a: s.toCharArray()){
            if ('>' == a){
                directionList.add(0);
            }else if ('<' == a){
                directionList.add(1);
            }
        }
        for (int i=0; i<directionList.size(); i++){
            resultMap.put(i,0);
        }
        for (int i=0; i<directionList.size(); i++){
            if (1 == directionList.get(i)){
                for (int j=0; j<i; j++){
                    if (0 == directionList.get(j)){
                        resultMap.put(j,resultMap.get(j) + 1);
                        resultMap.put(i,resultMap.get(i) + 1);
                    }
                }
            }
        }
        int result = 0;
        for (int i=0; i<resultMap.size(); i++){
            result += resultMap.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("<<>><"));
    }
}
