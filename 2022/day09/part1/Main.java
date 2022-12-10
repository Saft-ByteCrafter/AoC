package day09.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day09\\input"))) {

            String input;
            int steps;
            int[] coordsH = {1, 1}; // x|y
            int[] coordsT = {1, 1};
            Set<String> visitedSpots = new HashSet<>();

            while (scan.hasNext()) {

                input = scan.nextLine();
                steps = Integer.parseInt(input.split(" ")[1]);

                for (int i = 0; i < steps; i++) {
                    doStep(coordsH, coordsT, input.toCharArray()[0]);
                    visitedSpots.add(Arrays.toString(coordsT));
                }

            }
            System.out.println(visitedSpots.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void doStep(int[] coordsH, int[] coordsT, char direction) {

        switch (direction) {
            case 'U' -> coordsH[1]++;
            case 'D' -> coordsH[1]--;
            case 'L' -> coordsH[0]--;
            case 'R' -> coordsH[0]++;
        }

        if ((Math.abs(coordsH[0] - coordsT[0]) > 1 && coordsH[1] != coordsT[1] || (coordsH[0] != coordsT[0] && Math.abs(coordsH[1] - coordsT[1]) > 1))) {

            coordsT[0] = coordsT[0] > coordsH[0] ? coordsT[0] - 1 : coordsT[0] + 1;
            coordsT[1] = coordsT[1] > coordsH[1] ? coordsT[1] - 1 : coordsT[1] + 1;
            return;

        }
        if (Math.abs(coordsH[0] - coordsT[0]) > 1) {
            coordsT[0] = coordsT[0] > coordsH[0] ? coordsT[0] - 1 : coordsT[0] + 1;
            return;

        }
        if (Math.abs(coordsH[1] - coordsT[1]) > 1) {
            coordsT[1] = coordsT[1] > coordsH[1] ? coordsT[1] - 1 : coordsT[1] + 1;

        }
    }

}
