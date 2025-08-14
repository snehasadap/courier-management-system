package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import java.awt.*;

public class CostEstimateGUI extends JDialog {
    private final PackageManager manager;
    private final JTextField weightField = new JTextField(10);
    private final JLabel result = new JLabel(" ");

    public CostEstimateGUI(PackageManager manager) {
        super((Frame) null, "Estimate Cost", true);
        this.manager = manager;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel root = new JPanel(new GridBagLayout());
        root.setBorder(BorderFactory.createEmptyBorder(16,16,16,16));
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(6,6,6,6);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST;

        g.gridx=0; g.gridy=0; root.add(new JLabel("Weight (g):"), g);
        g.gridx=1; g.gridy=0; root.add(weightField, g);

        JButton calc = new JButton("Calculate");
        calc.addActionListener(e -> onCalc());

        g.gridx=0; g.gridy=1; g.gridwidth=2; root.add(calc, g);
        g.gridx=0; g.gridy=2; g.gridwidth=2; root.add(result, g);

        setContentPane(root);
        pack();
        setLocationRelativeTo(null);
    }

    private void onCalc() {
        try {
            int weight = Integer.parseInt(weightField.getText().trim());
            double cost = manager.estimate(weight);
            result.setText(String.format("Estimated Cost: $%.2f", cost));
        } catch (NumberFormatException ex) {
            result.setText("Enter a valid integer (grams).");
        }
    }
}
