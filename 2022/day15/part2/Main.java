package day15.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day15\\input"))) {

            int maxCoords = 4000000;


            List<Set<Integer>> xWhereNotBeacon = new ArrayList<>();
            for (int i = 0; i <= maxCoords; i++) {
                xWhereNotBeacon.add(new HashSet<>(IntStream.range(0, maxCoords).boxed().collect(Collectors.toList())));
            }

            while (scan.hasNext()) {

                String[] coords = cleanseInput(scan.nextLine());
                int sx = Integer.parseInt(coords[0]);
                int sy = Integer.parseInt(coords[1]);
                int bx = Integer.parseInt(coords[2]);
                int by = Integer.parseInt(coords[3]);

                int manhattanDistance = Math.abs(sx - bx) + Math.abs(sy - by);

                for (int y = 0; y <= maxCoords; y++) {

                    if ((sy < y && sy + manhattanDistance < y) || (sy > y && sy - manhattanDistance > y))
                        continue;

                    int distanceToLine = sy > y ? sy - y : y - sy;
                    int lineDistanceFromCenter = manhattanDistance - distanceToLine;

                    for (int x = -lineDistanceFromCenter; x <= lineDistanceFromCenter; x++) {
                        if (sx + x < 0 || sx + x > maxCoords) continue;
                        xWhereNotBeacon.get(y).remove(sx + x);
                    }

                }
            }
            for (int y = 0; y <= maxCoords; y++) {
                if (xWhereNotBeacon.get(y).isEmpty()) continue;
                int x = 0;
                for (int defX : xWhereNotBeacon.get(y)) x = defX;
                System.out.printf("The coords are %d|%d, which makes for a score of %d%n", x, y, x * 4000000 + y);
            }
            System.out.println(xWhereNotBeacon);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] cleanseInput(String input) {
        input = input.replace("Sensor at x=", "").replace(" y=", "").replace(": closest beacon is at x=", ",");
        return input.split(",");
    }

}
