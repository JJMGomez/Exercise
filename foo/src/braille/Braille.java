package braille;

import java.util.HashMap;
import java.util.Map;

public class Braille {

    public static Map<Character, String> map = new HashMap<>();

    public static String solution(String s) {
        init("braille","000001110000111010100000010100111000111000100010");
        init("The quick brown fox jumps over the lazy dog","000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110");;
        char[] inputCharList = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < inputCharList.length){
            if (Character.isUpperCase(inputCharList[index])){
                result.append(map.get('1'));
                result.append(map.get(Character.toLowerCase(inputCharList[index])));
                index ++;
            }else if(' ' == inputCharList[index]){
                result.append(map.get('0'));
                index ++;
            }else{
                result.append(map.get(inputCharList[index]));
                index ++;
            }
        }
        return result.toString();
    }
    public static void init(String sentence,String inputCode){
        char[] sentenceCharList = sentence.toCharArray();
        int senteceIndex = 0;
        int codeIndex = 0;
        while (senteceIndex < sentenceCharList.length){
            int curCodeIndex = codeIndex;
            if (Character.isUpperCase(sentenceCharList[senteceIndex])){
                map.computeIfAbsent('1', k -> inputCode.substring(6 * curCodeIndex, 6 * curCodeIndex + 6));
                codeIndex ++;
                map.computeIfAbsent(Character.toLowerCase(sentenceCharList[senteceIndex]),k -> inputCode.substring(6 * (curCodeIndex+1), 6 * (curCodeIndex+1) + 6));
            } else if (' ' == sentenceCharList[senteceIndex]){
                map.computeIfAbsent('0', k -> inputCode.substring(6 * curCodeIndex, 6 * curCodeIndex + 6));
            } else{
                map.computeIfAbsent(sentenceCharList[senteceIndex], k -> inputCode.substring(6 * curCodeIndex, 6 * curCodeIndex + 6));
            }
            codeIndex ++;
            senteceIndex ++;
        }
    }

    public static void main(String[] args) {
        System.out.println(Braille.solution("code"));
    }
}
