package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchGUI extends JDialog {
    private final PackageManager manager;
    private final JTextField queryField = new JTextField(20);
    private final ResultsModel model = new ResultsModel();
    private final JTable table = new JTable(model);

    public SearchGUI(PackageManager manager) {
        super((Frame) null, "Search Packages", true);
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(12, 12));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setContentPane(root);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        top.add(new JLabel("Query:"));
        top.add(queryField);
        JButton searchBtn = new JButton("Search");
        searchBtn.addActionListener(e -> doSearch());
        top.add(searchBtn);
        root.add(top, BorderLayout.NORTH);

        table.setFillsViewportHeight(true);
        table.setRowHeight(22);
        table.setAutoCreateRowSorter(true);
        root.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(closeBtn);
        root.add(bottom, BorderLayout.SOUTH);

        model.setRows(manager.all());

        pack();
        setSize(Math.max(720, getWidth()), Math.max(360, getHeight()));
        setLocationRelativeTo(null);
    }

    private void doSearch() {
        String q = queryField.getText().trim().toLowerCase();
        List<Package> all = manager.all();
        if (q.isEmpty()) {
            model.setRows(all);
            return;
        }
        List<Package> filtered = all.stream().filter(p -> {
            String idStr = String.valueOf(p.getId());
            String desc = safe(p.getDescription());
            String dest = safe(p.getDestination());
            return idStr.contains(q) || desc.contains(q) || dest.contains(q);
        }).collect(Collectors.toList());
        model.setRows(filtered);
    }

    private static String safe(String s) { return s == null ? "" : s.toLowerCase(); }

    static class ResultsModel extends AbstractTableModel {
        private final String[] cols = {"ID","Weight","Description","Destination","Mailed","ETA","Status"};
        private List<Package> rows = new ArrayList<>();

        public void setRows(List<Package> data) {
            rows = (data == null) ? new ArrayList<>() : new ArrayList<>(data);
            fireTableDataChanged();
        }

        @Override public int getRowCount() { return rows.size(); }
        @Override public int getColumnCount() { return cols.length; }
        @Override public String getColumnName(int c) { return cols[c]; }
        @Override public Class<?> getColumnClass(int c) { return (c == 0) ? Integer.class : String.class; }

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
