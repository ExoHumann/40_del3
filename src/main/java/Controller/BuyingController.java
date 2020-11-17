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
        for (int i = 0; i < fl.getSize(); i++) {

            int pos = pl.getPlayerList(playerTurn).getCurrentPosition();

            Field currentField = fl.getField(pos);
            Field field = fl.getField(i);

            if (field.getColor() == currentField.getColor()) {
                fieldsWithColor++;
                if (field instanceof Ownable && currentField instanceof Ownable) {
                    if (((Ownable) field).getOwner() == ((Ownable) currentField).getOwner()) {
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

        Field field;
        player.buyNextPossibleField = false;

        for (int i = player.getCurrentPosition() + 1;
             i != player.getCurrentPosition();
             i = (i + 1) % fl.getSize()) {

            field = fl.getField(i);
            if (field instanceof Ownable) {

                if (((Ownable) field).getOwner() == -1) {
                    player.setCurrentPosition(i);
                    buyField(pl, fl, playerTurn);
                    return;
                }
            }
        }
    }


    public void buyField(PlayerList pl, FieldList fl, int playerTurn) {
        int pos = pl.getPlayerList(playerTurn).getCurrentPosition();
        int fieldPrice = fl.getField(pos).getPrice();
        Account account = pl.getAccount(playerTurn);

        Ownable field = (Ownable) fl.getField(pos);

        if (field != null) {
            int ownership = field.getOwner();

            if (ownership == -1) {
                account.withdraw(fieldPrice);
                field.setOwner(playerTurn);
            } else {
                if (isAllFieldInSeriesOwned(pl, fl, playerTurn)) {
                    System.out.println("The player will now pay the double price to player number " + (ownership));
                    account.pay(fieldPrice * 2, pl.getAccount(ownership));
                } else {
                    System.out.println("The player will now pay to player number " + (ownership));
                    account.pay(fieldPrice, pl.getAccount(ownership));
                }
            }
        }
    }
}


