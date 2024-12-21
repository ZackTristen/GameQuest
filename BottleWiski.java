package Quest;

public class BottleWiski extends Item  {


    static Boolean isEmpty = false;
    static Boolean isMagic = false;

    BottleWiski() {
        super("������� �����");
    }

    @Override
    public void useSomeObject(String target) {
        switch (target) {
            case "����" -> System.out.println("������������ ������� �� ����? �� ��������?");
            case "�����" -> {
                for (Item item: Player.inventory) {
                    if (item.getTitle().equals(target)) {
                        isEmpty = !isEmpty;
                        System.out.println("�����������!�� ������ ��� ������ �������� ����� ����� � �����!");
                    }
                }
            }
            case "�������"-> {
                if (isEmpty) {
                    System.out.println("���, � ��� ���������� �������� ������� � �������!");
                    for (Item item: Player.inventory) {
                        if (item.getTitle().equals("�������")) {
                            Player.inventory.remove(item);
                        }
                        isMagic = !isMagic;
                    }
                } else {
                    System.out.println("��������� ����! �� ������ �������!");
                }
            }
            default -> {
                System.out.println("� ��������� ������� ������ ������������ �� ����...");
            }
        }
    }

    @Override
    public void interactWith(String target) {

    }
}

