package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	static Scanner scanner = new Scanner(System.in);
	static Random rnd = new Random();

	static HashSet<Integer> numList = new HashSet<Integer>();
	public static int pay;
	static int ea;
	static int charge;
	private int input;
	
	public static void main(String[] args) {
		new Lotto().Start();

	}

	public void Start() {

		do {
			System.out.println("==========================");
			System.out.println("	Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 : ");
			input = scanner.nextInt();
			if (input == 1) {
				System.out.println("Lotto 구입 시작");
				System.out.println();
				System.out.println("(1000원에 로또번호 하나입니다.");
				System.out.print("금액입력 : ");

				pay = scanner.nextInt();
				ea = pay / 1000;
				charge = pay % 1000;

				if (ea < 1) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
				} else if (ea > 100) {
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
				} else {
					System.out.println();
					RandomNum();
				}
			}
		} while (input != 2);

		System.out.println("감사합니다.");

	}

	public void RandomNum() {
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");

		for (int i = 1; i <= ea; i++) {
			numList.clear();
			while (numList.size() < 6) {
				numList.add(rnd.nextInt(45) + 1);
			}
			System.out.printf("로또번호 %d : ", i);
			System.out.println(numList);
		}
		System.out.printf("받은 금액은 %d원이고 거스름돈은 %d원입니다.", pay, charge);
		System.out.println();

	}
}