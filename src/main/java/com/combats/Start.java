package com.combats;

/*
 * command for launch not compiled from console:
 * mvn exec:java -Dexec.mainClass="com.combats.Start" -Dlogin=login -Dpassword=password
 * -DtelegramAPI=telegramAPI -Dpet=yes/no -Dheadless=true/false
 *
 * command for launch Combats.jar from console:
 * java -Dlogin=login -Dpassword=password -Dpet=yes/no -Dheadless=true/false -jar Combats-version.jar
 */
public class Start {

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

}
