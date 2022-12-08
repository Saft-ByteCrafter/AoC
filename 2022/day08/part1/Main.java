package day08.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day08\\input"))) {

            String input;
            List<List<Integer>> columns = new ArrayList<>();

            while (scan.hasNext()) {

                List<Integer> row = new ArrayList<>();
                input = scan.nextLine();

                for (char s : input.toCharArray()) row.add((int) s);

                columns.add(row);

            }

            int seenTrees = 0;

            for (int i = 0; i < columns.size(); i++) {
                for (int j = 0; j < columns.get(i).size(); j++) {

                    int currentTree = columns.get(i).get(j);
                    boolean visible = true;

                    for (int k = 0; k < i; k++) {
                        if (columns.get(k).get(j) >= currentTree) {
                            visible = false;
                            break;
                        }
                    }
                    if (visible) {
                        seenTrees++;
                        continue;
                    }
                    visible = true;

                    for (int k = i + 1; k < columns.size(); k++) {
                        if (columns.get(k).get(j) >= currentTree) {
                            visible = false;
                            break;
                        }
                    }
                    if (visible) {
                        seenTrees++;
                        continue;
                    }
                    visible = true;

                    for (int k = 0; k < j; k++) {
                        if (columns.get(i).get(k) >= currentTree) {
                            visible = false;
                            break;
                        }
                    }
                    if (visible) {
                        seenTrees++;
                        continue;
                    }
                    visible = true;

                    for (int k = j + 1; k < columns.get(i).size(); k++) {
                        if (columns.get(i).get(k) >= currentTree) {
                            visible = false;
                            break;
                        }
                    }
                    if (visible) {
                        seenTrees++;
                    }
                }
            }

            System.out.println(seenTrees);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
