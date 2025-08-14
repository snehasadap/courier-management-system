package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
    private final PackageManager manager = new PackageManager();

    public MainGUI() {
        super("Courier Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(12,12));
        root.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        setContentPane(root);

        JLabel title = new JLabel("Select an operation.");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        root.add(title, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        root.add(grid, BorderLayout.CENTER);

        grid.add(btn("Estimate Cost",  e -> new CostEstimateGUI(manager).setVisible(true)));
        grid.add(btn("Add Package",    e -> new AddPackageGUI(manager).setVisible(true)));
        grid.add(btn("Update Package", e -> new UpdatePackageGUI(manager).setVisible(true)));
        grid.add(btn("Display All",    e -> new DisplayGUI(manager).setVisible(true)));
        grid.add(btn("Search",         e -> new SearchGUI(manager).setVisible(true)));
        grid.add(btn("Remove",         e -> new RemoveGUI(manager).setVisible(true)));

        pack();
        setMinimumSize(new Dimension(480, 320));
        setLocationRelativeTo(null);
    }

    private JButton btn(String text, java.awt.event.ActionListener a) {
        JButton b = new JButton(text);
        b.addActionListener(a);
        b.setFocusPainted(false);
        return b;
    }
}
