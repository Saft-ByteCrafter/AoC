package day15.part2;

public class Range {

    private int lbound;
    private int ubound;

    public Range(int lbound, int ubound) {
        this.lbound = lbound;
        this.ubound = ubound;
    }

    public boolean intersects(Range range) {
        return (this.lbound - 1 <= range.ubound && this.lbound + 1 >= range.lbound) ||
                (this.ubound - 1 <= range.ubound && this.ubound + 1 >= range.lbound) ||
                (this.lbound - 1 <= range.lbound && this.ubound + 1 >= range.ubound) ||
                (this.lbound + 1 >= range.lbound && this.ubound - 1 <= range.ubound);
    }

    public void merge(Range range) {
        this.lbound = Math.min(this.lbound, range.lbound);
        this.ubound = Math.max(this.ubound, range.ubound);
    }

    public int getLbound() {
        return lbound;
    }

    public int getUbound() {
        return ubound;
    }

    @Override
    public String toString() {
        return "%d - %d".formatted(lbound, ubound);
    }

}
