//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
public class Task4 {
    public boolean getInt(int[][]a, int k){
        if (a==null){
            return false;
        }
        int row = a.length; //行数
        int column = a[0].length; //列数
        int i = 0;
        int j = column-1;
        //从右上角的数开始判断
        while (i<row && j>=0){
            if (a[i][j]==k){
                return true;
            }
            else if (a[i][j]>k){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] a = { {1,2,8,9},
                      {2,4,9,12},
                      {4,7,10,11},
                      {6,8,11,15} };
        Task4 t4 = new Task4();
        System.out.print(t4.getInt(a,13));
    }
}
