package tetris;

public final class Tetromino {

    private char[][] shape;
    private final int rows;
    private final int columns;

    public static Tetromino T_SHAPE = new Tetromino(".T.\n" +
                                                    "TTT\n" +
                                                    "...\n");

    public static Tetromino I_SHAPE = new Tetromino(".....\n" +
                                                    ".....\n" +
                                                    "IIII.\n" +
                                                    ".....\n" +
                                                    ".....\n");

    public Tetromino(String newShape) {
        this.columns = newShape.indexOf('\n');
        String[] stringRows = newShape.split("\n");
        this.rows = stringRows.length;

        shape = new char[rows][columns];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < columns; col++) {
                shape[row][col] = stringRows[row].charAt(col);
            }
            System.out.println();
        }
    }


    public Tetromino(char[][] newShape) {
        this.rows = newShape.length;
        this.columns = newShape[0].length;
        this.shape = newShape;
    }

//    public Tetromino rotateLeft() {
//        char[][] newShape = new char[this.rows][this.columns];
//
//        for(int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.columns; j++) {
//                newShape[i][j] = this.shape[i][(this.columns - 1) - j];
//            }
//
//            // Print out
//            String s = "";
//            for (int k = 0; k < rows; k++) {
//                for (int j = 0; j < columns; j++) {
//                    s += shape[k][j];
//                }
//                s += "\n";
//            }
//
//            System.out.println(s);
//        }
//        return new Tetromino(newShape);
//    }

    public Tetromino rotateRight() {
        char[][] newShape = new char[this.rows][this.columns];

        for(int row = 0; row < this.rows; row++){
            for(int col = 0; col < this.columns; col++) {
                newShape[row][col] = this.shape[(this.columns - 1) - col][row];
            }
        }

        return new Tetromino(newShape);
    }

    public Tetromino rotateLeft() {
        char[][] newShape = new char[this.rows][this.columns];

        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                newShape[i][j] = this.shape[this.rows - j - 1][i];
            }
        }

        return new Tetromino(newShape);
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += shape[row][col];
            }
            s += "\n";
        }
        return s;
    }
}
