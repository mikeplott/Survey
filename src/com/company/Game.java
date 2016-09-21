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

    public Game (String name, String studio, String opinion, String platform) {
        this.name = name;
        this.studio = studio;
        this.opinion = opinion;
        this.platform = platform;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
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
