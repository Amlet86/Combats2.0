package com.combats.fe;

import com.combats.be.TopLevelLogic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static com.combats.Properties.*;
import static com.combats.Utils.getListHours;
import static com.combats.Utils.getListMinutes;

/**
 * Create UI form for input variables and login in the game
 */
public class LoginForm extends JFrame {

    private JTextField loginField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);

    private JRadioButton chaosRadio = new JRadioButton("Chaos");

    private JCheckBox petCheck = new JCheckBox("Pet");
    private JCheckBox browserOffCheck = new JCheckBox("Browser off");

    private JComboBox endTimeHours = new JComboBox(getListHours());
    private JComboBox endTimeMinutes = new JComboBox(getListMinutes());

    public LoginForm() {
        super("CombatsBot");
        setBounds(800, 500, 400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Box loginBox = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginBox.add(loginLabel);
        loginBox.add(Box.createHorizontalStrut(6));
        loginBox.add(loginField);

        Box passwordBox = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(6));
        passwordBox.add(passwordField);

        Box typeOfBattleBox = Box.createHorizontalBox();
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(chaosRadio);
        JRadioButton dungeonRadio = new JRadioButton("Dungeon");
        bGroup.add(dungeonRadio);
        typeOfBattleBox.add(chaosRadio);
        chaosRadio.setSelected(true);
        typeOfBattleBox.add(Box.createHorizontalStrut(20));
        typeOfBattleBox.add(dungeonRadio);

        Box petAndBrowserBox = Box.createHorizontalBox();
        petAndBrowserBox.add(petCheck);
        petAndBrowserBox.add(Box.createHorizontalStrut(23));
        petAndBrowserBox.add(browserOffCheck);
        browserOffCheck.setSelected(true);

        Box endTimeOfTheGameBox = Box.createHorizontalBox();
        endTimeOfTheGameBox.add(Box.createHorizontalStrut(25));
        endTimeOfTheGameBox.add(new JLabel("End time:"));
        endTimeOfTheGameBox.add(Box.createHorizontalStrut(5));
        endTimeOfTheGameBox.add(endTimeHours);
        endTimeOfTheGameBox.add(new JLabel("hours"));
        endTimeOfTheGameBox.add(Box.createHorizontalStrut(5));
        endTimeOfTheGameBox.add(endTimeMinutes);
        endTimeOfTheGameBox.add(new JLabel("minutes"));
        endTimeOfTheGameBox.add(Box.createHorizontalStrut(25));

        Box startButtonBox = Box.createHorizontalBox();
        startButtonBox.add(Box.createHorizontalGlue());
        JButton startButton = new JButton("Start");
        startButtonBox.add(startButton);

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(loginBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(passwordBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(typeOfBattleBox);
        mainBox.add(Box.createVerticalStrut(5));
        mainBox.add(petAndBrowserBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(endTimeOfTheGameBox);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(startButtonBox);
        setContentPane(mainBox);
        pack();

        this.getRootPane().setDefaultButton(startButton);

        startButton.addActionListener(new ButtonEventListener());
        startButton.addActionListener(e -> this.dispose());
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setUserLogin(loginField.getText());
            setUserPassword(String.valueOf(passwordField.getPassword()));

            setTypeOfGame(chaosRadio.isSelected());
            setPet(petCheck.isSelected());
            setHeadless(browserOffCheck.isSelected());

            setEndTimeOfTheGame(Objects.requireNonNull(endTimeHours.getSelectedItem()), Objects.requireNonNull(endTimeMinutes.getSelectedItem()));

            TopLevelLogic topLevelLogic = new TopLevelLogic();
            topLevelLogic.game();
        }
    }

}

