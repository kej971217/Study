package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/*
	문제) Set을 이요한 숫자 야구 게임 프로그램을 작성하시오.
		 컴퓨터의 숫자는 난수를 이용하여 구한다. (1 ~ 9 사이의 중복되지 않는 숫자 3개)
		 (스트라이크는 S, 볼은 B로 나타낸다.)
		 
	예시) 컴퓨터의 난수 ==> 9 5 7
	
	실행예시 ) 
		 숫자 입력 : 3 5 6
		 3 5 6 ==> 1S 0B
		 숫자 입력 : 7 8 9
		 7 8 9 ==> 0S 2B
		 숫자 입력 ==> 9 7 5
		 9 7 5 ==> 1S 2B
		 숫자 입력 ==> 9 5 7
		 9 5 7 ==> 3S 0B
		 
		 축하합니다. 당신은 4번만에 맞췄습니다.
*/


public class BaseBallTest {

	ArrayList<Integer> numList; 	// 난수가 저장될 List
	ArrayList<Integer> userList;	// 사용자가 입력한 값이 저장될 List
	
	int strike;		// 스트라이크 갯수
	int ball;		// 볼의 갯수
	
	Scanner sc = new Scanner(System.in);
	
	// 시작하는 메서드
	public void gameStart() {
		// 난수 만드는 메서드 호출
		createNum();
		
		// 확인용
//		System.out.println("난수  : " + numList);
		
		int cnt = 0; 	// 몇번만에 맞췄는지를 저장하는 변수
		do {
			cnt++;
			// 입력용 메서드 호출
			inputNum();
			
			// 볼 카운트 메서드 호출
			ballCount();
			
		}while(strike != 3);
		
		System.out.println();
		System.out.println("축하합니다 ! ");
		System.out.println("당신은 " + cnt + "번째 만에 맞췄습니다 ! ");
		
	}
	
	// 난수 만드는 메서드 (1 ~ 9 사이의 서로 다른 난수 3개 만들기)
	// 만들어진 난수를 List에 저장
	public void createNum() {
		Set<Integer> numSet = new HashSet<Integer>();	// Set 객체 생성
		
		Random rnd = new Random();
		// 1 ~ 9 사이의 난수 3개 만들기
		while(numSet.size() < 3) {
			numSet.add(rnd.nextInt(9) + 1);
		}
		// 만들어진 난수를 List에 저장
		numList = new ArrayList<Integer>(numSet);
		
		// List의 데이터 섞기
		Collections.shuffle(numList);
	}

	// 사용자로부터 3개의 정수를 입력받아 List에 저장하는 메서드
	// 입력한 값은 중복되지 않게 한다.
	public void inputNum() {
		int num1, num2, num3;	// 입력한 정수가 저장될 변수 선언
		
		do {
			System.out.println("숫자 입력 : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			num3 = sc.nextInt();
			
			if(num1==num2 || num1==num3 || num2==num3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력");
			}
		}while(num1==num2 || num1==num3 || num2==num3);
		
		// 입력 받은 데이터를 List에 추가
		userList = new ArrayList<Integer>();
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
	}

	// 스트라이크와 볼을 판정하고 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball = 0; // 스트라이크와 볼의 갯수 초기화
		
		for(int i = 0; i<numList.size(); i++) {
			for(int j = 0; j<userList.size(); j++) {
				if(numList.get(i) == userList.get(j)) { // 값이 같은 지 비교
					if(i==j) { 		// 위치가 같은지 검사
						strike++;
					}else {
						ball++;
					}
				}
			} // for -- j
		} // for -- i
		
		// 볼 카운트 결과 출력하기
		System.out.println(userList.get(0) + ", " + userList.get(1) + ", " +
					userList.get(2) + " ==> " + strike + "S " + ball + "B");
	}
	
	
	public static void main(String[] args) {
//		BaseBallTest b = new BaseBallTest();
//		b.gameStart();
		new BaseBallTest().gameStart(); // 위 두줄 한줄로
		
	}

}
