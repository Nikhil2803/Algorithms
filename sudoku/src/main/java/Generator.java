public class Generator {

    public static void main(String[] args) {
        Generator generator = new Generator();
        int[][] sudoku = generator.generateSudoku(16);
        generator.printSudoku(sudoku);
    }

    public void printSudoku(int[][] sudoku){
        System.out.println("------------------------------------------");
        if(sudoku !=null){
            for(int row=0; row<sudoku.length;row++){
                for(int col=0; col<sudoku.length;col++){
                    System.out.print(sudoku[row][col]+" |");
                }
                System.out.println("");
            }
        }
    }

    public int[][] generateSudoku(int size) {
        int[][] sudoku = new int[size][size];

        //Fill independent diagonal submatrix first
        for(int i=0; i<size;i=(int) (i+Math.sqrt(size))) {
            fillCellInSubMatrix(i, i, sudoku);
        }

        //Randomly fill rest of matrix
        fillCellInSubMatrix(0, (int) (Math.sqrt(size)*2),sudoku);
        fillCellInSubMatrix((int) Math.sqrt(size),0,sudoku);
        fillCellInSubMatrix((int) (Math.sqrt(size)*2),0,sudoku);

        return sudoku;
    }

    public void fillCellInSubMatrix(int startRowIndex,int startColIndex, int[][] sudoku){
        int numOfValue = (int) ((Math.random()*10)%sudoku.length);
        for(int i=0; i<numOfValue; i++){
            int value = 1;
            int row = (int) (startRowIndex + (Math.random()*10)%Math.sqrt(sudoku.length));
            int col = (int) (startColIndex + (Math.random()*10)%Math.sqrt(sudoku.length));
            while(value<sudoku.length && sudoku[row][col]==0){
                if(Validator.validateCellValue(sudoku,row,col,value)){
                    sudoku[row][col]=value;
                    break;
                }
                ++value;
            }
        }
    }
}
