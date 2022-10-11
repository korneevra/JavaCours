import java.util.Arrays;

public class lesson4 {

    public static int SIZE = 5;
    public static int TURNS = SIZE * SIZE +1;
    public static int[][] moves = {{-2,-1}, {-1,-2}, {1,-2}, {2,-1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    public static int SOLUTIONs = 0;

    public static void horseMoves(int turn, int x, int y, int[][] field) {
        if (turn == TURNS) {
            if (SOLUTIONs++ < 3) {
                fieldPrint(field);
                System.out.println("--------------------");
            }
            return;
        }

        for (int i = 0; i < moves.length; i++) {
            int tx = x + moves[i][0];
            int ty = y + moves[i][1];
            if (isValidSell(tx, ty) && field[tx][ty] == 0) {
                field[tx][ty] = turn;
                horseMoves(turn + 1, tx, ty, field);
                if (turn < TURNS) field[tx][ty] = 0;
            }
        }
        return;
    }

    public static boolean isValidSell(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    public static void fieldInit(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = 0;
            }
        }
    }

    public static void fieldPrint(int[][] field) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + field[i][j] + '\t');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] field = new int[SIZE][SIZE];
        fieldInit(field);
        int x = 2;
        int y = 2;
        int turn = 1;
        field[x][y] = turn;
        horseMoves(turn + 1, x, y, field);
    }
}
