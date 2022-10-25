package abyss.plugin.api.query.npc;

import abyss.plugin.api.*;
import abyss.plugin.api.query.SpiritQuery;
import abyss.plugin.api.world.WorldTile;

import java.util.List;
import java.util.regex.Pattern;

public final class NpcQuery implements SpiritQuery<NpcQuery> {

    private int[] ids;

    private String[] names;

    private String[] options;

    private Pattern namePattern;
    private Area3di area;
    private WorldTile tile;
    private int health;

    private int healthDeviation;
    private int serverIndex;
    private int interactIndex;

    private Vector3 nearest;

    public NpcQuery() {
        this.ids = null;
        this.names = null;
        this.options = null;
        this.namePattern = null;
        this.area = null;
        this.tile = null;
        this.health = -1;
        this.healthDeviation = 0;
        this.serverIndex = -1;
        this.interactIndex = -1;
        this.nearest = null;
    }


    @Override
    public NpcQuery id(int... ids) {
        this.ids = ids;
        return this;
    }

    @Override
    public NpcQuery names(String... names) {
        this.names = names;
        return this;
    }

    @Override
    public NpcQuery names(Pattern pattern) {
        this.namePattern = pattern;
        return this;
    }

    @Override
    public NpcQuery within(Area3di area) {
        this.area = area;
        return this;
    }

    @Override
    public NpcQuery tile(WorldTile tile) {
        this.tile = tile;
        return this;
    }

    @Override
    public NpcQuery nearest(Vector3 pos) {
        this.nearest = pos;
        return this;
    }

    @Override
    public NpcQuery health(int value, int deviation) {
        this.health = value;
        this.healthDeviation = deviation;
        return this;
    }

    @Override
    public NpcQuery serverIndex(int index) {
        this.serverIndex = index;
        return this;
    }

    @Override
    public NpcQuery options(String... options) {
        this.options = options;
        return this;
    }

    @Override
    public NpcQuery interactIndex(int index) {
        this.interactIndex = index;
        return this;
    }

    @Deprecated
    @Override
    public NpcQuery activeStatusBar(float mineValue, float maxValue) {
        return this;
    }

    @Deprecated
    @Override
    public NpcQuery activeStatusBar(int barId) {
        return this;
    }

    public native List<Npc> results();
}