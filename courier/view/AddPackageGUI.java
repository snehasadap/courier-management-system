package courier.view;

import courier.manager.PackageManager;
import courier.model.Package;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPackageGUI extends JFrame{
    private final PackageManager manager;
    private JPanel contentPane;
    private JTextField weightInput;
    private JTextField descriptionInput;
    private JTextField destinationInput;
    private JTextField mailedDateInput;
    private JTextField expectedArrivalInput;
    private JButton saveButton;

    public AddPackageGUI(PackageManager manager) {
        this.manager = manager;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        weightInput = new JTextField();
        weightInput.setColumns(10);
        weightInput.setBounds(10, 11, 46, 20);
        contentPane.add(weightInput);
        descriptionInput = new JTextField();
        descriptionInput.setColumns(10);
        descriptionInput.setBounds(10, 36, 46, 20);
        contentPane.add(descriptionInput);
        destinationInput = new JTextField();
        destinationInput.setColumns(10);
        destinationInput.setBounds(10, 52, 46, 20);
        contentPane.add(destinationInput);
        mailedDateInput = new JTextField();
        mailedDateInput.setColumns(10);
        mailedDateInput.setBounds(10, 82, 46, 20);
        contentPane.add(mailedDateInput);
        expectedArrivalInput = new JTextField();
        expectedArrivalInput.setColumns(10);
        expectedArrivalInput.setBounds(10, 106, 46, 20);
        contentPane.add(expectedArrivalInput);
        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> save(Integer.parseInt(weightInput.getText()), descriptionInput.getText(), destinationInput.getText(),
                mailedDateInput.getText(), expectedArrivalInput.getText()));
        saveButton.setBounds(122, 120, 117, 29);
        contentPane.add(saveButton);
    }

    public Package save(int weight, String description, String destination, String mailedDate, String expectedArrival) {
        return manager.add(weight, description, destination, mailedDate, expectedArrival);
    }
}
