package practice;

import java.util.Arrays;


public class ConwayGame {
    public static int [] rowsDirection = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int [] colsDirection = {0, 0, 1, -1, -1, 1, -1, 1};

    static int [] [] matrix = {{0,0,1},{1,0,0},{0,1,0}};
    static int noOfRows = matrix.length;
    static int noOfColums = matrix[0].length;

    static int [] [] result = new int[noOfRows][noOfColums];

    public static void main(String args[]){

        int [] [] resultMatrix = getResultMatrix(matrix,result );
        for(int [] rm : resultMatrix){
            System.out.println(Arrays.toString(rm));
        }
    }

    public static int [][] getResultMatrix(int [][] matrix, int[][] resultMatrix){

        for(int i=0; i<noOfRows; i++){
            for(int j=0; j<noOfColums; j++){


               if(matrix[i][j] == 0){
                 boolean makeLive =  executeConditionForDeadCell(matrix, i, j);
                 if(makeLive){
                     resultMatrix[i][j] = 1;
                 } else{
                     resultMatrix[i][j] = 0;
                 }
               }

              // 0,0,0
              // 0,0,0
              // 0,0,0

               else{

                  boolean makeLive2 = executeConditionForLiveCell(matrix, i, i);
                  if(makeLive2){
                      resultMatrix[i][j] = 1;
                  }else{
                      resultMatrix[i][j] = 0;
                  }
               }
            }
        }
        return resultMatrix;
    }

    private static boolean executeConditionForLiveCell(final int[][] matrix, int currRow, int currCol) {

        boolean makeLive = false;
        int decisionCount = 0;
        for(int i=0; i<rowsDirection.length; i++){
            int newR = currRow + rowsDirection[i];
            int newC = currCol + colsDirection[i];
            if(isValid(newR,newC) ){
                // fewre than 2 means < 2 : die
                // 2 || 3 means : live
                // > 3 means : dead
                if(matrix[newR][newC] == 1){
                    decisionCount++;
                }
            }
        }
        if(decisionCount == 2 || decisionCount == 3){
            makeLive = true;
        }
        return makeLive;
    }

    private static Boolean executeConditionForDeadCell(final int[][] matrix, int currRow, int currCol) {
        boolean makeLive = false;
        int decisionCount = 0;
        for(int i=0; i<rowsDirection.length; i++){
            int newR = currRow + rowsDirection[i];
            int newC = currCol + colsDirection[i];
            if(isValid(newR,newC) && matrix[newR][newC] == 1){
                decisionCount++;
            }
        }
        if(decisionCount == 3){
            makeLive = true;
        }
        return makeLive;
    }

    public static boolean isValid(int newR, int newC){
       if( newR > 0 && newR < noOfRows && newC > 0 && newC < noOfColums){
           return  true;
       }
       return false;
    }

}
