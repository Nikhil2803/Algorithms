public class Validator {

    public static boolean validateCellValue(int[][] sudoku, int row, int col, int value){

        //Check if any cell of row already has given value
        for(int i=0;i<sudoku[row].length;i++){
            if(sudoku[row][i]==value){
                return false;
            }
        }

        //Check if any cell of column already has given value
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==value){
                return false;
            }
        }

        //Check if quadrant does not have same value
        int quadRowStartIndex = row - (row % (int)Math.sqrt(sudoku.length));
        int quadColStartIndex = col - (col % (int)Math.sqrt(sudoku.length));
        for(int i = quadRowStartIndex; i<(quadRowStartIndex + (int)Math.sqrt(sudoku.length)); i++){
            for(int j = quadColStartIndex; j<(quadColStartIndex+(int)Math.sqrt(sudoku.length)); j++){
                if(sudoku[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean validateSudoku(int[][] sudoku){
        for(int i=0; i< sudoku.length;i++){
            for(int j=0; j< sudoku.length;j++){
                if(sudoku[i][j]!=0 && !validateCellValue(sudoku, i,j,sudoku[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
