import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCityApplication extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton[] serviceButtons; // Array to hold service buttons
    private JPanel loginPanel;
    private JPanel homePanel;

    public SmartCityApplication() {
        setTitle("Smart City");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize components
        titleLabel = new JLabel("Welcome to Smart City!");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        serviceButtons = new JButton[8]; // Create an array of service buttons
        loginPanel = new JPanel();
        homePanel = new JPanel();

        // Set layout for login panel
        loginPanel.setLayout(new GridLayout(4, 2));
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel()); // Empty label for spacing
        loginPanel.add(loginButton);

        // Set layout for home panel
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.add(titleLabel);
        homePanel.add(Box.createVerticalStrut(10)); // Add vertical space

        // Add service buttons for various modules
        String[] serviceNames = {"Traffic", "Waste", "Energy", "Safety", "Environment", "Water", "Infrastructure", "Healthcare"};
        for (int i = 0; i < serviceButtons.length; i++) {
            serviceButtons[i] = new JButton(serviceNames[i]);
            serviceButtons[i].addActionListener(this);
            homePanel.add(createSmallButton(serviceButtons[i]));
        }

        // Add action listener to login button
        loginButton.addActionListener(this);

        // Initially, show login panel
        getContentPane().add(loginPanel);
        setVisible(true);
    }

    // Create a small button with spacing
    private JPanel createSmallButton(JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.WEST);
        panel.add(Box.createHorizontalStrut(10), BorderLayout.EAST); // Add horizontal space
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Simple login validation (you should use secure authentication mechanisms in a real application)
            if (username.equals("admin") && password.equals("password")) {
                // If login is successful, switch to home panel
                getContentPane().removeAll();
                getContentPane().add(homePanel);
                revalidate();
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
            }
        } else {
            // Handle service buttons
            for (int i = 0; i < serviceButtons.length; i++) {
                if (e.getSource() == serviceButtons[i]) {
                    // Placeholder message for demonstration purposes
                    JOptionPane.showMessageDialog(this, "Details for " + serviceButtons[i].getText());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SmartCityApplication();
            }
        });
    }
}
