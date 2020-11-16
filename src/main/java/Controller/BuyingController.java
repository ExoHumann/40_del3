package Controller;

import Model.FieldList;
import Model.Fields.Field;
import Model.Fields.Ownable;
import Model.PlayerList;
import Model.Playerlist.Account;
import Model.Playerlist.Player;

public class BuyingController {

    boolean isAllFieldsInSeriesOwned;

    public BuyingController() {

    }

    public boolean isAllFieldInSeriesOwned(PlayerList pl, FieldList fl, int playerTurn) {
        int fieldsWithColor = 0;
        int fieldsOwnedInTheSameColor = 0;
        for (int i = 0; i <fl.getSize() ; i++) {

            int pos = pl.getPlayerList(playerTurn).getCurrentPosition();

            Field currentField = fl.getField(pos);
            Field field = fl.getField(i);

            if (field.getColor() == currentField.getColor()){
                fieldsWithColor++;
                if (field instanceof Ownable && currentField instanceof Ownable) {
                    if (((Ownable) field).getOwner() == ((Ownable) currentField).getOwner()){
                        fieldsOwnedInTheSameColor++;
                    }
                }
            }

            isAllFieldsInSeriesOwned = fieldsWithColor == fieldsOwnedInTheSameColor;
        }
        return isAllFieldsInSeriesOwned;
    }


    public void buyNextPossibleField(PlayerList pl, FieldList fl, int playerTurn) {
        Player player = pl.getPlayerList(playerTurn);
        int pos = pl.getPlayerList(playerTurn).getCurrentPosition();
        Ownable field = (Ownable) fl.getField(pos);

        if (field != null) {
            while (field.getOwner() == -1) {
                player.move(1, fl);
            }
        } else {
                player.move(1,fl);
        }
        buyField(pl, fl, playerTurn);
        player.buyNextPossibleField = false;
    }


    public void buyField(PlayerList pl, FieldList fl, int playerTurn) {
        int pos = pl.getPlayerList(playerTurn).getCurrentPosition();
        int fieldPrice = fl.getField(pos).getPrice();
        Account account = pl.getAccount(playerTurn);

        Ownable field = (Ownable) fl.getField(pos);

        if (field != null){
        int ownership = field.getOwner();

        if (ownership == -1) {
            account.withdraw(fieldPrice);
            field.setOwner(playerTurn);
        } else {
            System.out.println("The player will now pay to player number " + (ownership));
            if (isAllFieldInSeriesOwned(pl, fl, playerTurn)) {
                account.pay(fieldPrice * 2, pl.getAccount(ownership));
            } else {
                account.pay(fieldPrice, pl.getAccount(ownership));
            }
        }
        }
    }
}


