//请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy.",则输出"We%20are%20happy."
//注意：在原字符串上进行替换，并且保证输入的字符串后面有足够多的空余内存。

public class Task5 {
    //length 为总长度
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
    public static void main(String[] args) {
        String s = "we are young!";
        Task5 t_5 = new Task5();
        t_5.ReplaceBlank(s);

    }
}
