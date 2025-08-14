package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayGUI extends JFrame {
    private final PackageManager manager;
    private JTable table;
    private DisplayTableModel model;

    public DisplayGUI(PackageManager manager) {
        super("All Packages");
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(12,12));
        root.setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
        setContentPane(root);

        model = new DisplayTableModel(manager.all());
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(22);
        table.setAutoCreateRowSorter(true);

        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(e -> model.setRows(manager.all()));
        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.add(refresh);
        root.add(south, BorderLayout.SOUTH);

        pack();
        setSize(Math.max(getWidth(), 720), Math.max(getHeight(), 360));
        setLocationRelativeTo(null);
    }

    static class DisplayTableModel extends AbstractTableModel {
        private final String[] cols = {"ID","Weight","Description","Destination","Mailed","ETA","Status"};
        private List<Package> rows = new ArrayList<>();

        DisplayTableModel(List<Package> data){ setRows(data); }
        public void setRows(List<Package> data){
            rows = (data == null) ? new ArrayList<>() : new ArrayList<>(data);
            fireTableDataChanged();
        }

        @Override public int getRowCount(){ return rows.size(); }
        @Override public int getColumnCount(){ return cols.length; }
        @Override public String getColumnName(int c){ return cols[c]; }
        @Override public Class<?> getColumnClass(int c){ return (c == 0) ? Integer.class : String.class; }

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
    }
}
