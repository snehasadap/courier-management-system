package courier.view;

import courier.model.Package;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class DisplayTableModel extends AbstractTableModel {
    private final String[] cols = {"ID", "Weight", "Description", "Destination", "Mailed", "ETA", "Status"};
    private List<Package> rows = new ArrayList<>();

    public DisplayTableModel(List<Package> data) {
        if (data != null) rows = new ArrayList<>(data);
    }

    public void setRows(List<Package> data) {
        rows = (data == null) ? new ArrayList<>() : new ArrayList<>(data);
        fireTableDataChanged();
    }

    @Override public int getRowCount() { return rows.size(); }
    @Override public int getColumnCount() { return cols.length; }
    @Override public String getColumnName(int c) { return cols[c]; }

    @Override
    public Object getValueAt(int r, int c) {
        Package p = rows.get(r);
        switch (c) {
            case 0: return p.getId();
            case 1: return p.getWeight();
            case 2: return p.getDescription();
            case 3: return p.getDestination();
            case 4: return p.getMailedDate();
            case 5: return p.getExpectedArrival();
            case 6: return p.getStatus();
            default: return "";
        }
    }

    @Override public Class<?> getColumnClass(int c) {
        return (c == 0) ? Integer.class : String.class;
    }
}
