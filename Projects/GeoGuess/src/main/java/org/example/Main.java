package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int score = 0;
    static int currentIndex = 0;
    public static void main(String[] args) {

        JFrame jf = new JFrame("Country and Capital");
        jf.setSize(400, 300);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HashMap<String, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/quiz_data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    map.put(parts[0], parts[1]);
                }
            }
        } catch(Exception e){
            System.out.println(e);
            return;
        }

        List<String> countries = new ArrayList<>(map.keySet());

        Collections.shuffle(countries);

        String firstCountry = countries.get(currentIndex);
        JLabel questionLabel = new JLabel("What is the captial of " + firstCountry + "?");
        questionLabel.setBounds(50, 40, 300, 30);
        jf.add(questionLabel);

        JTextField answerField = new JTextField();
        answerField.setBounds(50, 90, 200, 30);
        jf.add(answerField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(260, 90, 90, 30);
        jf.add(submitButton);

        submitButton.addActionListener(e ->{
            String userInput = answerField.getText().trim();
            String correctCountry = countries.get(currentIndex);
            if(userInput.equalsIgnoreCase(map.get(correctCountry))){
                JOptionPane.showMessageDialog(jf, "Wow you are correct!");
                score++;
            }
            else{
                JOptionPane.showMessageDialog(jf, "Wrong The correct answer was : " + map.get(correctCountry));

            }
            answerField.setText("");
            currentIndex++;
            if(currentIndex < countries.size()) {
                String country = countries.get(currentIndex);
                questionLabel.setText("What is the captial of " + country + "?");
            }
            else{
                JOptionPane.showMessageDialog(jf, "You have completed the Quiz. Your final Score : " + score);
                System.exit(0);
            }
        });

        System.out.println("=================================================================\nYOUR SCORE is " + score + "\n===================================================================");
        jf.setVisible(true);
    }
}