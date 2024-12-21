package Quest;

public class Item extends AbstractItem {

    Item(String name) {
        this.title = name;
    }

    public void useSomeObject(String target){};
    public void interactWith(String target){};
}
