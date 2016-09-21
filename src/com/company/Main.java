package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = Options.load();
        if (game == null) {
            Options.createSurvey();
            Options.displayFile(game);
        }
        Options.displayFile(game);
        System.out.println();
        System.out.println("Would you like to update your file?");
        String decision = Options.scanner.nextLine();
        if (decision.equalsIgnoreCase("n")) {
            System.out.println("Shutting down, thank you for your time.");
            System.exit(0);
        }
        Options.updateFile(game);
        Options.save(game);
    }
}



