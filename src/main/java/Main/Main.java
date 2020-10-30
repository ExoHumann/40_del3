package Main;

import Controller.Game;
import Translation.Translator;

public class Main {


    public static void main(String[] args) throws InterruptedException {


        Game game = new Game();
        if(args.length != 0){
            game.play(args[0]);
        }else{
            game.play("da");
        }


        }
    }
