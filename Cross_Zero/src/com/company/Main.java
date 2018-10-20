package com.company;

import java.util.Scanner;

public class Main {

    static int[][] gameBoard = new int[3][3];

    static int x, y;

    static String player1 = "X", player2 = "O", currentPlayer = player1;

    static Scanner inputScan = new Scanner(System.in);

    public static void main(String[] args) {
        int a, b;
        for (a = 0; a < gameBoard.length; a++) {
            for (b = 0; b < gameBoard[a].length; b++) {
                gameBoard[a][b] = 0;
            }
        }
        while (true) {

            for (a = 0; a < gameBoard.length; a++) {
                for (b = 0; b < gameBoard[a].length; b++) {
                    switch (gameBoard[a][b]) {
                        case 0:
                            System.out.print("   ");
                            break;
                        case 1:
                            System.out.print(" X ");
                            break;
                        case 2:
                            System.out.print(" O ");
                            break;
                    }
                    if (b < gameBoard[a].length - 1)
                        System.out.print("|");
                }
                System.out.println();
                if (a < gameBoard.length - 1)
                    System.out.println("------------");
            }
            System.out.println("Ход игрока " + currentPlayer);
            System.out.println("Выбери строку: ");
            x = inputScan.nextInt();
            System.out.println("Выбери столбец: ");
            y = inputScan.nextInt();
            if (gameBoard[x][y] != 0) {
                System.out.println("Сюда ходить нельзя");
            } else {
                gameBoard[x][y] = currentPlayer.equalsIgnoreCase(player1) ? 1 : 2;
                currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
            }

            if (((gameBoard[0][0]) == 1 & (gameBoard[0][1]) == 1 & gameBoard[0][2] == 1) ||
                    ((gameBoard[1][0]) == 1 & (gameBoard[1][1]) == 1 & gameBoard[1][2] == 1)) {
                System.out.println(" Победил  X ");
                Exit();
                break;
            } else if (((gameBoard[2][0]) == 1 & (gameBoard[2][1]) == 1 & gameBoard[2][2] == 1) ||
                    ((gameBoard[0][0]) == 1 & (gameBoard[1][0]) == 1 & gameBoard[2][0] == 1)) {
                System.out.println(" Победил  X ");
                Exit();
                break;
            } else if (((gameBoard[0][1]) == 1 & (gameBoard[1][1]) == 1 & gameBoard[2][1] == 1) ||
                    ((gameBoard[0][2]) == 1 & (gameBoard[1][2]) == 1 & gameBoard[2][2] == 1)) {
                System.out.println(" Победил  X ");
                Exit();
                break;
            } else if (((gameBoard[0][0]) == 2 & (gameBoard[0][1]) == 2 & gameBoard[0][2] == 2) ||
                    ((gameBoard[1][0]) == 2 & (gameBoard[1][1]) == 2 & gameBoard[1][2] == 2)) {
                System.out.println(" Победил  O ");
                Exit();
                break;
            } else if (((gameBoard[2][0]) == 2 & (gameBoard[2][1]) == 2 & gameBoard[2][2] == 2) ||
                    ((gameBoard[0][0]) == 2 & (gameBoard[1][0]) == 2 & gameBoard[2][0] == 2)) {
                System.out.println(" Победил  O ");
                Exit();
                break;
            } else if (((gameBoard[0][1]) == 2 & (gameBoard[1][1]) == 2 & gameBoard[2][1] == 2) ||
                    ((gameBoard[0][2]) == 2 & (gameBoard[1][2]) == 2 & gameBoard[2][2] == 2)) {
                System.out.println(" Победил  O ");
                Exit();
                break;
            } else { }

            if (((gameBoard[0][0]) == 1 & (gameBoard[1][1]) == 1 & gameBoard[2][2] == 1) ||
                    ((gameBoard[0][2]) == 1 & (gameBoard[1][1]) == 1 & gameBoard[2][0] == 1)) {
                System.out.println(" Победил  Х ");
                Exit();
                break;
            } else if (((gameBoard[0][0]) == 2 & (gameBoard[1][1]) == 2 & gameBoard[2][2] == 2) ||
                    ((gameBoard[0][2]) == 2 & (gameBoard[1][1]) == 2 & gameBoard[2][0] == 2)) {
                System.out.println(" Победил  О ");
                Exit();
                break;
            } else {
                System.out.println();
            }
            if(((gameBoard[0][0]) != 0 & (gameBoard[0][1]) != 0 & gameBoard[0][2] != 0) &
                    ((gameBoard[1][0]) != 0 & (gameBoard[1][1]) != 0 & gameBoard[1][2] != 0)&
                    ((gameBoard[2][0]) != 0 & (gameBoard[2][1]) != 0 & gameBoard[2][2] != 0)){
                System.out.println("Ничья");
                Exit();
                break;
            }
        }

    }

    private static void Exit() {
        String again;
        do {
            System.out.println("Хотите продолжить игру? ");
            again = inputScan.next();
            if (again.equals("Yes")) {
                Main.main(null);
            } else if (again.equals("No")) {
                break;
            }
        } while (again.equals("No") || again.equals("Yes"));
    }
}