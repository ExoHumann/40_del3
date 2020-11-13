package Controller;

import Model.FieldList;
import Model.Fields.Field;
import Model.Fields.Ownable;
import Model.PlayerList;
import Model.Playerlist.Account;
import Model.Playerlist.Player;
import java.awt.*;

public class BuyingController {

    boolean isAllFieldsInSeriesOwned;

    public BuyingController() {

    }

    public void isAllFieldInSeriesOwned(PlayerList pl, FieldList fl, int playerTurn) {
        Account account = pl.getAccount(playerTurn);
        int pos = pl.getPlayerList(playerTurn).getCurrentPosition();

        Ownable field = (Ownable) fl.getField(pos);

        Color f1Color = fl.getField(pos + 1).getColor();
        Color f2Color = fl.getField(pos - 1).getColor();

        Field f1 = fl.getField(pos);

        int owner;
        Color fieldColor;

        //if (f1Color != Color.white || f2Color != Color.white) {

        }


        //Color posColor = fl.getField(pos).getColor();
        //if (field.getColor().equals(posColor)) ;

    //}


    public void buyNextPossibleField(PlayerList pl, FieldList fl, Logic logic, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);

        Ownable field = (Ownable) fl.getField(logic.pos);
        logic.prePos = logic.pos;
        while (field.getOwner() == -1 && !fl.getField(logic.pos).getFieldType().equals("Street")) {
            player.move(1, fl);
        }

        buyField(pl, fl, playerTurn);
        player.buyNextPossibleField = false;
    }


    public void buyField(PlayerList pl, FieldList fl, int playerTurn) {
        int pos = pl.getPlayerList(playerTurn).getCurrentPosition();
        int fieldPrice = fl.getField(pos).getPrice();
        Account account = pl.getAccount(playerTurn);

        Ownable field = (Ownable) fl.getField(pos);

        int ownership = field.getOwner();

        if (ownership == -1) {
            account.withdraw(fieldPrice);
            field.setOwner(playerTurn);
        } else {
            System.out.println("The player will now pay to player number " + (ownership));
            if (isAllFieldsInSeriesOwned) {
                account.pay(fieldPrice * 2, pl.getAccount(ownership));
            } else {
                account.pay(fieldPrice, pl.getAccount(ownership));
            }
        }
    }
}


