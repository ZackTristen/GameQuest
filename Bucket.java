package Quest;


public class Bucket extends Item{

    static Boolean isContainWater = false;
    static Boolean  isRepair = false;
    static Boolean hasFrog = false;
    Bucket() {
        super("ведро");
    }


    public void useSomeObject(String target) {

    switch (target) {
        case "цепь":
        if (GameWorld.currentLocationTitle.equals("чердак") && !isRepair ) {
            isRepair = true;
            //удаляем предмет из инвентаря
            Player.inventory.removeIf(item -> item.getTitle().equals(target));
            System.out.println("Теперь цепь надежно приварена к ведру.");
        }
        break;
        case "лягушка":
            if (!isContainWater) {
                hasFrog = !hasFrog;
                //удаляем предмет из инвентаря
                Player.inventory.removeIf(item -> item.getTitle().equals(target));
                System.out.println("Вы положили лягушку в ведро");
            }
            break;
        case "бутылка виски":
            for (Item item: Player.inventory) {
                if (item.getTitle().equals(target)) {
                    item.useSomeObject("ведро ПОШЕЛ НАХУЙ ПОШЕЛ НАХУЙ  ПОШЕЛ НАХУЙ ПОШЕЛ НАХУЙ");
                }
            }
            break;
        default:
            System.out.println("Ведро нельзя использовать на этом");
            break;
    }
    }

    public void interactWith(String target) {
        switch (target) {
            case "колодец":
                if (GameWorld.currentLocationTitle.equals("сад")) {
                    if (!isContainWater && isRepair) {
                        isContainWater = true;
                        System.out.println("Держа ведро за цепь, вы опускаете его в колодец и поднимаете полным до краев.");
                    }
                    else if (!isRepair) {
                        System.out.println("Вода слишком далеко. Не достать.");
                    }
                    else if (hasFrog && isRepair) {
                        System.out.println("Вы отпустили лягушку в колодец! Взамен она дала");
                    }
                }
                break;
            case "волшебник":
                if (GameWorld.currentLocationTitle.equals("гостиная")) {
                    if (isContainWater) {
                        System.out.println("Волшебник вскакивает и начинает отряхиваться. Приведя себя в порядок, он благодарит вас за помощь и " +
                                "протягивает вам магический кристалл. Вы выиграли! Конец.");
                        GameWorld.GameState = !GameWorld.GameState;
                    } else if (!isContainWater) {
                        System.out.println("В ведре пусто.");
                    }
                }
                break;
            default:
                System.out.println("Ведро нельзя использовать на этом");
                break;
        }
    }

}
