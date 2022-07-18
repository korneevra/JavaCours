import java.util.Arrays;

public class HomeWork3_1 {

    // На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

    static int SIZE = 8;
    static int SOLUTIONS = 0;
    static char SELL_EMPTY = '.';
    static char QUEEN = '8';
    public static char[][] field = new char[SIZE][SIZE];


    public static void fieldPrint(int[] queens) {
        fieldInit(field);
        for (int i = 0; i < SIZE; i++) {
            field[i][queens[i]] = QUEEN;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    public static void fieldInit(char[][] arr) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = SELL_EMPTY;
            }
        }
    }

    public static void solve(int[] queens, int q) {
        if (q >= SIZE){
            if (SOLUTIONS++ < 5)
                fieldPrint(queens);
            return;
        }
        for (int r = 0; r < SIZE; r++){
            int c;
            for (c = 0; c < q; c++) {
                if (queens[c] == r || Math.abs(queens[c] - r) == q - c)
                    break;
            }
            if (c == q){
                queens[q] = r;
                solve(queens,q + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] queens = new int[SIZE];
        solve(queens,0);
    }
}
