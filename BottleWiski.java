package Quest;

public class BottleWiski extends Item  {


    static Boolean isEmpty = false;
    static Boolean isMagic = false;

    BottleWiski() {
        super("бутылка виски");
    }

    @Override
    public void useSomeObject(String target) {
        switch (target) {
            case "цепь" -> System.out.println("Использовать бутылку на цепь? Вы серьезно?");
            case "ведро" -> {
                for (Item item: Player.inventory) {
                    if (item.getTitle().equals(target)) {
                        isEmpty = !isEmpty;
                        System.out.println("Поздравляем!Вы только что вылили отличный виски прямо в ведро!");
                    }
                }
            }
            case "лягушка"-> {
                if (isEmpty) {
                    System.out.println("Ого, у Вас получилось засунуть лягушку в бутылку!");
                    for (Item item: Player.inventory) {
                        if (item.getTitle().equals("лягушка")) {
                            Player.inventory.remove(item);
                        }
                        isMagic = !isMagic;
                    }
                } else {
                    System.out.println("Побойтесь Бога! Не топите лягушку!");
                }
            }
            default -> {
                System.out.println("К сожалению бутылку нельзя использовать на этом...");
            }
        }
    }

    @Override
    public void interactWith(String target) {

    }
}

