package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import java.awt.*;

public class RemoveGUI extends JDialog {
    private final PackageManager manager;
    private final JTextField idField = new JTextField(10);

    public RemoveGUI(PackageManager manager) {
        super((Frame) null, "Remove Package", true);
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        setContentPane(root);
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6, 6, 6, 6);
        g.anchor = GridBagConstraints.WEST;
        g.fill = GridBagConstraints.HORIZONTAL;

        g.gridx = 0; g.gridy = 0; root.add(new JLabel("Package ID:"), g);
        g.gridx = 1; g.gridy = 0; root.add(idField, g);

        JButton removeBtn = new JButton("Remove");
        removeBtn.addActionListener(e -> onRemove());
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dispose());

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(cancelBtn);
        buttons.add(removeBtn);

        g.gridx = 0; g.gridy = 1; g.gridwidth = 2;
        root.add(buttons, g);

        pack();
        setMinimumSize(new Dimension(360, getHeight()));
        setLocationRelativeTo(null);
    }

    private void onRemove() {
        int id;
        try {
            id = Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid numeric ID.",
                    "Invalid input", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean ok = manager.removePackage(id);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Package " + id + " removed.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Package " + id + " not found.",
                    "Not found", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
