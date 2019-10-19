public class Work1 {
    public static void main(String[] args) {
        int[][] isMagicSquare = {
                {8,1,6},
                {3,5,7},
                {4,9,2}
        };
        int[][] isMagicSquare2={
                {3,4,5,6,7},
                {1,2,3,4,5},
                {3,2,5,1,2},
                {5,7,8,9,12},
                {23,3,8,9,11}
        };
        System.out.println(isMAgicSquare(isMagicSquare));
        isMAgicSquare(isMagicSquare);
        System.out.println(isMAgicSquare(isMagicSquare2));
        isMAgicSquare(isMagicSquare2);
    }
    public static boolean isMAgicSquare(int[] [] matrix){
        int row = matrix.length;
        int sumrow = 0;
        int sumcol = 0;
        int diagonalsum = 0;
        int diagonalsum2 =0;
        int remember=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<row; j++){
                sumrow +=matrix[i][j];
                sumcol +=matrix[j][i];
                if(i==0){
                    diagonalsum += matrix[j][j];
                    diagonalsum2 += matrix[j][row-j-1];
                }
            }
            if(sumcol!=sumrow && sumcol!= diagonalsum  && sumcol!= diagonalsum2){
                System.out.println(diagonalsum+"  "+diagonalsum2);
                return false;
            }else {
                if (i == 0) {
                    remember = sumcol;
                }
                sumrow = 0;
                sumcol = 0;
            }

        }
        return true;
    }
}
