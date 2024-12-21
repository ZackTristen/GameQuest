package Quest;


public class Bucket extends Item{

    static Boolean isContainWater = false;
    static Boolean  isRepair = false;
    static Boolean hasFrog = false;
    Bucket() {
        super("�����");
    }


    public void useSomeObject(String target) {

    switch (target) {
        case "����":
        if (GameWorld.currentLocationTitle.equals("������") && !isRepair ) {
            isRepair = true;
            //������� ������� �� ���������
            Player.inventory.removeIf(item -> item.getTitle().equals(target));
            System.out.println("������ ���� ������� ��������� � �����.");
        }
        break;
        case "�������":
            if (!isContainWater) {
                hasFrog = !hasFrog;
                //������� ������� �� ���������
                Player.inventory.removeIf(item -> item.getTitle().equals(target));
                System.out.println("�� �������� ������� � �����");
            }
            break;
        case "������� �����":
            for (Item item: Player.inventory) {
                if (item.getTitle().equals(target)) {
                    item.useSomeObject("����� ����� ����� ����� �����  ����� ����� ����� �����");
                }
            }
            break;
        default:
            System.out.println("����� ������ ������������ �� ����");
            break;
    }
    }

    public void interactWith(String target) {
        switch (target) {
            case "�������":
                if (GameWorld.currentLocationTitle.equals("���")) {
                    if (!isContainWater && isRepair) {
                        isContainWater = true;
                        System.out.println("����� ����� �� ����, �� ��������� ��� � ������� � ���������� ������ �� �����.");
                    }
                    else if (!isRepair) {
                        System.out.println("���� ������� ������. �� �������.");
                    }
                    else if (hasFrog && isRepair) {
                        System.out.println("�� ��������� ������� � �������! ������ ��� ����");
                    }
                }
                break;
            case "���������":
                if (GameWorld.currentLocationTitle.equals("��������")) {
                    if (isContainWater) {
                        System.out.println("��������� ���������� � �������� ������������. ������� ���� � �������, �� ���������� ��� �� ������ � " +
                                "����������� ��� ���������� ��������. �� ��������! �����.");
                        GameWorld.GameState = !GameWorld.GameState;
                    } else if (!isContainWater) {
                        System.out.println("� ����� �����.");
                    }
                }
                break;
            default:
                System.out.println("����� ������ ������������ �� ����");
                break;
        }
    }

}
