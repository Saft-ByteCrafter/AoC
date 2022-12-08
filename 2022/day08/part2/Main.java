package day08.part2;

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

            int highestScore = 0;

            for (int i = 0; i < columns.size(); i++) {
                for (int j = 0; j < columns.get(i).size(); j++) {

                    int currentTree = columns.get(i).get(j);
                    int a = 0;
                    int b = 0;
                    int c = 0;
                    int d = 0;

                    for (int k = i - 1; k >= 0; k--) {
                        a++;
                        if (columns.get(k).get(j) >= currentTree) break;
                    }

                    for (int k = i + 1; k < columns.size(); k++) {
                        b++;
                        if (columns.get(k).get(j) >= currentTree) break;
                    }

                    for (int k = j - 1; k >= 0; k--) {
                        c++;
                        if (columns.get(i).get(k) >= currentTree) break;
                    }

                    for (int k = j + 1; k < columns.get(i).size(); k++) {
                        d++;
                        if (columns.get(i).get(k) >= currentTree) break;
                    }

                    int thisScore = a * b * c * d;

                    highestScore = Math.max(thisScore, highestScore);

                }
            }

            System.out.println(highestScore);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
