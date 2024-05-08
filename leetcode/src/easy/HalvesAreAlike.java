package easy;
/**
 * Leetcode 1704
 * date：2024/1/12
 * */
public class HalvesAreAlike {
    public boolean halvesAreAlike(String s) {

        char[] charList = s.toLowerCase().toCharArray();
        int count = 0;
        for (int i=0; i<charList.length/2; i++){
            if (charList[i]=='a' || charList[i]=='e' || charList[i]=='i'
                    ||charList[i]=='o'
                    ||charList[i]=='u'){
                count ++;
            }
        }
        for (int i=charList.length/2; i<charList.length; i++){
            if (charList[i]=='a' || charList[i]=='e' || charList[i]=='i'
                    ||charList[i]=='o'
                    ||charList[i]=='u'){
                count --;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "qwfdsf";
        System.out.print(s.length());
    }
}
