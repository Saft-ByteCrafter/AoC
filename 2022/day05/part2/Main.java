package day05.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\input"))) {

            String input;
            StringBuilder out = new StringBuilder();

            List<Stack<Character>> stacks = new ArrayList<>();

            for(int i = 0; i < 9; i++) {
                stacks.add(new Stack<>());
            }

            stacks.get(0).push('D');
            stacks.get(0).push('B');
            stacks.get(0).push('J');
            stacks.get(0).push('V');

            stacks.get(1).push('P');
            stacks.get(1).push('V');
            stacks.get(1).push('B');
            stacks.get(1).push('W');
            stacks.get(1).push('R');
            stacks.get(1).push('D');
            stacks.get(1).push('F');

            stacks.get(2).push('R');
            stacks.get(2).push('G');
            stacks.get(2).push('F');
            stacks.get(2).push('L');
            stacks.get(2).push('D');
            stacks.get(2).push('C');
            stacks.get(2).push('W');
            stacks.get(2).push('Q');

            stacks.get(3).push('W');
            stacks.get(3).push('J');
            stacks.get(3).push('P');
            stacks.get(3).push('M');
            stacks.get(3).push('L');
            stacks.get(3).push('N');
            stacks.get(3).push('D');
            stacks.get(3).push('B');

            stacks.get(4).push('H');
            stacks.get(4).push('N');
            stacks.get(4).push('B');
            stacks.get(4).push('P');
            stacks.get(4).push('C');
            stacks.get(4).push('S');
            stacks.get(4).push('Q');

            stacks.get(5).push('R');
            stacks.get(5).push('D');
            stacks.get(5).push('B');
            stacks.get(5).push('S');
            stacks.get(5).push('N');
            stacks.get(5).push('G');

            stacks.get(6).push('Z');
            stacks.get(6).push('B');
            stacks.get(6).push('P');
            stacks.get(6).push('M');
            stacks.get(6).push('Q');
            stacks.get(6).push('F');
            stacks.get(6).push('S');
            stacks.get(6).push('H');

            stacks.get(7).push('W');
            stacks.get(7).push('L');
            stacks.get(7).push('F');

            stacks.get(8).push('S');
            stacks.get(8).push('V');
            stacks.get(8).push('F');
            stacks.get(8).push('M');
            stacks.get(8).push('R');

            do {
                input = scanner.nextLine();
                System.out.println(input);
            } while (!input.equals(""));

            while (input != null) {

                try {
                    input = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    break;
                }

                String[] inputArray = input.split(" ");

                int from = Integer.parseInt(inputArray[3]) - 1;
                int to = Integer.parseInt(inputArray[5]) - 1;

                List<Character> temp = new ArrayList<>();

                for (int i = 0; i < Integer.parseInt(inputArray[1]); i++) {
                    temp.add(0, stacks.get(from).pop());
                }

                for (Character c : temp) {
                    stacks.get(to).push(c);
                }

            }

            for (Stack<Character> stack : stacks) {
                out.append(stack.peek());
            }

            System.out.println(out);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
