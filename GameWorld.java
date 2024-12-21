package Quest;

import java.util.ArrayList;

public class GameWorld {
    static boolean GameState = false;
    static ArrayList <Location> locations = new ArrayList<>();
    static ArrayList <Item> currentLocationItems = new ArrayList<>();
    static String currentLocationTitle = GetStarting();

    public static String getDescription() {
        for (Location location: locations) {
            if (location.playerIsHere) {
                return location.description;
            }
        }
        return "";
    }


    public static String GetStarting() {
        for (Location location: locations) {
            if (location.playerIsHere) {
               return currentLocationTitle = location.titleLocation;
            }
        }
        return "гостиная";
    }

   // функция удаления/получения предмета из локации
   public static Item getItemFromLocation(String titleItem) {
       for (Location location: locations) {
           if (location.playerIsHere) {
               for (int i = 0; i <= location.listItems.size() - 1; i++) {
                   if (location.listItems.get(i).title.equals(titleItem)) {
                       Item itemClone = location.listItems.get(i);
                       location.listItems.remove(i);
                       return itemClone;

                   }
               }
           }

       }
       return null;
   }

//    метод для перемещения персонажа по игровому миру
    static void changeCurrentLocation(String loc) {
        currentLocationTitle = loc;
        for (Location location: locations) {
            if (location.titleLocation.equals(currentLocationTitle)) {
                location.playerIsHere = true;
            }
        }
    }

}
