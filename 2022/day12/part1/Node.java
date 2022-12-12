package day12.part1;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final char height;
    private final int x;
    private final int y;
    private int distance;

    private Node(char height, int x, int y) {
        if (height == 'S') {
            this.height = 'a';
            this.distance = 0;
        } else {
            this.height = height;
            this.distance = Integer.MAX_VALUE;
        }
        this.x = x;
        this.y = y;
    }

    public static List<Node> listOf(char[] chars, int line) {

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            nodeList.add(new Node(chars[i], i, line));
        }

        return nodeList;
    }

    public void checkForBetterPath(Node newNode) {
        if (distance <= newNode.distance + 1) return;
        this.distance = newNode.distance + 1;
        if (this.height == 'E') System.out.printf("End with %d steps!%n", distance);
    }


    public char getHeight() {
        if (this.height == 'E') return 'z';
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

}
