package com.combats;

import com.combats.fe.LoginForm;

/**
 * Command for launch not compiled program from console:
 * mvn exec:java -Dexec.mainClass="com.combats.Start" -Dlogin=login -Dpassword=password etc.
 * <p>
 * Command for launch compiled *.jar file from console:
 * java -jar Combats-<version from pom.xml>.jar
 */
public class Start {

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

}
