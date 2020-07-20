package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] playground = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                playground[i][j] = ' ';
            }
        }

        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        char result = 'N';
        boolean notFinished = true;

        printGame(playground);
        int c1 = 0;
        int c2 = 0;

        do {
            do {
                System.out.println("Enter the coordinates");
                c1 = scanner.nextInt();
                c2 = scanner.nextInt();

                c1 -= 1;
                if (c2 == 3) {
                    c2 = 0;
                } else if (c2 == 2) {
                    c2 = 1;
                } else if (c2 == 1) {
                    c2 = 2;
                }

            } while (!goodNumber(c1, c2, playground));

            playground[c1][c2] = player;

            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
            printGame(playground);
            result = lookingForWinner(playground);

            if (result == 'X' || result == 'O') {
                notFinished = false;
                System.out.println(result + " wins");
            } else if (isDraw(playground)) {
                notFinished = false;
                System.out.println("Draw");
            }

        } while (notFinished);

    }


    public static char lookingForWinner(char[][] playground) {
        char winner = 'N';

        for (int i = 0; i < 3; i++) {
            if (playground[i][0] == playground[i][1] && playground[i][1] == playground[i][2]) {
                winner = playground[i][0];
            }
            if (playground[0][i] == playground[1][i] && playground[1][i] == playground[2][i]) {
                winner = playground[0][i];
            }
        }
        if (playground[0][0] == playground[1][1] && playground[1][1] == playground[2][2]) {
            winner = playground[1][1];
        }
        if (playground[0][2] == playground[1][1] && playground[1][1] == playground[2][0]) {
            winner = playground[1][1];
        }
        return winner;
    }

    public static void printGame(char[][] playground) {
        System.out.println("---------");
        for (int j = 0; j < 3; j++) {
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {

                System.out.print(playground[i][j]);
                System.out.print(" ");
            }
            System.out.print("| \n");
        }
        System.out.println("---------");

    }

    public static boolean goodNumber(int c1, int c2, char[][] playground) {
        boolean result = true;

        if (c1 > 2 || c2 > 2) {
            result = false;
            System.out.println("Coordinates should be form 1 to 3!");
        } else if (playground[c1][c2] != ' ') {
            System.out.println("This cell is occupied! Choose another one");
            result = false;
        }
        return result;
    }

    public static boolean isDraw(char[][] playground) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (playground[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
