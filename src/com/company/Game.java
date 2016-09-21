package com.company;

import jodd.json.JsonSerializer;

import java.io.File;

/**
 * Created by michaelplott on 9/21/16.
 */
public class Game {
    String name;
    String studio;
    String opinion;
    String platform;
    boolean isOwned;

    public Game () {

    }

    public Game (String name, String studio, String opinion, String platform, boolean isOwned) {
        this.name = name;
        this.studio = studio;
        this.opinion = opinion;
        this.platform = platform;
        this.isOwned = isOwned;
    }

    public String getName() {
        return name;
    }

    public String getStudio() {
        return studio;
    }

    public String getOpinion() {
        return opinion;
    }

    public String getPlatform() {
        return platform;
    }

    public boolean isOwned() {
        return isOwned;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", studio='" + studio + '\'' +
                ", opinion='" + opinion + '\'' +
                ", platform='" + platform + '\'' +
                ", isOwned=" + isOwned +
                '}';
    }
}
