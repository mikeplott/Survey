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
            displayFile(game);
        }
        displayFile(game);
        System.out.println();
        System.out.println("Would you like to update your file?");
        String decision = scanner.nextLine();
        if (decision.equalsIgnoreCase("n")) {
            System.out.println("Shutting down, thank you for your time.");
            System.exit(0);
        }
        updateFile(game);
        save(game);
    }



    static void updateFile(Game game) {
        boolean keepUpdating = true;
        while (keepUpdating) {
            displayFile(game);
            System.out.println();
            System.out.println("Type /exit to stop updating");
            System.out.println();
            System.out.println("What would you like to update?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("game")) {
                System.out.println("Please enter a game");
                String userGame = scanner.nextLine();
                game.setName(userGame);
            } else if (choice.equalsIgnoreCase("Developer")) {
                System.out.println("Enter a new dev");
                String userDev = scanner.nextLine();
                game.setStudio(userDev);
            } else if (choice.equalsIgnoreCase("Opinion")) {
                System.out.println("What do you think?");
                String userOpinion = scanner.nextLine();
                game.setOpinion(userOpinion);
            } else if (choice.equalsIgnoreCase("Platform")) {
                System.out.println("Enter your platform");
                String userPlat = scanner.nextLine();
                game.setPlatform(userPlat);
            } else if (choice.equalsIgnoreCase("Owned")) {
                System.out.println("Do you own it?");
                String userOwned = scanner.nextLine();
                if (userOwned.equalsIgnoreCase("y")) {
                    game.setOwned(true);
                }
            }
            else if (choice.equalsIgnoreCase("/exit")) {
                keepUpdating = false;
            }
        }
    }
    static void createSurvey() {
        System.out.println("Will you answer a quick survey about video games?");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("n")) {
            System.exit(0);
        }
        System.out.println("Awesome thank you!");
        System.out.println("What video game have you played recently?");
        String gameChoice = scanner.nextLine();
        System.out.printf("Who developed %s?\n", gameChoice);
        String devChoice = scanner.nextLine();
        System.out.printf("What is your opinion about %s and %s?\n", gameChoice, devChoice);
        String userOpinion = scanner.nextLine();
        System.out.printf("Do you currently own %s? Type y or n.\n", gameChoice);
        String userOwned = scanner.nextLine();
        System.out.printf("What platform did you play %s on?\n", gameChoice);
        String userPlatform = scanner.nextLine();
        Game game = new Game(gameChoice,devChoice,userOpinion,userPlatform);
        if(userOwned.equalsIgnoreCase("y")) {
            game.setOwned(true);
        }
        System.out.println("Thank you for your input!");
        save(game);

    }
    static void save (Game game) {
        int i = 0;
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
            return game;
        } catch (Exception e) {
            System.out.println("Could not load file or no file to load.");
            System.out.println("Creating new survey.");
            createSurvey();
        }
        Game game = load();
        return game;
    }
    static void displayFile(Game game) {
        String theName = game.getName();
        String theDev = game.getStudio();
        String theOpinion = game.getOpinion();
        String thePlatform = game.getPlatform();
        Boolean owned = game.isOwned();
        System.out.printf("\nGame: %s\nDeveloper: %s\nOpinion: %s\nPlatform: %s\nOwned: %s\n", theName, theDev, theOpinion, thePlatform, owned);
    }
}
