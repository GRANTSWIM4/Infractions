package com.demigodsrpg.infractions.sponge;

import com.demigodsrpg.infractions.Backend;
import com.demigodsrpg.infractions.InfractionsConfig;
import com.demigodsrpg.infractions.InfractionsPlayer;
import com.iciql.Db;
import org.spongepowered.api.Game;

import java.util.UUID;

public class SpongeBackend implements Backend {
    private final Game game;
    private final InfractionsConfig config;

    public SpongeBackend(Game game, InfractionsConfig config) {
        this.game = game;
        this.config = config;
    }

    @Override
    public InfractionsConfig getConfig() {
        return config;
    }

    @Override
    public Db openDb() {
        return Db.open(config.databaseUrl());
    }

    @Override
    public InfractionsPlayer getPlayer(String playerId) {
        return new SpongePlayer(game, UUID.fromString(playerId));
    }
}
