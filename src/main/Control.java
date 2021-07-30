package main;
import java.util.Scanner;

public class Control {
	public boolean Move(int direction, Player p) {
		boolean isMove = false;
		if (direction == 1) {
			isMove = true;
		} else if (direction == 2) {
			if (p.redKey == true) {
//				p.posY--;
				isMove = true;
			} else {
				System.out.println("red key�� �ʿ��մϴ�.");
			}
		} else if (direction == 3) {
			if (p.blueKey == true) {
//				p.posY--;
				isMove = true;
			} else {
				System.out.println("blue key�� �ʿ��մϴ�.");
			}
		} else {
			System.out.println("�� �� �����ϴ�.");
		}
		return isMove;
	}

	public void start() {

		String input = "";
		Scanner scan = new Scanner(System.in);
		Player p = new Player();

		Room room = new Room();
		Room[][] map = new Room[5][4];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = new Room();
			}
		}

		map[0][0].isRight = 1;
		map[1][0].isLeft = 1;
		map[1][0].isRight = 1;
		map[2][0].isDown = 1;
		map[2][0].isRight = 1;
		map[2][0].isLeft = 1;
		map[3][0].isRight = 1;
		map[3][0].isLeft = 1;
		map[4][0].isLeft = 1;
		map[2][1].isUp = 1;
		map[2][1].isDown = 1;
		map[2][2].isUp = 1;
		map[2][2].isDown = 1;
		map[2][2].isRight = 1;
		map[3][2].isLeft = 1;
		map[0][3].isUp = 2;
		map[0][3].isRight = 1;
		map[0][2].isDown = 1;
		map[1][3].isLeft = 1;
		map[1][3].isRight = 1;
		map[2][3].isUp = 1;
		map[2][3].isLeft = 1;
		map[2][3].isRight = 1;
		map[3][3].isRight = 1;
		map[3][3].isLeft = 1;
		map[4][3].isUp = 3;
		map[4][3].isLeft = 1;


		map[4][0].event = 1;
		map[0][2].event = 2;
		map[4][2].event = -1;

		while (true) {
			System.out.println("�Է��ϼ���");
			System.out.println("���� ��ġ - x:" + p.posX + ", y:" + p.posY);
			System.out.println("1.�� 2.�Ʒ� 3.���� 4.������");
			System.out.println("-------------------------");
			input = scan.nextLine();
			if (input.equals("1")) {
				if (Move(map[p.posX][p.posY].isUp, p)) {
					p.posY--;
				}
			} else if (input.equals("2")) {
				if (Move(map[p.posX][p.posY].isDown, p)) {
					p.posY++;
				}
			} else if (input.equals("3")) {
				if (Move(map[p.posX][p.posY].isLeft, p)) {
					p.posX--;
				}
			} else if (input.equals("4")) {
				if (Move(map[p.posX][p.posY].isRight, p)) {
					p.posX++;
				}
			}
			// �̵� �� �̺�Ʈ üũ
//			if (map[p.posX][p.posY].quiz == true) {
//				System.out.println("A �����Դϴ�.");
//				System.out.println("���� : �迭�� ����� �ϸ� ?");
//				System.out.println("1.object 2.array 3.integer 4.class");
//				input = scan.nextLine();
//				if (input.equals("2")) {
//					System.out.println("�����Դϴ�. red key ȹ��");
//					redKey = true;
//				}else {
//					System.out.println("Ʋ�Ƚ��ϴ�.");
//					p.posX--;
//				}
//			}else if (map[p.posX][p.posY].getBluekey == true) {
//				blueKey = true;
//				System.out.println("blue key ȹ��");
//			}else if (map[p.posX][p.posY].complete == true) {
//				System.out.println("F �����Դϴ�. �ӹ� �Ϸ�");
//			}
			if (map[p.posX][p.posY].event == 1) {
				System.out.println("A �����Դϴ�.");
				System.out.println("���� : �迭�� ����� �ϸ� ?");
				System.out.println("1.object 2.array 3.integer 4.class");
				input = scan.nextLine();
				if (input.equals("2")) {
					System.out.println("�����Դϴ�. red key ȹ��");
					p.redKey = true;
				} else {
					System.out.println("Ʋ�Ƚ��ϴ�.");
					p.posX--;
				}
			}
			if (map[p.posX][p.posY].event == 2) {
				p.blueKey = true;
				System.out.println("blue key ȹ��");
			}
			if (map[p.posX][p.posY].event == -1) {
				System.out.println("F �����Դϴ�. �ӹ� �Ϸ�");
				break;
			}
		}

	}

}
