package com.combats;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends JFrame {

    private JLabel loginLabel = new JLabel("Login:");
    private JTextField loginField = new JTextField(15);

    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordField = new JPasswordField(15);

    private JRadioButton chaosRadio = new JRadioButton("Chaos");
    private JRadioButton dungeonRadio = new JRadioButton("Dungeon");

    private JCheckBox petCheck = new JCheckBox("Pet");
    private JCheckBox browserOffCheck = new JCheckBox("Browser off");

    private JButton goButton = new JButton("Start");

    public StartForm() {
        super("CombatsBot");
        setBounds(800, 500, 400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Box container1 = Box.createHorizontalBox();
        container1.add(loginLabel);
        container1.add(Box.createHorizontalStrut(6));
        container1.add(loginField);

        Box container2 = Box.createHorizontalBox();
        container2.add(passwordLabel);
        container2.add(Box.createHorizontalStrut(6));
        container2.add(passwordField);

        Box container3 = Box.createHorizontalBox();
        ButtonGroup group = new ButtonGroup();
        group.add(chaosRadio);
        group.add(dungeonRadio);
        container3.add(chaosRadio);
        chaosRadio.setSelected(true);
        container3.add(Box.createHorizontalStrut(20));
        container3.add(dungeonRadio);

        Box container4 = Box.createHorizontalBox();
        container4.add(petCheck);
        container4.add(Box.createHorizontalStrut(23));
        container4.add(browserOffCheck);
        browserOffCheck.setSelected(true);

        Box container5 = Box.createHorizontalBox();
        container5.add(Box.createHorizontalGlue());
        container5.add(goButton);

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(container1);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(container2);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(container3);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(container4);
        mainBox.add(Box.createVerticalStrut(8));
        mainBox.add(container5);
        setContentPane(mainBox);
        pack();

        goButton.addActionListener(new ButtonEventListener());
        goButton.addActionListener(e -> this.dispose());
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.setProperty("login", loginField.getText());
            System.setProperty("password", String.valueOf(passwordField.getPassword()));

            System.setProperty("typeOfGame", chaosRadio.isSelected() ? "chaos" : "dungeon");

            System.setProperty("pet", chaosRadio.isSelected() ? "yes" : "no");
            System.setProperty("headless", String.valueOf(browserOffCheck.isSelected()));

            GameCombatsBot gameCombatsBot = new GameCombatsBot();
            gameCombatsBot.startBE();
        }
    }

    public static void main(String[] args) {
        StartForm startForm = new StartForm();
        startForm.setVisible(true);
    }
}

