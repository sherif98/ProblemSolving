package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        final int RADIX = 10;
        int i = 4;
        char ch = Character.forDigit(i, RADIX);
        System.out.println(ch); // Prints '4'
        Sudoku sudoku = new Sudoku();
        sudoku.solveSudoku(null);

    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        ArrayList<Character> c1 = new ArrayList<>(Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.'));
        ArrayList<Character> c2 = new ArrayList<>(Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.'));
        ArrayList<Character> c3 = new ArrayList<>(Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.'));
        ArrayList<Character> c4 = new ArrayList<>(Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3'));
        ArrayList<Character> c5 = new ArrayList<>(Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1'));
        ArrayList<Character> c6 = new ArrayList<>(Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6'));
        ArrayList<Character> c7 = new ArrayList<>(Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.'));
        ArrayList<Character> c8 = new ArrayList<>(Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5'));
        ArrayList<Character> c9 = new ArrayList<>(Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9'));
        a = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
        solve(0, 0, a);
    }

    private int solve(int i, int j, ArrayList<ArrayList<Character>> a) {
        if (i >= a.size()) {
            return 1;
        }

        for (char k = '1'; k <= '9'; k++) {
            if (a.get(i).get(j) == '.') {
                if (isSafe(i, j, k, a)) {
                    Pair next = getNext(i, j, a.size());
                    int res = solve(next.i, next.j, a);
                    if (res == 1) {
                        return 1;
                    }
                    a.get(i).set(j, '.');
                }
            } else {
                Pair next = getNext(i, j, a.size());
                return solve(next.i, next.j, a);
            }
        }
        return -1;
    }

    private boolean isSafe(int i, int j, int num, ArrayList<ArrayList<Character>> a) {
        ArrayList<Character> row = a.get(i);
        boolean rowSafe = true;
        for (char c : row) {
            if (c == num) {
                rowSafe = false;
                break;
            }
        }
        boolean columnSafe = true;
        for (ArrayList<Character> column : a) {
            if (column.get(j) == num) {
                columnSafe = false;
                break;
            }
        }
        int startRow = getSquareStart(i);
        int startCol = getSquareStart(j);
        boolean squareSafe = true;
        for (int k = startRow; k < startRow + 3; k++) {
            for (int m = startCol; m < startCol + 3; m++) {
                if (a.get(k).get(m) == num) {
                    squareSafe = false;
                    break;
                }
            }
        }
        return rowSafe && columnSafe && squareSafe;
    }

    private int getSquareStart(int i) {
        return (int) Math.ceil((i + 1) / 3.0) * 3 - 3;
    }

    private Pair getNext(int i, int j, int n) {
        if (j == n - 1) {
            return new Pair(i + 1, 0);
        }
        return new Pair(i, j + 1);
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
