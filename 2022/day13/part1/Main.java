package day13.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        try (Scanner scan = new Scanner(new File(System.getProperty("user.dir") + "\\2022\\day13\\input"))) {

            List<Character> input = new ArrayList<>();
            int score = 0;
            int indice = 0;

            while (scan.hasNext()) {
                indice++;

                for (Character c : scan.nextLine().toCharArray()) input.add(c);

                List<ListThingy> list1 = new ArrayList<>();
                if (!addLists(list1, input).isEmpty()) System.out.println("EEEEPP das wröng");

                input.clear();
                for (Character c : scan.nextLine().toCharArray()) input.add(c);

                List<ListThingy> list2 = new ArrayList<>();
                if (!addLists(list2, input).isEmpty()) System.out.println("EEEEPP das wröng 2");

                if (scan.hasNext()) scan.nextLine();

                /*list1.forEach(System.out::println);
                list2.forEach(System.out::println);*/

                if (areInRightOrder(list1, list2)) {
                    score += indice;
                }

            }

            System.out.println(score);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<Character> addLists(List<ListThingy> list, List<Character> input) {

        while (!input.isEmpty()) {

            Character nextChar = input.get(0);
            input.remove(0);
            switch (nextChar) {
                case '[':
                    List<ListThingy> nextList = new LinkedList<>();
                    list.add(new ListThingy(nextList));
                    input = addLists(nextList, input);
                    break;
                case ']':
                    return input;
                case ',':
                    break;
                default:
                    StringBuilder value = new StringBuilder();
                    while (!(nextChar == ',')) {
                        if (nextChar == ']') {
                            list.add(new ListThingy(Integer.parseInt(value.toString())));
                            return input;
                        }
                        value.append(nextChar);
                        nextChar = input.get(0);
                        input.remove(0);
                    }
                    list.add(new ListThingy(Integer.parseInt(value.toString())));

            }
        }
        return input;
    }

    private static boolean areInRightOrder(List<ListThingy> list1, List<ListThingy> list2) {

        for (int i = 0; i < list1.size(); i++) {

            if (list2.size() - 1 < i) {
                return false;
            }

            /*if (list1.get(i).hasSublist()) {
                if (list2.get(i).hasSublist()) {
                    if (!areInRightOrder(list1.get(i).getContent(), list2.get(i).getContent())) return false;
                } else if (!areInRightOrder(list1.get(i).getContent(), list2.subList(i, list2.size()))) return false;
            } else if (list2.get(i).hasSublist()) {
                if (!areInRightOrder(list1, list2.get(i).getContent())) return false;
            }*/

            if (list1.get(i).hasSublist()) {
                if (list2.get(i).hasSublist()) {
                    return areInRightOrder(list1.get(i).getContent(), list2.get(i).getContent());
                } else return areInRightOrder(list1.get(i).getContent(), list2.subList(i, list2.size()));
            } else if (list2.get(i).hasSublist()) {
                return areInRightOrder(list1.subList(i, list1.size()), list2.get(i).getContent());
            }


            else if (list1.get(i).getValue() > list2.get(i).getValue()) return false;
            else if (list1.get(i).getValue() < list2.get(i).getValue()) return true;
        }

        return true;
    }

}
