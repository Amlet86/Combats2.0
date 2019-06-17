package com.combats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends JFrame {

    private JLabel loginLabel = new JLabel("Login:");
    private JTextField loginField = new JTextField("");

    private JLabel passwordLabel = new JLabel("Password:");
    private JTextField passwordField = new JTextField("");

    private JRadioButton chaosRadio = new JRadioButton("Chaos");
    private JRadioButton dungeonRadio = new JRadioButton("Dungeon");

    private JCheckBox browserOnCheck = new JCheckBox("Browser off");

    private JButton goButton = new JButton("Let's go!");

    public StartForm() {
        super("CombatsBot");
        this.setBounds(800, 500, 400, 250);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 2));
        container.add(loginLabel);
        container.add(loginField);
        container.add(passwordLabel);
        container.add(passwordField);

        ButtonGroup group = new ButtonGroup();
        group.add(chaosRadio);
        group.add(dungeonRadio);
        container.add(chaosRadio);
        chaosRadio.setSelected(true);
        container.add(dungeonRadio);

        container.add(browserOnCheck);
        container.add(goButton);

        goButton.addActionListener(new ButtonEventListener());
        goButton.addActionListener(e -> this.dispose());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.setProperty("login", loginField.getText());
            System.setProperty("password", passwordField.getText());

            System.setProperty("typeOfGame", chaosRadio.isSelected() ? "chaos" : "dungeon");
            System.setProperty("headless", String.valueOf(browserOnCheck.isSelected()));

            GameCombatsBot gameCombatsBot = new GameCombatsBot();
            gameCombatsBot.startBE();

        }
    }

    public static void main(String[] args) {
        StartForm startForm = new StartForm();
        startForm.setVisible(true);
    }
}

