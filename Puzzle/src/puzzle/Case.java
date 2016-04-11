/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

/**
 *
 * @author Florent
 */
public class Case {
    private int     row;
    private int     col;
    private char    letter;
    private int     num;

    public Case(int row, int col, char letter, int num) {
        this.row = row;
        this.col = col;
        this.letter = letter;
        this.num = num;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
}
