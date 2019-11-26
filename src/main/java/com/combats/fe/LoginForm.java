package com.combats.fe;

import com.combats.be.TopLevelLogic;
import com.combats.telegram.Bot;
import com.combats.utils.FileWorker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static com.combats.telegram.PropertiesOfTelegramBot.startTelegramBot;
import static com.combats.utils.Properties.*;
import static com.combats.utils.Utils.getListHours;
import static com.combats.utils.Utils.getListMinutes;
import static javax.swing.SwingConstants.CENTER;

/**
 * Create UI form for input variables and login in the game
 */
public class LoginForm extends JFrame {

    public static Bot bot;

    private String[] loginAndPassword = FileWorker.readUserDataFile();
    private JTextField loginField = new JTextField(loginAndPassword[0], 20);
    private JPasswordField passwordField = new JPasswordField(loginAndPassword[1], 20);

    private String[] telegramBotNameAndToken = FileWorker.readUserDataFile();
    private JTextField telegramBotNameField = new JTextField(telegramBotNameAndToken[2], 30);
    private JTextField telegramBotTokenField = new JTextField(telegramBotNameAndToken[3], 30);

    private JRadioButton pvpRadio = new JRadioButton("PvP");

    private JCheckBox petCheck = new JCheckBox("Pet");
    private JCheckBox browserOffCheck = new JCheckBox("Browser off");

    private JComboBox endTimeHours = new JComboBox(getListHours());
    private JComboBox endTimeMinutes = new JComboBox(getListMinutes());

    public LoginForm() {
        super("CombatsBot");
        setBounds(800, 500, 450, 300);
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

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        Box typeOfBattleBox = Box.createHorizontalBox();
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(pvpRadio);
        JRadioButton dungeonRadio = new JRadioButton("Dungeon");
        bGroup.add(dungeonRadio);
        typeOfBattleBox.add(pvpRadio);
        pvpRadio.setSelected(true);
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

        Box buttonsBox = Box.createHorizontalBox();
        buttonsBox.add(Box.createHorizontalGlue());
        JButton telegramButton = new JButton("Telegram");
        buttonsBox.add(telegramButton);
        buttonsBox.add(Box.createHorizontalStrut(140));
        JButton startButton = new JButton("Start");
        buttonsBox.add(startButton);

        JLabel telegramLabel = new JLabel("Telegram");
        telegramLabel.setHorizontalAlignment(CENTER);

        Box botNameBox = Box.createHorizontalBox();
        JLabel botNameLabel = new JLabel("Name:");
        botNameBox.add(botNameLabel);
        botNameBox.add(Box.createHorizontalStrut(6));
        botNameBox.add(telegramBotNameField);

        Box botTokenBox = Box.createHorizontalBox();
        JLabel botTokenLabel = new JLabel("Token:");
        botTokenBox.add(botTokenLabel);
        botTokenBox.add(Box.createHorizontalStrut(6));
        botTokenBox.add(telegramBotTokenField);

        botNameLabel.setPreferredSize(botTokenLabel.getPreferredSize());

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
        mainBox.add(buttonsBox);
        setContentPane(mainBox);
        pack();

        telegramButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonsBox.remove(telegramButton);
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(telegramLabel, BorderLayout.CENTER);
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(botNameBox);
                mainBox.add(Box.createVerticalStrut(10));
                mainBox.add(botTokenBox);
                pack();
            }
        });

        this.getRootPane().setDefaultButton(startButton);

        startButton.addActionListener(new ButtonStartListener());
        startButton.addActionListener(e -> this.dispose());
    }

    class ButtonStartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            setUserLogin(loginField.getText());
            setUserPassword(String.valueOf(passwordField.getPassword()));

            setTypeOfGame(pvpRadio.isSelected());
            setPet(petCheck.isSelected());
            setHeadless(browserOffCheck.isSelected());

            setEndTimeOfTheGame(Objects.requireNonNull(endTimeHours.getSelectedItem()), Objects.requireNonNull(endTimeMinutes.getSelectedItem()));

            setTelegramBotName(telegramBotNameField.getText());
            setTelegramBotToken(telegramBotTokenField.getText());

            bot = startTelegramBot();

            TopLevelLogic topLevelLogic = new TopLevelLogic();
            topLevelLogic.game();
        }
    }

}

