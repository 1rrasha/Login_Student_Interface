import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Interface extends JFrame implements ActionListener {
    JLabel studentNameLabel, studentNumberLabel;
    JTextField studentNameField, studentNumberField;
    JButton enterButton;
    static StudentChart studentChart = new StudentChart();

    public Login_Interface() {
        studentNameLabel = new JLabel("Student Name:");
        studentNumberLabel = new JLabel("Student Number:");
        studentNameField = new JTextField(20); // Set length to 20 characters
        studentNumberField = new JTextField(20);
        enterButton = new JButton("Enter");

        // Setting up layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        add(studentNameLabel, gbc);

        gbc.gridy++;
        add(studentNameField, gbc);

        gbc.gridy++;
        add(studentNumberLabel, gbc);

        gbc.gridy++;
        add(studentNumberField, gbc);


        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(enterButton, gbc);

        enterButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String studentName = studentNameField.getText();
            String studentNumber = studentNumberField.getText();
            if (!studentName.isEmpty() && !studentNumber.isEmpty()) {
                Student student = new Student(studentName, studentNumber);
                studentChart.addStudent(student);
                JOptionPane.showMessageDialog(this, "Student Added:\n" + student);
                // to clear fields after adding student
                studentNameField.setText("");
                studentNumberField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in both fields.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login_Interface());
    }
}
