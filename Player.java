package Quest;


import java.util.ArrayList;


public class Player implements Interactable {

    static ArrayList<Item> inventory = new ArrayList<>();


    //функция показывающая инвентарь
    public void showInventory() {
        System.out.println("У вас в инвентаре есть: ");
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
                    System.out.println("Вы положили предмет " + item.getTitle() + " в локации " + location.titleLocation);
                }
            }
        }
    }

    }
    //функция для получения предмета из локации
    public void getItem(String titleItem) {
        inventory.add(GameWorld.getItemFromLocation(titleItem));
        System.out.println("У вас есть " + titleItem);
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

    //метод для получения описания локации
//    public void showContext(String comand) {
//      if (comand.equals("осмотреться") || comand.equals("Осмотреться"))   {
//          getDescr();
//      }
//    }
//изменяем на false прошлую локацию, перемещая персонажа на другую локацию
    public void leaveLocation() {
        for (Location location : GameWorld.locations) {
            if (location.titleLocation.equals(GameWorld.currentLocationTitle)) {
                location.playerIsHere = false;
            }
        }
    }
    //метод для изменения локации персонажа
    //изменяет булевый флаг в классе GameWorld
    public void changeLocation(String coord) {

//  часть отвечающая за передвижение из гостиной
        switch (GameWorld.currentLocationTitle) {
            case "гостиная" -> {
                switch (coord) {
                    case "идти наверх", "подняться по лестнице":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("чердак");
                        getDescr();
                        break;

                    case "идти налево", "идти на запад":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("сад");
                        getDescr();
                        break;

                    default:
                        System.out.println("Сейчас туда нельзя пойти");
                        break;
                }
            }
//  часть отвечающая за передвижение на чердаке
            case "чердак" -> {
                if (coord.equals("идти вниз")) {
                    leaveLocation();
                    GameWorld.changeCurrentLocation("гостиная");
                    getDescr();
                } else {
                    System.out.println("Сейчас туда нельзя пойти");
                    getDescr();
                }
            }
//  часть отвечающая за передвижение в саду
            case "сад" -> {
                switch (coord) {
                    case "идти на восток", "идти направо":
                        leaveLocation();
                        GameWorld.changeCurrentLocation("гостиная");
                        getDescr();
                        break;

                    default:
                        System.out.println("Сейчас туда нельзя пойти");
                        break;
                }
            }
        }
    }

    //функция проверки наличия предмета в инвентаре
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
                System.out.println("Вы не написали название второго предмета");
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
            System.out.println("Этого предмета нет в Вашем инвентаре");
        }
    }
}
