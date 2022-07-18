public class HomeWork3 {

    // На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

    static char SELL_EMPTY = '*';
    static char QUINE = 'Q';
    static int FIELD_SIZE = 8;

    public static boolean lineTest(char[][] arr, int line) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (arr[line][i] != SELL_EMPTY) return false;
        }
        return true;
    }

    public static boolean colTest(char[][] arr, int col) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (arr[i][col] != SELL_EMPTY) return false;
        }
        return true;
    }

    public static boolean diagTest(char[][] arr, int line, int col) {
        for (int i = line, j = col; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] != SELL_EMPTY) return false;
        }
        for (int i = line + 1, j = col + 1; i < FIELD_SIZE && j < FIELD_SIZE; i++, j++) {
            if (arr[i][j] != SELL_EMPTY) return false;
        }
        return true;
    }

    public static void fieldInit(char[][] arr) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                arr[i][j] = SELL_EMPTY;
            }
        }
    }

    public static void fieldPrint(char[][] arr) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
        System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
        fieldInit(field);
        fieldPrint(field);
        System.out.println("------------------------");
        field[0][0] = QUINE;

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (lineTest(field, i) && colTest(field, j) && diagTest(field, i, j)) {
                    field[i][j] = QUINE;

                }
            }
        }

        fieldPrint(field);
    }
}
