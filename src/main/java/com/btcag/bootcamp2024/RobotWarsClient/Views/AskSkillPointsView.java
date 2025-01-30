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
     * @param player
     * Roboter, dessen Attribute verteilt werden.
     */

    public static void setStats(Robot player) {
        int spend = 0;
        Scanner scanner = new Scanner(System.in);

        while (spend < TOTAL_SKILLPOINTS) {
            System.out.println("Bitte verteile 10 Skillpoints auf die folgenden Attribute deines Roboters: \n Bewegungsrate: "+ player.getMovementRange() + "\n Schaden: "+ player.getAttackDamage() + "\n Gesundheit: " + player.getHealth() + "\n Reichweite: " + player.getAttackRange());
            System.out.println("Drücke m für Movementrange, d für Schaden, g für Gesundheit und r für Angriffsreichweite. Du kannst noch "+(TOTAL_SKILLPOINTS - spend)+" Punkte verteilen.");
            String input = scanner.nextLine();

            switch (input) {
                case MOVEMENT:
                    player.setMovementRange(player.getMovementRange() + 1);
                    spend += 1;
                    break;
                case ATTACK_DAMAGE:
                    player.setAttackDamage(player.getAttackDamage() + 1);
                    spend += 1;
                    break;
                case HEALTH:
                    player.setHealth(player.getHealth() + 1);
                    spend += 1;
                    break;
                case ATTACK_RANGE:
                    player.setAttackRange(player.getAttackRange() + 1);
                    spend += 1;
                    break;
                default:
                    System.out.println("Eingabe ungültig.");
                    break;
            }
        }
    }
    /**
     * Zeigt die aktuellen Attribute des Roboters an.
     *
     * @param player
     *
     */
    public static void display(Robot player) {
        System.out.println("Die Attribute Ihres Roboters: \n" +
                " Bewegungsrate: " + player.getMovementRange() + "\n Schaden: "
                + player.getAttackDamage() + "\n Gesundheit: "
                + player.getHealth() + "\n Reichweite: "
                + player.getAttackRange());
    }
}
