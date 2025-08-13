package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CostEstimateGUI extends JFrame{
    private final PackageManager manager;
    private JPanel contentPane;
    private JTextField weightInput;
    private JTextField costOutput;
    private JButton calculateButton;

    public CostEstimateGUI(PackageManager manager) {
        this.manager = manager;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        weightInput = new JTextField();
        weightInput.setBounds(122, 39, 130, 26);
        contentPane.add(weightInput);
        weightInput.setColumns(10);

        costOutput = new JTextField();
        costOutput.setBounds(122, 81, 130, 26);
        costOutput.setEditable(false);
        contentPane.add(costOutput);
        costOutput.setColumns(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                costOutput.setText(estimate(Integer.parseInt(weightInput.getText())) + "");
            }
        });
        calculateButton.setBounds(122, 120, 117, 29);
        contentPane.add(calculateButton);
    }


    public double estimate(int weight) {
        return manager.estimate(weight);
    }
}
