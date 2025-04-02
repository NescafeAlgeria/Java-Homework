import javax.swing.*;

class ConfigPanel extends JPanel {
    private JLabel label;
    private JTextField dotsField;
    private JButton createButton;

    public ConfigPanel(DrawingPanel drawingPanel) {
        label = new JLabel("Number of dots:");
        dotsField = new JTextField("10", 5);
        createButton = new JButton("New Game");

        createButton.addActionListener(e -> {
            int numDots;
            try {
                numDots = Integer.parseInt(dotsField.getText());
                drawingPanel.generateDots(numDots);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(label);
        add(dotsField);
        add(createButton);
    }
}