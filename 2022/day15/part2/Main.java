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

            List<List<Integer[]>> xWhereNotBeacon = new ArrayList<>();
            for (int i = 0; i <= maxCoords; i++) {
                xWhereNotBeacon.add(new ArrayList<>());
            }

            while (scan.hasNext()) {

                String[] coords = cleanseInput(scan.nextLine());
                int sx = Integer.parseInt(coords[0]);
                int sy = Integer.parseInt(coords[1]);
                int bx = Integer.parseInt(coords[2]);
                int by = Integer.parseInt(coords[3]);

                int manhattanDistance = Math.abs(sx - bx) + Math.abs(sy - by);

                for (int y = 0; y <= maxCoords; y++) {

                    if ((sy < y && sy + manhattanDistance < y) || (sy > y && sy - manhattanDistance > y)) continue;

                    int distanceToLine = sy > y ? sy - y : y - sy;
                    int lineDistanceFromCenter = manhattanDistance - distanceToLine;

                    int lBound = -lineDistanceFromCenter + sx;
                    int uBound = lineDistanceFromCenter + sx;

                    xWhereNotBeacon.get(y).add(new Integer[]{lBound, uBound});

                }
            }
            for (int y = 0; y <= maxCoords; y++) {
                List<Range> ranges = new ArrayList<>();
                for (Integer[] bounds : xWhereNotBeacon.get(y)) {
                    int lbound = bounds[0] >= 0 ? bounds[0] : 0;
                    int ubound = bounds[1] <= maxCoords ? bounds[1] : maxCoords;
                    if (lbound > maxCoords || ubound < 0) continue;
                    Range newRange = new Range(lbound, ubound);

                    if (ranges.isEmpty()) {
                        ranges.add(newRange);
                        continue;
                    }

                    mergeRanges(ranges, newRange);

                }
                if (ranges.size() == 2) {
                    int x;
                    Range range = ranges.get(0);
                    if (range.getLbound() == 0) x = range.getUbound() + 1;
                    else x = range.getLbound() - 1;
                    System.out.printf("The coords are %d|%d, which makes for a score of %d%n", x, y, x * 4000000L + y);
                }

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String[] cleanseInput(String input) {
        input = input.replace("Sensor at x=", "").replace(" y=", "").replace(": closest beacon is at x=", ",");
        return input.split(",");
    }

    public static void mergeRanges(List<Range> ranges, Range newRange) {

        for (Range range : ranges) {
            if (range.intersects(newRange)) {
                ranges.remove(range);
                range.merge(newRange);
                newRange = range;
                mergeRanges(ranges, newRange);
                return;
            }
        }
        ranges.add(newRange);

    }

}
