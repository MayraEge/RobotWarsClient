package com.btcag.bootcamp2024.RobotWarsClient.Views;

import com.btcag.bootcamp2024.RobotWarsClient.Models.Robot;

import java.util.Scanner;

public class AskSkillPointsView {
    private static final int TOTAL_SKILLPOINTS = 15;
    private static final String MOVEMENT = "m";
    private static final String ATTACK_DAMAGE = "d";
    private static final String HEALTH = "g";
    private static final String ATTACK_RANGE = "r";

    /**
     * Verteilt die Skillpunkte auf die Attribute des Roboters basierend auf Nutzereingaben.
     *
     * @param player Roboter, dessen Attribute verteilt werden.
     */

    public static void setStats(Robot player) {
        Scanner scanner = new Scanner(System.in);
        int remainingPoints = TOTAL_SKILLPOINTS;

        while (remainingPoints > 0) {
            System.out.println("Bitte verteile die verbleibenden " + remainingPoints + " Skillpoints auf die folgenden Attribute deines Roboters:");
            System.out.println("Bewegungsrate: ");
            int movement = scanner.nextInt();
            System.out.println("Schaden: ");
            int damage = scanner.nextInt();
            System.out.println("Gesundheit: ");
            int health = scanner.nextInt();
            System.out.println("Reichweite: ");
            int range = scanner.nextInt();

            int total = movement + damage + health + range;
            if (total <= TOTAL_SKILLPOINTS) {
                player.setMovementRange(movement);
                player.setAttackDamage(damage);
                player.setHealth(health);
                player.setAttackRange(range);
                remainingPoints -= total;
                System.out.println("Die Attribute wurden erfolgreich gesetzt.");
                break;
            } else {
                System.out.println("Die Gesamtpunkte überschreiten die verfügbaren Skillpoints. Bitte erneut versuchen.");
            }
        }

    }

    public static void display(Robot player) {
        System.out.println("Die Attribute Ihres Roboters: \n" +
                " Bewegungsrate: " + player.getMovementRange() + "\n Schaden: "
                + player.getAttackDamage() + "\n Gesundheit: "
                + player.getHealth() + "\n Reichweite: "
                + player.getAttackRange());
    }
}
