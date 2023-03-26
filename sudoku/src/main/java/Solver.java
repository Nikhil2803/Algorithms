public class Solver {

    private int[][] sudoku;

    public Solver(int[][] sudoku) {
        this.sudoku=sudoku;
    }

    public boolean solveSudoku(int row, int col, int value){

        //If cell is empty try each number and validate cell
        int val = value;
        boolean isOriginal=true;
        if(sudoku[row][col]==0){
            isOriginal=false;
                while (val <= sudoku.length) {
                    if (Validator.validateCellValue(sudoku,row, col, val)) {
                        sudoku[row][col] = val;
                        break;
                    } else {
                        ++val;
                    }
                }
                if (sudoku[row][col] == 0) {
                    return false;
                }
        }

        //If we reached last cell its completed.
        if(row==sudoku.length-1 && col == sudoku.length-1){
            return true;
        }

        //If there are cols remaining ahead
        if(col<sudoku.length-1){
            //try solving next cell
            if(solveSudoku(row,(col+1),1)){
                return true;
            }else{
                //If next solution is failing for all number, clear current cell and re-try with other number
                if(isOriginal){
                    return false;
                }else{
                    sudoku[row][col] =0;
                    return solveSudoku(row,col,++val);
                }
            }
        }else{
            if(solveSudoku(row+1,0,1)){
                return true;
            }else{
                //If next solution is failing for all number, clear current cell and re-try with other number
                if(isOriginal){
                    return false;
                }else{
                    sudoku[row][col] =0;
                    return solveSudoku(row,col,++val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        Solver solver = new Solver(generator.generateSudoku(16));
        generator.printSudoku(solver.sudoku);
        System.out.println(solver.solveSudoku(0,0,1));
        generator.printSudoku(solver.sudoku);
    }
}
