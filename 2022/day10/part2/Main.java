package day10.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day10\\input"))) {

            int clock = 0;
            int xRegister = 1;

            while (scan.hasNext()) {
                String operation = scan.nextLine();

                clock++;
                xRegister = writeToScreen(clock, xRegister);
                if (operation.equals("noop")) continue;

                clock++;
                xRegister = writeToScreen(clock, xRegister);

                xRegister += Integer.parseInt(operation.split(" ")[1]);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static int writeToScreen(int clock, int xRegister) {
        System.out.print(clock < xRegister  || clock > xRegister + 2 ? " " : "█");
        if ((clock) % 40 == 0) {
            xRegister += 40;
            System.out.println();
        }
        return xRegister;
    }

}