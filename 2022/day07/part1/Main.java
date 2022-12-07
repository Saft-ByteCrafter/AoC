package day07.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Directory mainDir = new Directory("/");

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day07\\input"));) {

            String input = scan.nextLine();
            Directory currentDir = mainDir;

            do {

                if (input.contains("cd")) {

                    String dir = input.split(" ")[2];

                    if (dir.equals("..")) currentDir = currentDir.getOuterDir();
                    else {
                        currentDir = currentDir.getSubDir(dir);
                    }
                } else {
                    input = scan.nextLine();
                    do {
                        if (input.contains("dir")) {
                            currentDir.addSubDir(new Directory(input.split(" ")[1], currentDir));
                        } else {
                            currentDir.addFile(Integer.parseInt(input.split(" ")[0]));
                        }

                        input = scan.nextLine();

                    } while (!input.contains("$"));
                    continue;

                }
                input = scan.nextLine();

            } while (input != null);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            List<Integer> yes = new ArrayList<>();
            mainDir.getTotalSize(yes);
            int counter = 0;
            for(Integer i : yes) counter += i;
            System.out.println(counter);
        }

    }
}
