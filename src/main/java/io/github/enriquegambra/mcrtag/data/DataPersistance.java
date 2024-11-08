package io.github.enriquegambra.mcrtag.data;

import io.github.enriquegambra.mcrtag.entity.PlayerSession;
import io.github.enriquegambra.mcrtag.entity.TagSessionEntity;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DataPersistance {

    private static ConcurrentHashMap<String, TagSessionEntity> tagSessionsMap = new ConcurrentHashMap();

    public static void createTagSession(String sessionGuid) {

        TagSessionEntity tagSessionEntity = new TagSessionEntity(sessionGuid);

        tagSessionsMap.putIfAbsent(sessionGuid, tagSessionEntity);

    }

    public static String createTagSessionAndReturnGUID() {

        String sessionGuid = UUID.randomUUID().toString();

        createTagSession(sessionGuid);

        return sessionGuid;
    }

    public static boolean hasTagSession(String sessionGuid) {

        return tagSessionsMap.containsKey(sessionGuid);

    }

    public static void addPlayerToTagSession(String sessionGuid, PlayerSession playerSession) {

        tagSessionsMap.get(sessionGuid).addPlayer(playerSession.getUuid().toString(), playerSession);

    }


}
