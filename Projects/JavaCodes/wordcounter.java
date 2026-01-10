import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WordCharCount extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton wordButton, charButton, bgColorButton, textColorButton;

    WordCharCount() {
        super("Word Character Counter - JavaTpoint");
        
        textArea = new JTextArea();
        textArea.setBounds(50, 50, 300, 200);

        wordButton = createButton("Word", 50, 300, 100, 30);
        charButton = createButton("Character", 180, 300, 100, 30);
        bgColorButton = createButton("Background Color", 50, 340, 150, 30);
        textColorButton = createButton("Text Color", 210, 340, 120, 30);

        addComponents();
        addActionListeners();
        
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createButton(String label, int x, int y, int width, int height) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        return button;
    }

    private void addComponents() {
        add(textArea);
        add(wordButton);
        add(charButton);
        add(bgColorButton);
        add(textColorButton);
    }

    private void addActionListeners() {
        wordButton.addActionListener(this);
        charButton.addActionListener(this);
        bgColorButton.addActionListener(this);
        textColorButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        if (e.getSource() == wordButton) {
            String[] words = text.split("\\s");
            showMessage("Total words: " + words.length);
        } else if (e.getSource() == charButton) {
            showMessage("Total Characters with space: " + text.length());
        } else if (e.getSource() == bgColorButton) {
            Color bgColor = JColorChooser.showDialog(this, "Choose Background Color", Color.WHITE);
            textArea.setBackground(bgColor);
        } else if (e.getSource() == textColorButton) {
            Color textColor = JColorChooser.showDialog(this, "Choose Text Color", Color.BLACK);
            textArea.setForeground(textColor);
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

public class CharWordCountTool {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCharCount::new);
    }
}
