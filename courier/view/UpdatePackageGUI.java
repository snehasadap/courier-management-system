package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import java.awt.*;

public class UpdatePackageGUI extends JDialog {
    private final PackageManager manager;
    private final JTextField idField = new JTextField(8);
    private final JTextField statusField = new JTextField(12);
    private final JTextField etaField = new JTextField(12);

    public UpdatePackageGUI(PackageManager manager) {
        super((Frame) null, "Update Package", true);
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6,6,6,6);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST;

        int r=0;
        addRow(root, g, r++, "ID:", idField);
        addRow(root, g, r++, "Status:", statusField);
        addRow(root, g, r++, "Expected arrival (YYYY-MM-DD):", etaField);

        JButton save = new JButton("Save");
        save.addActionListener(e -> onSave());
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> dispose());

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btns.add(cancel);
        btns.add(save);

        g.gridx=0; g.gridy=r; g.gridwidth=2;
        root.add(btns, g);

        setContentPane(root);
        pack();
        setLocationRelativeTo(null);
    }

    private void addRow(JPanel root, GridBagConstraints g, int row, String label, JComponent field){
        g.gridx=0; g.gridy=row; g.gridwidth=1; g.weightx=0; root.add(new JLabel(label), g);
        g.gridx=1; g.gridy=row; g.weightx=1; root.add(field, g);
    }

    private void onSave() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric ID.", "Invalid input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String status = statusField.getText().trim();
        String eta = etaField.getText().trim();

        Package p = manager.findById(id).orElse(null);
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Package not found.", "Not found", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!status.isEmpty()) p.setStatus(status);
        if (!eta.isEmpty()) p.setExpectedArrival(eta);

        JOptionPane.showMessageDialog(this, "Package updated.");
        dispose();
    }
}
