package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePackageGUI extends JFrame {
    private final PackageManager manager;
    private JPanel contentPane;
    private JTextField idInput;
    private JComboBox<String> statusSelect;
    private JTextField expectedArrivalInput;
    private JButton saveButton;

    public UpdatePackageGUI(PackageManager manager) {
        this.manager = manager;
        contentPane = new JPanel();
        idInput = new JTextField();
        idInput.setColumns(10);
        idInput.setBounds(10, 11, 46, 20);
        contentPane.add(idInput);
        statusSelect = new JComboBox<>();
        statusSelect.addItem("Packed");
        statusSelect.addItem("In Transit");
        statusSelect.addItem("Delivered");
        statusSelect.setBounds(10, 40, 46, 20);
        statusSelect.setEditable(false);
        contentPane.add(statusSelect);
        expectedArrivalInput = new JTextField();
        expectedArrivalInput.setText("New Expected Arrival");
        expectedArrivalInput.setColumns(10);
        expectedArrivalInput.setBounds(10, 72, 46, 20);
        contentPane.add(expectedArrivalInput);
        saveButton = new JButton("Save");
        saveButton.setBounds(10, 100, 46, 20);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                update(Integer.parseInt(idInput.getText()), statusSelect.getSelectedItem().toString(), expectedArrivalInput.getText());
            }
        });
    }

    public void update(int id, String status, String expectedArrival) {
        manager.findById(id).ifPresent(p -> {
            if (status != null && !status.isEmpty()) p.setStatus(status);
            if (expectedArrival != null && !expectedArrival.isEmpty()) p.setExpectedArrival(expectedArrival);
        });
    }
}
