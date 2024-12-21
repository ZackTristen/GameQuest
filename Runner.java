package Quest;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //гостина€

        ArrayList<Item> listItemsLiving;
        listItemsLiving = new ArrayList<>();
        listItemsLiving.add(new Bucket());
        listItemsLiving.add(new BottleWiski());
        Location livingRoom = new Location( true, "¬ы находитесь в гостиной в доме волшебника. ј вот и он сам громко храпит на кровати. Ќа западе от вас есть дверь, р€дом лестница наверх.", "гостина€", listItemsLiving );

        //чердак

        ArrayList<Item> listItemsLadder = new ArrayList<>();
        Location ladder = new Location( false, "¬ы на чердаке старого дома. ¬ углу видна гигантска€ горелка. ¬низ ведет лестница.", "чердак", listItemsLadder );


        //сад

        ArrayList<Item> listItemsGarden = new ArrayList<>();
        listItemsGarden.add(new Frog());
        listItemsGarden.add(new Chain());
        Location garden = new Location(false, "¬ы в прекрасном саду. ѕр€мо по курсу находитс€ колодец. Ќа востоке дверь в дом.", "сад", listItemsGarden );

        GameWorld.locations.add(livingRoom);
        GameWorld.locations.add(ladder);
        GameWorld.locations.add(garden);

        Player newPlayer = new Player();

        while (!GameWorld.GameState) {

//            System.out.println("¬ведите команду 'огл€детьс€' или 'осмотретьс€'");
              String command = in.nextLine();
              if (command.contains("использовать")) {
                  String firstItem = "";
                  String secondItem = "";
                  String regex = "(?i)использовать\\s+(.*?)\\s+на\\s+(.*)";

                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(command);
                  if (matcher.find()) {
                       firstItem = matcher.group(1);
                       secondItem = matcher.group(2);
                  }
                  newPlayer.useItem(firstItem.toLowerCase(), secondItem.toLowerCase());

              }
              else if (command.contains("вз€ть")) {
                  String regex = "(?i)вз€ть\\s+(.*)";
                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(command);
                  if (matcher.find()) {
                      String item = matcher.group(1);
                      newPlayer.getItem(item.toLowerCase());
                  }

              }
              else if (command.contains("идти")) {
                 newPlayer.changeLocation(command);
              }
              else if (command.contains("огл€детьс€") || command.contains("осмотретьс€")) {
              newPlayer.getDescr();
              }
              else if (command.contains("показать") || command.contains("инвентарь")) {
                  newPlayer.showInventory();
              }
              else if (command.contains("положить") || command.contains("выкинуть")) {
                  String regex = "(?i)положить\\s+(.*)";
                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(command);
                  if (matcher.find()) {
                      String item = matcher.group(1);
                      newPlayer.dropItem(item.toLowerCase());
                  }
              }

        }
    }
}
