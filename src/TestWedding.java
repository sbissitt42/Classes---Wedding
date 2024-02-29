import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.time.LocalDate;

// Define a  wedding application
public class TestWedding {

    // Declare text fields for user input
    private JTextField brideFirstNameField, brideLastNameField, groomFirstNameField, groomLastNameField;
    private JTextField weddingDateField, locationField;

    // Constructor to set up the ui
    public TestWedding() {
        // Create a JFrame (window) with a grid layout
        JFrame frame = new JFrame("Wedding Information");
        frame.setLayout(new GridLayout(0, 2));

        // Initialize text fields for bride and groom information
        brideFirstNameField = new JTextField();
        brideLastNameField = new JTextField();
        groomFirstNameField = new JTextField();
        groomLastNameField = new JTextField();
        weddingDateField = new JTextField();
        locationField = new JTextField();

        // add labels and text fields to the JFrame
        addLabelAndField(frame, "Bride's First Name:", brideFirstNameField);
        addLabelAndField(frame, "Bride's Last Name:", brideLastNameField);
        addLabelAndField(frame, "Groom's First Name:", groomFirstNameField);
        addLabelAndField(frame, "Groom's Last Name:", groomLastNameField);
        addLabelAndField(frame, "Wedding Date (YYYY-MM-DD):", weddingDateField);
        addLabelAndField(frame, "Wedding Location:", locationField);

        // Create a button for submitting the information
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createWedding(); // Call method to create and display wedding details
            }
        });

        // Add the submit button to the frame
        frame.add(submitButton);

        // Configure frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    // Helper method to add labels and text fields to the frame
    private void addLabelAndField(JFrame frame, String label, JTextField textField) {
        frame.add(new JLabel(label));
        frame.add(textField);
    }

    // Method to create a wedding based on user input
    private void createWedding() {
        // Retrieve user input from text fields
        String brideFirstName = brideFirstNameField.getText();
        String brideLastName = brideLastNameField.getText();
        String groomFirstName = groomFirstNameField.getText();
        String groomLastName = groomLastNameField.getText();
        String weddingDateStr = weddingDateField.getText();
        String location = locationField.getText();

        // Create person objects for bride and groom
        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);

        // Create a couple and wedding based on user input
        Couple couple = new Couple(bride, groom);
        LocalDate weddingDate = LocalDate.parse(weddingDateStr);
        Wedding wedding = new Wedding(couple, weddingDate, location);

        // Display wedding details using a dialog
        displayWeddingDetails(wedding);
    }

    // Method to display wedding details in a dialog
    private void displayWeddingDetails(Wedding wedding) {
        // Display wedding details using a JOptionPane
        JOptionPane.showMessageDialog(null,
                "Wedding Details:\n" +
                        "Couple: " + wedding.getCouple().getBride().getFirstName() + " and " +
                        wedding.getCouple().getGroom().getFirstName() + "\n" +
                        "Wedding Date: " + wedding.getWeddingDate() + "\n" +
                        "Location: " + wedding.getLocation(),
                "Wedding Information", JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestWedding(); // Create an instance of the TestWedding class
            }
        });
    }
}
