package courier.view;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import courier.model.Package;

public class DisplayTableModel extends AbstractTableModel {

    private final List<Package> list;
    private final String[] columnNames = new String[] {"ID", "Destination", "Weight", "Description", "Status", "Expected Arrival", "Mailed Date"};

    public DisplayTableModel(List<Package> list) {
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Package pkg = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pkg.getId();
            case 1:
                return pkg.getDestination();
            case 2:
                return pkg.getWeight();
            case 3:
                return pkg.getDescription();
            case 4:
                return pkg.getStatus();
            case 5:
                return pkg.getExpectedArrival();
            case 6:
                return pkg.getMailedDate();
        }
        return null;
    }
}
