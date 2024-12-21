package Quest;

public class Chain extends Item{
    Chain() {
        super("����");
    }

    @Override
    public void useSomeObject(String target) {
        switch (target) {
            case "�����" -> {
                for (Item item: Player.inventory) {
                    if (item.getTitle().equals("�����")) {

                        item.useSomeObject("����");
                    }
                }
            }
        }
    }

    @Override
    public void interactWith(String target) {

    }
}
