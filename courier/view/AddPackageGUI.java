package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import java.awt.*;

public class AddPackageGUI extends JDialog {
    private final PackageManager manager;

    private final JTextField weightField       = new JTextField(12); // grams
    private final JTextField descriptionField  = new JTextField(20);
    private final JTextField destinationField  = new JTextField(20);
    private final JTextField mailedDateField   = new JTextField(12); // YYYY-MM-DD
    private final JTextField etaField          = new JTextField(12); // YYYY-MM-DD

    public AddPackageGUI(PackageManager manager) {
        super((Frame) null, "Add Package", true);
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6,6,6,6);
        g.anchor = GridBagConstraints.WEST;
        g.fill = GridBagConstraints.HORIZONTAL;

        int r = 0;
        addRow(root, g, r++, "Weight (g):", weightField);
        addRow(root, g, r++, "Description:", descriptionField);
        addRow(root, g, r++, "Destination:", destinationField);
        addRow(root, g, r++, "Mailed date (YYYY-MM-DD):", mailedDateField);
        addRow(root, g, r++, "Expected arrival (YYYY-MM-DD):", etaField);

        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> onSave());
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dispose());

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btns.add(cancelBtn);
        btns.add(saveBtn);

        g.gridx = 0; g.gridy = r; g.gridwidth = 2;
        root.add(btns, g);

        setContentPane(root);
        pack();
        setMinimumSize(new Dimension(420, getHeight()));
        setLocationRelativeTo(null);
    }

    private void addRow(JPanel root, GridBagConstraints g, int row, String label, JComponent field) {
        g.gridx = 0; g.gridy = row; g.gridwidth = 1; g.weightx = 0;
        root.add(new JLabel(label), g);
        g.gridx = 1; g.gridy = row; g.weightx = 1;
        root.add(field, g);
    }

    private void onSave() {
        int weight;
        try {
            weight = Integer.parseInt(weightField.getText().trim());
            if (weight <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a positive integer for weight (grams).",
                    "Invalid input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String desc = descriptionField.getText().trim();
        String dest = destinationField.getText().trim();
        String mailed = mailedDateField.getText().trim();
        String eta = etaField.getText().trim();

        if (desc.isEmpty() || dest.isEmpty() || mailed.isEmpty() || eta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.",
                    "Missing data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Package p = manager.add(weight, desc, dest, mailed, eta);
        JOptionPane.showMessageDialog(this, "Saved. New ID: " + p.getId());
        dispose();
    }
}
