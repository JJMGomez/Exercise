//请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy.",则输出"We%20are%20happy."
//注意：在原字符串上进行替换，并且保证输入的字符串后面有足够多的空余内存。

public class Task5 {
    public void ReplaceBlank(String s){
        //首先遍历，找到所有空格
        int count0 = 0;
        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i++){
            if (c[i]==' '){
                count0++;
            }
        }
        int currentlength = s.length()+count0*3;
        char[] current_c = new char[currentlength];
        int i = 0;
        int j = 0;
        while(i<s.length()){
            if (c[i]!=' '){
                current_c[j] = c[i];
                i++;
                j++;
            }
            else
            {
                current_c[j] = '%';
                current_c[j+1] = '2';
                current_c[j+2] = '0';
                i++;
                j = j+3;
            }
        }
        System.out.print(current_c);
    }
    //参数为StringBuffer，对象可以被多次修改，且不产生新对象
    public void ReplaceBlank_2(StringBuffer s){
        int p1 = s.length()-1;
        for (int i=0; i<p1; i++){
            if (s.charAt(i)==' '){
               s.append("  ");  //添加两个空格
            }
        }
        int p2 = s.length()-1;
        while(p1!=p2 && p1>=0){
            char c = s.charAt(p1);
            if (c!=' '){
                s.setCharAt(p2,c);
                p1--;
                p2--;
            }
            else{
                s.setCharAt(p2,'0'); p2--;
                s.setCharAt(p2,'2'); p2--;
                s.setCharAt(p2,'%'); p2--;
                p1--;
            }
        }
        System.out.print(s);
    }



    public static void main(String[] args) {
        String s = "we are young!";
        StringBuffer s_2 = new StringBuffer("we are young!");
        Task5 t_5 = new Task5();
        t_5.ReplaceBlank(s);
        t_5.ReplaceBlank_2(s_2);
    }
}
