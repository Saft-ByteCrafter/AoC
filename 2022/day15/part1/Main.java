package day15.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String... args) {

        int importantLine = 2000000;

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day15\\input"))) {

            Set<Integer> xWithNoBeacon = new HashSet<>();
            Set<Integer> excluded = new HashSet<>();

            while (scan.hasNext()) {

                String[] coords = cleanseInput(scan.nextLine());
                int sx = Integer.parseInt(coords[0]);
                int sy = Integer.parseInt(coords[1]);
                int bx = Integer.parseInt(coords[2]);
                int by = Integer.parseInt(coords[3]);

                int manhattanDistance = Math.abs(sx - bx) + Math.abs(sy - by);

                if ((sy < importantLine && sy + manhattanDistance < importantLine) || (sy > importantLine && sy - manhattanDistance > importantLine))
                    continue;

                if (sy == importantLine) excluded.add(sx);
                if (by == importantLine) excluded.add(bx);

                int distanceToLine = sy > importantLine ? sy - importantLine : importantLine - sy;
                int lineDistanceFromCenter = manhattanDistance - distanceToLine;

                for (int i = -lineDistanceFromCenter; i <= lineDistanceFromCenter; i++) xWithNoBeacon.add(sx + i);


            }
            System.out.println(xWithNoBeacon.size() - excluded.size());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] cleanseInput(String input) {
        input = input.replace("Sensor at x=", "").replace(" y=", "").replace(": closest beacon is at x=", ",");
        return input.split(",");
    }

}
