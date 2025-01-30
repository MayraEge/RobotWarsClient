package com.btcag.bootcamp2024.RobotWarsClient.Views;

public class IntroScreenView {
    public static void display() {
        String name = AskPlayerNameView.display();
        String story = "Herzlich Willkommen, " + name + ", bei Robot Wars! \n" +
                "In diesem miserabel programmierten Spiel darfst du Dich im Duell gegen andere, starke Roboter beweisen.\n" +
                "Wirst du deinen Zug machen können, bevor die Verbindung abbricht? Finden wir es heraus!\n";

        String intro =
                "  ____       _           _     __        __            \n" +
                        " |  _ \\ ___ | |__   __ _| |_ __\\ \\      / /_ _ _ __ ___ \n" +
                        " | |_) / _ \\| '_ \\ / _` | __/ _ \\ \\ /\\ / / _` | '__/ _ \\\n" +
                        " |  _ < (_) | |_) | (_| | ||  __/\\ V  V / (_| | | |  __/\n" +
                        " |_| \\_\\___/|_.__/ \\__,_|\\__\\___| \\_/\\_/ \\__,_|_|  \\___|\n" +
                        "                                                       \n" +
                        "                                                       \n";

        System.out.println(intro);
        System.out.println(story);
    }
}