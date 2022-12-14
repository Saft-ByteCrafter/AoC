package day14.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {


        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day14\\input"))) {

            String input;
            String[] in;
            int offset = 450;
            int arraySize = 200;

            char[][] cave = new char[arraySize][arraySize];
            for (char[] ar : cave) Arrays.fill(ar, '.');

            while (scan.hasNext()) {

                input = scan.nextLine();

                in = input.split(" -> ");

                int prevX = 0;
                int prevY = 0;
                for (String coords : in) {
                    int x = Integer.parseInt(coords.split(",")[0]) - offset;
                    int y = Integer.parseInt(coords.split(",")[1]);
                    if (prevX != 0 && prevY != 0) {
                        if (prevX == x) {
                            if (prevY < y) {
                                for (int i = prevY; i <= y; i++) {
                                    cave[x][i] = '#';
                                }
                            } else {
                                for (int i = y; i <= prevY; i++) {
                                    cave[x][i] = '#';
                                }
                            }
                        } else {
                            if (prevX < x) {
                                for (int i = prevX; i <= x; i++) {
                                    cave[i][y] = '#';
                                }
                            } else {
                                for (int i = x; i <= prevX; i++) {
                                    cave[i][y] = '#';
                                }
                            }
                        }
                    }
                    prevX = x;
                    prevY = y;
                }
            }
            cave[500 - offset][0] = '+';

            int restingSand = 0;
            int[] sandCoords;
            falling:
            while (true) {

                sandCoords = new int[]{500 - offset, 0};

                while (true) {

                    if (sandCoords[1] > arraySize - 2|| sandCoords[0] > arraySize - 1|| sandCoords[0] < 0) break falling;
                    if (cave[sandCoords[0]][sandCoords[1] + 1] == '.') {
                        sandCoords[1]++;
                    } else if (sandCoords[0] - 1 < 0) break falling;
                    else if (cave[sandCoords[0] - 1][sandCoords[1] + 1] == '.') {
                        sandCoords[0]--;
                        sandCoords[1]++;
                    } else if (sandCoords[0] > arraySize - 2) break falling;
                    else if (cave[sandCoords[0] + 1][sandCoords[1] + 1] == '.') {
                        sandCoords[0]++;
                        sandCoords[1]++;
                    } else break;

                }
                cave[sandCoords[0]][sandCoords[1]] = 'o';
                restingSand++;

            }

            for (char[] c : cave) { // sideways mirrored visualization weeeee les gooo x3
                for (char cn : c) {
                    System.out.print(cn);
                }
                System.out.println();
            }
            System.out.printf("Resting sand: %d", restingSand);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
