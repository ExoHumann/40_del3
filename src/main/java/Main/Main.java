package Main;

import Controller.Game;
import Translation.Translator;

public class
Main {


    public static void main(String[] args) throws InterruptedException {

        String lang = args.length != 0 ? args[0] : "en";

        Game game = new Game(lang);

        game.play();


        }
    }
