package Model.ChanceCards;

import Controller.Logic;
import Model.FieldList;
import Model.Playerlist.Player;
import View.GameGUI;

public abstract class ChanceCard {

    public abstract void onDraw(Player p, GameGUI gameGUI, Logic logic, FieldList fl);

}
