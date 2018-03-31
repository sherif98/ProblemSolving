package hashes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

    public int isValidSudoku(final List<String> a) {
        for (String row : a) {
            if (!isValidRow(row)) {
                return 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(i, a)) {
                return 0;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSquare(i, j, a)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean isValidSquare(int row, int column, List<String> board) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                char c = board.get(i).charAt(j);
                if (c != '.' && set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    private boolean isValidColumn(int column, List<String> board) {
        Set<Character> set = new HashSet<>();
        for (String s : board) {
            char c = s.charAt(column);
            if (c != '.' && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private boolean isValidRow(String row) {
        Set<Character> set = new HashSet<>();
        for (char c : row.toCharArray()) {
            if (c != '.' && set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
