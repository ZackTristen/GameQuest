package Quest;


import java.util.ArrayList;

public class Location  extends AbstractLocation {

 Location(boolean PHere, String description, String titleLocation, ArrayList <Item> items) {
      this.listItems = items;
      this.titleLocation = titleLocation;
      this.description = description;
      this.playerIsHere = PHere;

 }

}
