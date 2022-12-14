package day14.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {


        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day14\\input"))) {

            String input;
            String[] in;
            int offset = 250;
            int arraySizeX = 600;
            int arraySizeY = 170;

            char[][] cave = new char[arraySizeX][arraySizeY];
            for (char[] ar : cave) Arrays.fill(ar, '.');

            int highesty = 0;
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
                    if(y > highesty) highesty = y;
                }
            }
            System.out.println(highesty+2); // -> gives array size to then throw in for arraySizeY lol, good code yes yes lmao
            cave[500 - offset][0] = '+';

            int restingSand = 0;
            int rowsLeftOffScreen = 0;
            int rowsRightOffScreen = 0;
            int[] sandCoords;
            while (true) {

                sandCoords = new int[]{500 - offset, 0};

                while (true) {

                    if (sandCoords[1] > arraySizeY - 2 || sandCoords[0] > arraySizeX - 1|| sandCoords[0] < 0) break;
                    if (cave[sandCoords[0]][sandCoords[1] + 1] == '.') {
                        sandCoords[1]++;
                    } else if (sandCoords[0] - 1 < 0){
                        rowsLeftOffScreen++;
                        break;
                    }
                    else if (cave[sandCoords[0] - 1][sandCoords[1] + 1] == '.') {
                        sandCoords[0]--;
                        sandCoords[1]++;
                    } else if (sandCoords[0] > arraySizeX - 2){
                        rowsRightOffScreen++;
                        break;
                    }
                    else if (cave[sandCoords[0] + 1][sandCoords[1] + 1] == '.') {
                        sandCoords[0]++;
                        sandCoords[1]++;
                    } else break;

                }
                cave[sandCoords[0]][sandCoords[1]] = 'o';
                restingSand++;
                if(sandCoords[1] == 0) break;

            }

            for (char[] c : cave) { // sideways mirrored visualization weeeee les gooo x3
                for (char cn : c) {
                    System.out.print(cn);
                }
                System.out.println();
            }
            for(int i = 1; i <= rowsLeftOffScreen; i++) restingSand += i;
            for(int i = 1; i <= rowsRightOffScreen; i++) restingSand += i;
            System.out.printf("Resting sand: %d", restingSand);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
