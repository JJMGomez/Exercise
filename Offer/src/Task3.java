import java.util.HashMap;

//数组中的重复数字
public class Task3 {
    //用HashMap解决
    public int getDuplicate1(int a[]){
        if (a.length<=1){
            return -1;
        }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i=0; i<a.length; i++){
            int hashcode = a[i]%8;
            if (m.get(hashcode)==null){
                m.put(hashcode,a[i]);
            }
            else {
                return a[i];
            }
        }
        return -1;
    }

    //利用hashmap原理，但不新建HashMap，而是在原数组基础上进行数字交换 注意，该方法仅适用于长度为n，且所有数字都在0～n-1范围内的情况。
    public int getDuplicate2(int a[]){
        for (int i=0; i<a.length; i++){
            while(a[i]!=i){
                if (a[i]!=a[a[i]]) {
                    int temp = a[i];
                    a[i] = a[temp];
                    a[temp] = temp;
                }
                else{
                    return a[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Task3 t3 = new Task3();
        int[] a = {4,3,1,0,2,5,2};
        int result = t3.getDuplicate1(a);
        int result2 = t3.getDuplicate2(a);
        System.out.print(result);
        System.out.print(result2);
    }
}
