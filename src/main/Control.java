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
				System.out.println("red key가 필요합니다.");
			}
		} else if (direction == 3) {
			if (p.blueKey == true) {
//				p.posY--;
				isMove = true;
			} else {
				System.out.println("blue key가 필요합니다.");
			}
		} else {
			System.out.println("갈 수 없습니다.");
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
			System.out.println("입력하세요");
			System.out.println("현재 위치 - x:" + p.posX + ", y:" + p.posY);
			System.out.println("1.위 2.아래 3.왼쪽 4.오른쪽");
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
			// 이동 후 이벤트 체크
//			if (map[p.posX][p.posY].quiz == true) {
//				System.out.println("A 지점입니다.");
//				System.out.println("문제 : 배열을 영어로 하면 ?");
//				System.out.println("1.object 2.array 3.integer 4.class");
//				input = scan.nextLine();
//				if (input.equals("2")) {
//					System.out.println("정답입니다. red key 획득");
//					redKey = true;
//				}else {
//					System.out.println("틀렸습니다.");
//					p.posX--;
//				}
//			}else if (map[p.posX][p.posY].getBluekey == true) {
//				blueKey = true;
//				System.out.println("blue key 획득");
//			}else if (map[p.posX][p.posY].complete == true) {
//				System.out.println("F 지점입니다. 임무 완료");
//			}
			if (map[p.posX][p.posY].event == 1) {
				System.out.println("A 지점입니다.");
				System.out.println("문제 : 배열을 영어로 하면 ?");
				System.out.println("1.object 2.array 3.integer 4.class");
				input = scan.nextLine();
				if (input.equals("2")) {
					System.out.println("정답입니다. red key 획득");
					p.redKey = true;
				} else {
					System.out.println("틀렸습니다.");
					p.posX--;
				}
			}
			if (map[p.posX][p.posY].event == 2) {
				p.blueKey = true;
				System.out.println("blue key 획득");
			}
			if (map[p.posX][p.posY].event == -1) {
				System.out.println("F 지점입니다. 임무 완료");
				break;
			}
		}

	}

}
