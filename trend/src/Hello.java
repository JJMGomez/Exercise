import java.util.*;
import java.util.stream.Collectors;

public class Hello {

    public int solution(int X, int Y, String[] C) {
        // Implement your solution here
        int[][] electionTable = new int[X][X];
        //init
        for (String tempStr: C){
            List<Integer> electionStr = Arrays.stream(tempStr.split(" ")).map(Integer::valueOf).collect(Collectors.toList());
            electionTable[electionStr.get(0)-1][electionStr.get(1)-1] = 1;
        }
        for (int i=0; i<X; i++){
            for (int j=0; j<X; j++){
                System.out.print(electionTable[i][j] + " ");
            }
            System.out.println();
        }

        for (int i=0; i< X; i++){
            for (int j=0; j<X; j++){
                if (electionTable[i][j] == 0){
                    for (int k=0; k<X; k++){
                        if (electionTable[k][j] == 1){
                            electionTable[k][i] = 1;
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i=0; i<X; i++){
            int tempNum = 0;
            for (int j=0; j<X; j++){
                tempNum += electionTable[j][i];
            }
            if (tempNum == X-1) result++;
        }
        System.out.println(result);

        for (int i=0; i<X; i++){
            for (int j=0; j<X; j++){
                System.out.print(electionTable[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args) {
        Hello hello = new Hello();
        String[] C = {"1 2","2 3", "2 4"};

        hello.solution(4,4, C);
        System.out.println("Hello");
    }
}
