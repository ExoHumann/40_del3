package Model.Fields;
import java.awt.*;

public class Chance extends Field {


    /**
     * Constructor for the field. Used to create fields
     *
     * @param title       title of the field
     * @param price       price of the field
     * @param description description of the field
     * @param color       color of the field
     * @param fieldType   Type of field (Street, GoToJail, Start, Chance and VisitJail)
     */
    public Chance(String title, int price, String description, Color color, String fieldType) {
        super(title, price, description, color, fieldType);
    }

}
