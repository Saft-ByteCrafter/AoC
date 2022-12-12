package day11.part2;

import java.util.ArrayList;
import java.util.List;

public abstract class Monke {

    private long inspections;
    protected final List<Remainder> items;

    protected Monke(List<Integer> items) {
        this.inspections = 0;
        this.items = new ArrayList<>();
        items.forEach(item -> this.items.add(new Remainder(item)));
    }

    protected abstract void inspectItem();

    protected abstract int nextMonke(Remainder newItem);

    private void addItem(Remainder item) {
        items.add(item);
    }

    private void throwItem() {
        inspectItem();
        Remainder newItem = items.get(0);
        inspections++;
        items.remove(0);
        Main.monkes.get(nextMonke(newItem)).addItem(newItem);
    }

    protected void yeetAll() {
        while(!items.isEmpty()) throwItem();
    }

    protected long getInspections() {
        return inspections;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        items.forEach(item -> out.append(item).append(", "));
        return out.toString();
    }

}
