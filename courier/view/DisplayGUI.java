package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.List;

public class DisplayGUI extends JFrame{
    private final PackageManager manager;
    private JPanel contentPane;
    private JTable table;

    public DisplayGUI(PackageManager manager) {
        this.manager = manager;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DisplayTableModel model = new DisplayTableModel(tableModel());
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(25);
        contentPane.add(table);
    }

    public List<Package> tableModel() {
        return manager.all();
    }
}
