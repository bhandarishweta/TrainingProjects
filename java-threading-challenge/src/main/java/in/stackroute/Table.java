package in.stackroute;

public class Table {

    private int tableId;
    private int capacity;
    private boolean occupied;

    public Table(int tableId, int capacity) {
        this.tableId = tableId;
        this.capacity = capacity;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public synchronized void leave() {
        occupied = false;
    }

    public int getTableId() {
        return tableId;
    }

    public int getCapacity() {
        return capacity;
    }
}
