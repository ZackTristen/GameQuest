package Quest;

public class Chain extends Item{
    Chain() {
        super("צוןü");
    }

    @Override
    public void useSomeObject(String target) {
        switch (target) {
            case "גוהנמ" -> {
                for (Item item: Player.inventory) {
                    if (item.getTitle().equals("גוהנמ")) {

                        item.useSomeObject("צוןü");
                    }
                }
            }
        }
    }

    @Override
    public void interactWith(String target) {

    }
}
