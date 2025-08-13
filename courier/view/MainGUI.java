package courier.view;

import courier.manager.PackageManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
    private final PackageManager manager = new PackageManager();

    private JPanel contentPane;
    private JLabel title;
    private JButton CostEstimateButton;
    private JButton AddPackageButton;
    private JButton UpdatePackageButton;
    private JButton DisplayButton;
    private JButton SearchButton;
    private JButton RemoveButton;

    public MainGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        title = new JLabel("Select an operation.");
        title.setBounds(49, 44, 61, 16);
        contentPane.add(title);

        CostEstimateButton = new JButton("Estimate Cost");
        CostEstimateButton.setBounds(49, 44, 61, 16);
        CostEstimateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                estimateCost();
            }
        });
        contentPane.add(CostEstimateButton);

        AddPackageButton = new JButton("Add Package");
        AddPackageButton.setBounds(49, 44, 61, 16);
        AddPackageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addPackage();
            }
        });
        contentPane.add(AddPackageButton);

        UpdatePackageButton = new JButton("Update Package");
        UpdatePackageButton.setBounds(49, 44, 61, 16);
        UpdatePackageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                updatePackage();
            }
        });
        contentPane.add(UpdatePackageButton);

        DisplayButton = new JButton("Display All");
        DisplayButton.setBounds(49, 44, 61, 16);
        DisplayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                displayAll();
            }
        });
        contentPane.add(DisplayButton);

        SearchButton = new JButton("Search");
        SearchButton.setBounds(49, 44, 61, 16);
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                searchAll();
            }
        });

    }

    public void estimateCost() {
        CostEstimateGUI ceGUI = new CostEstimateGUI(manager);
        ceGUI.setVisible(true);
    }

    public void addPackage() {
        AddPackageGUI apgui = new AddPackageGUI(manager);
        apgui.setVisible(true);
    }

    public void updatePackage() {
        // TODO: hook up UpdatePackageGUI
    }

    public void displayAll() {
        System.out.println("[displayAll] Total packages: " + manager.all().size());
    }

    public void searchAll() {
        // TODO: hook up SearchGUI
    }

    public PackageManager manager() { return manager; }
}
