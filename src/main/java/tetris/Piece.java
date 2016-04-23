package tetris;

import javafx.scene.input.PickResult;

public class Piece {

    //private String shape;
    private char[][] shape;
    private final int rows;
    private final int columns;

    public Piece(String newShape) {
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

    public Piece(char[][] newShape) {
        this.rows = newShape.length;
        this.columns = newShape[0].length;
        this.shape = newShape;
    }

    public Piece rotateLeft() {
        char[][] newShape = new char[this.rows][this.columns];

        for(int i = 0; i < this.rows; i++){
            for(int j=0; j < this.columns; j++) {
                newShape[j][i] = this.shape[i][(this.columns-1)-j];
            }
        }

        return new Piece(newShape);
    }

    public Piece rotateRight() {
        char[][] newShape = new char[this.rows][this.columns];

        for(int row = 0; row < this.rows; row++){
            for(int col = 0; col < this.columns; col++) {
                newShape[row][col] = this.shape[(this.columns-1)-col][row];
            }
        }
        return new Piece(newShape);
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
