package day12.part2;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private final char height;
    private final int x;
    private final int y;
    private int distance;


    private Node(char height, int x, int y) {
        this.height = height;
        this.distance = Integer.MAX_VALUE;
        this.x = x;
        this.y = y;
    }

    public static List<Node> listOf(char[] chars, int line) {

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Node newNode = new Node(chars[i], i, line);
            nodeList.add(newNode);
            if(chars[i] == 'a') Main.addStart(newNode);
        }

        return nodeList;
    }

    public int checkForBetterPath(Node newNode) {
        if (distance <= newNode.distance + 1) return 0;
        this.distance = newNode.distance + 1;
        if (this.height == 'E') {
            return distance;
        }
        return 0;
    }

    public void reset() {
        this.distance = Integer.MAX_VALUE;
    }

    public void setStart() {
        this.distance = 0;
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
