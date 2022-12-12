package day12.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    protected static final List<List<Node>> grid = new ArrayList<>();
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

            while (!queue.isEmpty()) {

                queue.sort((Comparator.comparingInt(Node::getDistance)));

                Node current = queue.get(0);
                checkNeighbors(current);
                queue.remove(current);
                done.add(current);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void checkNeighbors(Node current) {
        int x = current.getX();
        int y = current.getY();
        if (x != 0) {
            Node neighbor = grid.get(y).get(x - 1);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                neighbor.checkForBetterPath(current);
        }
        if (x != grid.get(y).size() - 1) {
            Node neighbor = grid.get(y).get(x + 1);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                neighbor.checkForBetterPath(current);
        }
        if (y != 0) {
            Node neighbor = grid.get(y - 1).get(x);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                neighbor.checkForBetterPath(current);
        }
        if (y != grid.size() - 1) {
            Node neighbor = grid.get(y + 1).get(x);
            if (!done.contains(neighbor) && (neighbor.getHeight() - 1 <= current.getHeight()))
                neighbor.checkForBetterPath(current);
        }

    }
}
