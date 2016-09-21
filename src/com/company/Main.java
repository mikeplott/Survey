package com.company;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static final String FILE_NAME = "game.json";

    public static void main(String[] args) {
        Game game = load();
        if (game == null) {
            createSurvey();
        }
            String theName = game.getName();
            String theDev = game.getStudio();
            String theOpinion = game.getOpinion();
            String thePlatform = game.getPlatform();
            Boolean owned = game.isOwned();
            System.out.printf("\nGame: %s\nDeveloper: %s\nOpinion: %s\nPlatform: %s\nOwned: %s\n", theName, theDev, theOpinion, thePlatform, owned);
            System.out.println();
        }

    static void createSurvey() {
        System.out.println("Would you mind taking a quick survey about video games?");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.exit(0);
        }
        System.out.println("Awesome thank you!");
        System.out.println("What video game have you played recently?");
        String gameChoice = scanner.nextLine();
        System.out.printf("Who developed %s?\n", gameChoice);
        String devChoice = scanner.nextLine();
        System.out.printf("What is your opinion about %s and %s?\n", gameChoice, devChoice);
        String userOpinion = scanner.nextLine();
        System.out.printf("Do you currently own this %s? Type y or n.\n", gameChoice);
        String userOwned = scanner.nextLine();
        boolean userOwns;
        if (userOwned.equalsIgnoreCase("y")) {
            userOwns = true;
        } else {
            userOwns = false;
        }
        System.out.printf("What platform did you play %s on?\n", gameChoice);
        String userPlatform = scanner.nextLine();
        Game game = new Game(gameChoice, devChoice, userOpinion, userPlatform, userOwns);
        System.out.println("Thank you for your input!");
        save(game);

    }





    static void save (Game game) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(game);
        File f = new File(FILE_NAME);
        try {
            FileWriter gameWriter = new FileWriter(f);
            gameWriter.write(json);
            gameWriter.close();
            System.out.println("File saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not save the file.");
        }
    }
    static Game load() {
        File f = new File(FILE_NAME);
        try {
            FileReader gameReader = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            gameReader.read(contents , 0 , fileSize);
            JsonParser parser = new JsonParser();
            Game game = parser.parse(contents, Game.class);
            System.out.println("File loaded successfully!");
            return game;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Could not load file or no file to load.");
            createSurvey();
        }
        Game game = new Game();
        return game;
    }
}
