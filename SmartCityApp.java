import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SmartCityApp extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton homeButton;
    private JButton aboutUsButton;
    private JButton featuresButton;

    public SmartCityApp() {
        setTitle("Smart City Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Welcome to Smart City!"));

        JPanel aboutUsPanel = new JPanel();
        aboutUsPanel.add(new JLabel("About Us: We are dedicated to building a smarter city."));

        JPanel featuresPanel = new JPanel();
        featuresPanel.add(new JLabel("Features: Explore the features of our Smart City."));

        cardPanel.add(homePanel, "home");
        cardPanel.add(aboutUsPanel, "aboutUs");
        cardPanel.add(featuresPanel, "features");

        add(cardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        homeButton = new JButton("Home");
        aboutUsButton = new JButton("About Us");
        featuresButton = new JButton("Features");

        homeButton.addActionListener(this);
        aboutUsButton.addActionListener(this);
        featuresButton.addActionListener(this);

        buttonPanel.add(homeButton);
        buttonPanel.add(aboutUsButton);
        buttonPanel.add(featuresButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            cardLayout.show(cardPanel, "home");
        } else if (e.getSource() == aboutUsButton) {
            cardLayout.show(cardPanel, "aboutUs");
        } else if (e.getSource() == featuresButton) {
            cardLayout.show(cardPanel, "features");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SmartCityApp();
            }
        });
    }
}
