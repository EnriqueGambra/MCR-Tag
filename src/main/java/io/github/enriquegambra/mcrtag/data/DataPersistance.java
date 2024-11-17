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

        TagSessionEntity tagSessionEntity = tagSessionsMap.get(sessionGuid);

        if (tagSessionEntity.isPlayerAlreadyInGame(playerSession.getUuid().toString())) {

            throw new RuntimeException("You have already joined this session of tag!");

        }

        tagSessionEntity.addPlayer(playerSession.getUuid().toString(), playerSession);

    }

    public static TagSessionEntity getTagSession(String sessionGuid) {

        if (!tagSessionsMap.containsKey(sessionGuid)) {

           throw new RuntimeException("No tag session found for guid: " + sessionGuid);

        }

        return tagSessionsMap.get(sessionGuid);
    }


}
