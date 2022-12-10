package day10.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day10\\input"))) {

            int clock = 0;
            int xRegister = 1;
            int strength = 0;

            while (scan.hasNext()) {

                String operation = scan.nextLine();
                clock++;
                if ((clock + 20) % 40 == 0) strength += clock * xRegister;
                if (operation.equals("noop")) continue;
                clock++;
                if ((clock + 20) % 40 == 0) strength += clock * xRegister;

                xRegister += Integer.parseInt(operation.split(" ")[1]);

            }

            System.out.println(strength);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}