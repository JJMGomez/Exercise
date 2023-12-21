package easy;

public class ImageSmoother {
    public int n;
    public int m;
    public int[][] image;

    public int count=0;
    public int[][] imageSmoother(int[][] img) {
        m = img.length;
        n = img[0].length;
        image = img;
        int [][] res = new int[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                count=0;
                res[i][j] = (getPoint(i-1,j-1)
                        + getPoint(i,j-1)
                        + getPoint(i+1,j-1)
                        + getPoint(i-1,j)
                        + getPoint(i-1,j+1)
                        + getPoint(i,j+1)
                        + getPoint(i+1, j)
                        + getPoint(i+1,j+1)
                        + getPoint(i,j))/count;
            }
        }
        return res;
    }

    public int getPoint(int i,int j){
        if (i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        count++;
        return image[i][j];
    }


    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        int[][] img_case1 = new int[][]{{100,200,100},{200,50,200},{100,200,100}};
        imageSmoother.imageSmoother(img_case1);
    }
}
