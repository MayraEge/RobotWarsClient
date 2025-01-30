package com.btcag.bootcamp2024.RobotWarsClient.Services;

import java.util.UUID;

public class IdGenerator {
    public static String generateUniqueId(){
        return UUID.randomUUID().toString();
    }
}
