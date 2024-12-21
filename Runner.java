package Quest;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //��������

        ArrayList<Item> listItemsLiving;
        listItemsLiving = new ArrayList<>();
        listItemsLiving.add(new Bucket());
        listItemsLiving.add(new BottleWiski());
        Location livingRoom = new Location( true, "�� ���������� � �������� � ���� ����������. � ��� � �� ��� ������ ������ �� �������. �� ������ �� ��� ���� �����, ����� �������� ������.", "��������", listItemsLiving );

        //������

        ArrayList<Item> listItemsLadder = new ArrayList<>();
        Location ladder = new Location( false, "�� �� ������� ������� ����. � ���� ����� ���������� �������. ���� ����� ��������.", "������", listItemsLadder );


        //���

        ArrayList<Item> listItemsGarden = new ArrayList<>();
        listItemsGarden.add(new Frog());
        listItemsGarden.add(new Chain());
        Location garden = new Location(false, "�� � ���������� ����. ����� �� ����� ��������� �������. �� ������� ����� � ���.", "���", listItemsGarden );

        GameWorld.locations.add(livingRoom);
        GameWorld.locations.add(ladder);
        GameWorld.locations.add(garden);

        Player newPlayer = new Player();

        while (!GameWorld.GameState) {

//            System.out.println("������� ������� '����������' ��� '�����������'");
              String command = in.nextLine();
              if (command.contains("������������")) {
                  String firstItem = "";
                  String secondItem = "";
                  String regex = "(?i)������������\\s+(.*?)\\s+��\\s+(.*)";

                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(command);
                  if (matcher.find()) {
                       firstItem = matcher.group(1);
                       secondItem = matcher.group(2);
                  }
                  newPlayer.useItem(firstItem.toLowerCase(), secondItem.toLowerCase());

              }
              else if (command.contains("�����")) {
                  String regex = "(?i)�����\\s+(.*)";
                  Pattern pattern = Pattern.compile(regex);
                  Matcher matcher = pattern.matcher(command);
                  if (matcher.find()) {
                      String item = matcher.group(1);
                      newPlayer.getItem(item.toLowerCase());
                  }

              }
              else if (command.contains("����")) {
                 newPlayer.changeLocation(command);
              }
              else if (command.contains("����������") || command.contains("�����������")) {
              newPlayer.getDescr();
              }
              else if (command.contains("��������") || command.contains("���������")) {
                  newPlayer.showInventory();
              }
              else if (command.contains("��������") || command.contains("��������")) {
                  String regex = "(?i)��������\\s+(.*)";
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
