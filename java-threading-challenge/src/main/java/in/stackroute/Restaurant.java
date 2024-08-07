package in.stackroute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import in.stackroute.Table;

public class Restaurant {

    private List<Table> tables;

    public Restaurant(int numTables, int tableCapacity) {
        tables = new ArrayList<>();
        for (int i = 1; i <= numTables; i++) {
            tables.add(new Table(i, tableCapacity));
        }
    }
    public synchronized Table getAvailableTable(int requiredCapacity) {
         Optional<Table> opt = tables.stream()
                .filter(table -> !table.isOccupied() && table.getCapacity() >= requiredCapacity)
                .findFirst();
        return opt.orElse(null);
    }

    public synchronized void occupyTable(Table table) {
        if (!table.isOccupied()) {
            table.occupy();
            System.out.println("Table " + table.getTableId() + " has been occupied.");
        } else {
            System.out.println("Table " + table.getTableId() + " is already occupied.");
        }
    }

    public synchronized void leaveTable(Table table) {
        if (table.isOccupied()) {
            table.leave();
            System.out.println("Table " + table.getTableId() + " has been freed.");
        } else {
            System.out.println("Table " + table.getTableId() + " is already free.");
        }
    }
}
