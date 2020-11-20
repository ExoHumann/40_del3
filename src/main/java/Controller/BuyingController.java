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

    public boolean isAllFieldInSeriesOwned(Player p, FieldList fl) {
        int fieldsWithColor = 0;
        int fieldsOwnedInTheSameColor = 0;
        for (int i = 0; i < fl.getSize(); i++) {

            int pos = p.getCurrentPosition();

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


    public void buyNextPossibleField(Player p, FieldList fl) { ;
        Field field;
        p.buyNextPossibleField = false;

        for (int i = p.getCurrentPosition() + 1; i != p.getCurrentPosition(); i = (i + 1) % fl.getSize()) {

            field = fl.getField(i);
            if (field instanceof Ownable) {
                if (((Ownable) field).getOwner() == null) {
                    p.setCurrentPosition(i);
                    buyField(p, fl);
                    return;
                }
            }
        }
    }


    public void buyField(Player p, FieldList fl) {
        int pos = p.getCurrentPosition();
        int fieldPrice = fl.getField(pos).getPrice();

        Ownable field = (Ownable) fl.getField(pos);

        if (field != null) {
            Player ownership = field.getOwner();

            if (ownership == null) {
                p.getAccount().withdraw(fieldPrice);
                field.setOwner(p);
            } else {
                if (isAllFieldInSeriesOwned(p,fl)) {
                    System.out.println("The player will now pay the double price to player number " + (ownership));
                    p.getAccount().pay(fieldPrice * 2, ownership.getAccount());
                } else {
                    System.out.println("The player will now pay to player number " + (ownership));
                    p.getAccount().pay(fieldPrice, ownership.getAccount());
                }
            }
        }
    }
}


