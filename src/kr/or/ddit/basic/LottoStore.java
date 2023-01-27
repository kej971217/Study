package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class LottoStore {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		new LottoStore().lottoStart();

	}
	
	// 메서드 시작
	public void lottoStart() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // Lotto 구입
				buyLotto();
				break;
			case 2: // 프로그램 종료
				System.out.println("\n감사합니다.");
				return;

			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
				break;
			}
			
		}
		
	}
	// 로또를 구입하는 메서드 
	private void buyLotto() {
		System.out.println("Lotto 구입시작");
		System.out.println("(1000원에 로또번호 하나입니다.");
		System.out.println("금액 입력: ");
		int money = scanner.nextInt();
		
		if(money<1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		}
		
		if(money>=101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			return;
		}
		
		// 로또 번호 만들기
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		Random rnd = new Random();
		int count = money/1000; // 구매할 로또 갯수
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i = 1; i<count; i++) {
			while (lottoSet.size() < 6) {
				lottoSet.add(rnd.nextInt(45) + 1 ); // 1~45 사이의 난수 만들기
			}
			ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			Collections.sort(lottoList);
			System.out.println("로또번호"+ i + " : " + lottoList);
			lottoSet.clear(); // 이전 자료 모두 삭제
		}
		System.out.println();
		System.out.println("받은 금액은 " + money + "원 이고 거스름돈은 " + (money%1000) + "원 입니다.");
		System.out.println();
	}
	
	private int displayMenu() {
		System.out.println("=========================");
		System.out.println("     	Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================");
		System.out.print("메뉴선택 : ");
		return scanner.nextInt();

		
	}

}
