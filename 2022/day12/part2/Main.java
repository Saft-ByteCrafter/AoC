package day12.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    protected static final List<List<Node>> grid = new ArrayList<>();
    private static final List<Node> starts = new ArrayList<>();
    private static final List<Node> done = new ArrayList<>();

    public static void main(String... args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day12\\input"))) {

            String input;
            int line = 0;

            while (scan.hasNext()) {

                input = scan.nextLine();
                grid.add(Node.listOf(input.toCharArray(), line));
                line++;

            }

            List<Node> queue = new ArrayList<>();

            grid.forEach(queue::addAll);

            int score = Integer.MAX_VALUE;

            for(Node start : starts) {

                queue.addAll(done);
                done.clear();
                queue.forEach(Node::reset);
                start.setStart();

                while (!queue.isEmpty()) {

                    queue.sort((Comparator.comparingInt(Node::getDistance)));

                    Node current = queue.get(0);
                    int isDone = checkNeighbors(current);
                    if (isDone != 0) {
                        if(isDone < score && isDone > 0) score = isDone;
                        break;
                    }
                    queue.remove(current);
                    done.add(current);

                }
            }
            System.out.println(score);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addStart(Node start) {
        starts.add(start);
    }

    private static int checkNeighbors(Node current) {
        int isDone = 0;
        int x = current.getX();
        int y = current.getY();
        if (x != 0) {
            Node neighbor = grid.get(y).get(x - 1);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                isDone = neighbor.checkForBetterPath(current);
        }
        if(isDone != 0) return isDone;
        if (x != grid.get(y).size() - 1) {
            Node neighbor = grid.get(y).get(x + 1);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                isDone = neighbor.checkForBetterPath(current);
        }
        if(isDone != 0) return isDone;
        if (y != 0) {
            Node neighbor = grid.get(y - 1).get(x);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                isDone = neighbor.checkForBetterPath(current);
        }
        if(isDone != 0) return isDone;
        if (y != grid.size() - 1) {
            Node neighbor = grid.get(y + 1).get(x);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                isDone = neighbor.checkForBetterPath(current);
        }

        return isDone;

    }
}
