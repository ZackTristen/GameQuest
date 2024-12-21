package Quest;



import java.util.ArrayList;
import java.util.Arrays;

abstract class AbstractLocation {
    boolean playerIsHere = false;
    String description;
    String titleLocation;
    ArrayList <Item> listItems = new ArrayList<>();


    String  showItems() {
        String items = "";
        for(Item item: listItems) {
            items += item.getTitle() + "; ";
        }
        return items;
    }
    void showContext () {
        if (playerIsHere && !listItems.isEmpty()) {
            System.out.println(description + "Здесь находятся: " + showItems());
        } else if (playerIsHere) {
            System.out.println(description);
        }
    }
}
