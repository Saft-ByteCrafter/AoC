package day11.part2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static final List<Monke> monkes = new ArrayList<>();

    public static void main(String[] args) {

        // haha hardcoding go brrrrrr...
        /*monkes.add(new Monke(List.of(79, 98)) {
            protected void inspectItem() {
                items.get(0).multiply(19);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(23) == 0) return 2;
                return 3;
            }
        });
        monkes.add(new Monke(List.of(54, 65, 75, 74)) {
            protected void inspectItem() {
                items.get(0).add(6);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(19) == 0) return 2;
                return 0;
            }
        });
        monkes.add(new Monke(List.of(79, 60, 97)) {
            protected void inspectItem() {
                items.get(0).square();
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(13) == 0) return 1;
                return 3;
            }
        });
        monkes.add(new Monke(List.of(74)) {
            protected void inspectItem() {
                items.get(0).add(3);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(17) == 0) return 0;
                return 1;
            }
        });*/ // -> for the test-thingy
        monkes.add(new Monke(List.of(91, 54, 70, 61, 64, 64, 60, 85)) {
            protected void inspectItem() {
                items.get(0).multiply(13);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(2) == 0) return 5;
                return 2;
            }
        });
        monkes.add(new Monke(List.of(82)) {
            protected void inspectItem() {
                items.get(0).add(7);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(13) == 0) return 4;
                return 3;
            }
        });
        monkes.add(new Monke(List.of(84, 93, 70)) {
            protected void inspectItem() {
                items.get(0).add(2);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(5) == 0) return 5;
                return 1;
            }
        });
        monkes.add(new Monke(List.of(78, 56, 85, 93)) {
            protected void inspectItem() {
                items.get(0).multiply(2);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(3) == 0) return 6;
                return 7;
            }
        });
        monkes.add(new Monke(List.of(64, 57, 81, 95, 52, 71, 58)) {
            protected void inspectItem() {
                items.get(0).square();
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(11) == 0) return 7;
                return 3;
            }
        });
        monkes.add(new Monke(List.of(58, 71, 96, 58, 68, 90)) {
            protected void inspectItem() {
                items.get(0).add(6);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(17) == 0) return 4;
                return 1;
            }
        });
        monkes.add(new Monke(List.of(56, 99, 89, 97, 81)) {
            protected void inspectItem() {
                items.get(0).add(1);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(7) == 0) return 0;
                return 2;
            }
        });
        monkes.add(new Monke(List.of(68, 72)) {
            protected void inspectItem() {
                items.get(0).add(8);
            }

            protected int nextMonke(Remainder newItem) {
                if (newItem.getRemainder(19) == 0) return 6;
                return 0;
            }
        });

        for (int i = 0; i < 10000; i++) {
            for (Monke monke : monkes) {
                monke.yeetAll();
            }
        }

        monkes.sort((o1, o2) -> Long.compare(o2.getInspections(), o1.getInspections()));

        System.out.println(monkes.get(0).getInspections() * monkes.get(1).getInspections());

    }

}
