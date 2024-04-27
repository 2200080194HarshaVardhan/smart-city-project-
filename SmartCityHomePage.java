import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCityHomePage extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JButton trafficButton;
    private JButton wasteButton;
    private JButton energyButton;
    private JButton safetyButton;

    public SmartCityHomePage() {
        setTitle("Smart City");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create components
        titleLabel = new JLabel("Welcome to Smart City!");
        trafficButton = new JButton("Traffic Management");
        wasteButton = new JButton("Waste Management");
        energyButton = new JButton("Energy Management");
        safetyButton = new JButton("Public Safety");

        // Set layout
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));
        centerPanel.add(trafficButton);
        centerPanel.add(wasteButton);
        centerPanel.add(energyButton);
        centerPanel.add(safetyButton);
        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        trafficButton.addActionListener(this);
        wasteButton.addActionListener(this);
        energyButton.addActionListener(this);
        safetyButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == trafficButton) {
            showTrafficManagementDetails();
        } else if (e.getSource() == wasteButton) {
            showWasteManagementDetails();
        } else if (e.getSource() == energyButton) {
            showEnergyManagementDetails();
        } else if (e.getSource() == safetyButton) {
            showPublicSafetyDetails();
        }
    }

    private void showTrafficManagementDetails() {
        String details = "Traffic Management:\n" +
                "- Real-time traffic monitoring system.\n" +
                "- Traffic flow optimization algorithms.\n" +
                "- Intelligent traffic light control.\n" +
                "- Incident detection and management.\n" +
                "- Traffic data analytics for city planning.";
        JOptionPane.showMessageDialog(this, details);
    }

    private void showWasteManagementDetails() {
        String details = "Waste Management:\n" +
                "- Collection and disposal of household waste.\n" +
                "- Recycling programs and waste sorting facilities.\n" +
                "- Composting initiatives for organic waste.\n" +
                "- Hazardous waste disposal services.\n" +
                "- Public awareness campaigns for waste reduction.";
        JOptionPane.showMessageDialog(this, details);
    }

    private void showEnergyManagementDetails() {
        String details = "Energy Management:\n" +
                "- Monitoring and optimization of energy consumption.\n" +
                "- Integration of renewable energy sources.\n" +
                "- Smart grid technology for efficient energy distribution.\n" +
                "- Energy-efficient building designs and retrofits.\n" +
                "- Demand response programs to manage peak loads.";
        JOptionPane.showMessageDialog(this, details);
    }

    private void showPublicSafetyDetails() {
        String details = "Public Safety:\n" +
                "- Police patrolling and crime prevention initiatives.\n" +
                "- Emergency response services for accidents and disasters.\n" +
                "- CCTV surveillance systems for public areas.\n" +
                "- Community policing and neighborhood watch programs.\n" +
                "- Firefighting and rescue services.";
        JOptionPane.showMessageDialog(this, details);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SmartCityHomePage();
            }
        });
    }
}
