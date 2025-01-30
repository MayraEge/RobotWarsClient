package com.btcag.bootcamp2024.RobotWarsClient.Services;

import com.btcag.bootcamp2024.RobotWarsClient.Models.MapData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static MapData[] parseMapData(String json) throws IOException{
        return objectMapper.readValue(json, MapData[].class);
    }
}

