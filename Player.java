package Quest;


import java.util.ArrayList;


public class Player implements Interactable {

    static ArrayList<Item> inventory = new ArrayList<>();


    //������� ������������ ���������
    public void showInventory() {
        System.out.println("� ��� � ��������� ����: ");
        for (Item item : inventory) {
            System.out.println(item.getTitle() + "; ");

        }
    }
    public void  dropItem(String drop) {
    for (Item item: Player.inventory) {
        if (item.getTitle().equals(drop)) {
            Player.inventory.remove(item);
            for ( Location location : GameWorld.locations) {
                if (location.playerIsHere) {
                    location.listItems.add(item);
                    System.out.println("�� �������� ������� " + item.getTitle() + " � ������� " + location.titleLocation);
                }
            }
        }
    }

    }
    //������� ��� ��������� �������� �� �������
    public void getItem(String titleItem) {
        inventory.add(GameWorld.getItemFromLocation(titleItem));
        System.out.println("� ��� ���� " + titleItem);
    }

    //    public void showItemsAround() {
//        for (Item item: GameWorld.currentLocationItems) {
//            System.out.println(item.title);
//        }
//    }
    public void getDescr() {
        for (Location location : GameWorld.locations) {
            if (location.playerIsHere) {
                location.showContext();
            }
        }
    }

    //����� ��� ��������� �������� �������
//    public void showContext(String comand) {
//      if (comand.equals("�����������") || comand.equals("�����������"))   {
//          getDescr();
//      }
//    }
//�������� �� false ������� �������, ��������� ��������� �� ������ �������
    public void leaveLocation() {
        for (Location location : GameWorld.locations) {
            if (location.titleLocation.equals(GameWorld.currentLocationTitle)) {
                location.playerIsHere = false;
            }
        }
    }
    //����� ��� ��������� ������� ���������
    //�������� ������� ���� � ������ GameWorld
    public void changeLocation(String coord) {

//  ����� ���������� �� ������������ �� ��������
        switch (GameWorld.currentLocationTitle) {
            case "��������" -> {
                switch (coord) {
                    case "���� ������", "��������� �� ��������":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("������");
                        getDescr();
                        break;

                    case "���� ������", "���� �� �����":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("���");
                        getDescr();
                        break;

                    default:
                        System.out.println("������ ���� ������ �����");
                        break;
                }
            }
//  ����� ���������� �� ������������ �� �������
            case "������" -> {
                if (coord.equals("���� ����")) {
                    leaveLocation();
                    GameWorld.changeCurrentLocation("��������");
                    getDescr();
                } else {
                    System.out.println("������ ���� ������ �����");
                    getDescr();
                }
            }
//  ����� ���������� �� ������������ � ����
            case "���" -> {
                switch (coord) {
                    case "���� �� ������", "���� �������":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("��������");
                        getDescr();
                        break;

                    default:
                        System.out.println("������ ���� ������ �����");
                        break;
                }
            }
        }
    }

    //������� �������� ������� �������� � ���������
    public boolean findItem(String nameItem) {
        if (!nameItem.isEmpty()) {
            for (Item item: inventory) {
                if (item.getTitle().equals(nameItem)) {
                    return true;
                }
            }
        }
    return false;
    }

    @Override
    public void useItem(String item, String target) {
        if(findItem(item)) {
            if (target.isEmpty()) {
                System.out.println("�� �� �������� �������� ������� ��������");
            }
            else {
            if (findItem(target)) {
                for (Item itemFirst: inventory) {
                    if (itemFirst.getTitle().equals(item)) {

                        itemFirst.useSomeObject(target);
                    }
                }
            }
            else if (!GameWorld.getDescription().isEmpty() && GameWorld.getDescription().contains(target)) {
                for (Item itemFirst: inventory) {
                    if (itemFirst.getTitle().equals(item)) {
                        itemFirst.interactWith(target);
                    }
                }
            }
            }
        } else {
            System.out.println("����� �������� ��� � ����� ���������");
        }
    }
}
