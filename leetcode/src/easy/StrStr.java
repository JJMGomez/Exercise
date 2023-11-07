package easy;

public class StrStr {

    public static void main(String[] args){
        StrStr strStr = new StrStr();
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr.strStr(haystack,needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int haystack_index = 0;
        while(haystack_index+needle.length() <= haystack.length()){
            int needle_index = 0;
            int index = haystack_index;
            while(needle_index < needle.length()){
                if (haystack.charAt(index) != needle.charAt(needle_index)){
                    break;
                }
                index ++;
                needle_index++;
            }
            if (needle_index == needle.length()){
                return haystack_index;
            }
            haystack_index ++;
        }
        return  -1;
    }
}
