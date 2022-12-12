package day11.part1;

import java.util.ArrayList;
import java.util.List;

public abstract class Monke {

    private int inspections;
    protected final List<Integer> items;

    protected Monke(List<Integer> items) {
        this.inspections = 0;
        this.items = new ArrayList<>(items);
    }

    protected abstract int inspectItem();

    protected abstract int nextMonke(int newItem);

    private void addItem(int item) {
        items.add(item);
    }

    private void throwItem() {
        int newItem = inspectItem();
        inspections++;
        newItem = (int) Math.floor(newItem / 3.0);
        items.remove(0);
        Main.monkes.get(nextMonke(newItem)).addItem(newItem);
    }

    protected void yeetAll() {
        while(!items.isEmpty()) throwItem();
    }

    protected int getInspections() {
        return inspections;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        items.forEach(item -> out.append(item).append(", "));
        return out.toString();
    }

}
