package day09.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day09\\input"))) {

            String input;
            int steps;
            List<Integer[]> rope = new ArrayList<>();
            for (int i = 0; i < 10; i++) rope.add(new Integer[]{1, 1});
            Set<String> visitedSpots = new HashSet<>();

            while (scan.hasNext()) {

                input = scan.nextLine();
                steps = Integer.parseInt(input.split(" ")[1]);

                for (int i = 0; i < steps; i++) {
                    doStep(rope, input.toCharArray()[0]);
                    visitedSpots.add(Arrays.toString(rope.get(rope.size() - 1)));
                }

            }
            System.out.println(Arrays.toString(rope.get(rope.size() - 1)));
            System.out.println(visitedSpots.size());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void doStep(List<Integer[]> rope, char direction) {

        switch (direction) {
            case 'U' -> rope.get(0)[1]++;
            case 'D' -> rope.get(0)[1]--;
            case 'L' -> rope.get(0)[0]--;
            case 'R' -> rope.get(0)[0]++;
        }

        for (int i = 1; i < rope.size(); i++) {

            Integer[] coordsH = rope.get(i - 1);
            Integer[] coordsT = rope.get(i);

            if ((Math.abs(coordsH[0] - coordsT[0]) > 1 && coordsH[1] != coordsT[1] || (coordsH[0] != coordsT[0] && Math.abs(coordsH[1] - coordsT[1]) > 1))) {

                coordsT[0] = coordsT[0] > coordsH[0] ? coordsT[0] - 1 : coordsT[0] + 1;
                coordsT[1] = coordsT[1] > coordsH[1] ? coordsT[1] - 1 : coordsT[1] + 1;
                continue;

            }
            if (Math.abs(coordsH[0] - coordsT[0]) > 1) {
                coordsT[0] = coordsT[0] > coordsH[0] ? coordsT[0] - 1 : coordsT[0] + 1;
                continue;

            }
            if (Math.abs(coordsH[1] - coordsT[1]) > 1) {
                coordsT[1] = coordsT[1] > coordsH[1] ? coordsT[1] - 1 : coordsT[1] + 1;

            }
        }
    }

}
