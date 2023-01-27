package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.NameList;

public class ArrayListTest02 {

	/*
	 문제) 5명의 사람 이름을 입력 받아 ArrayList에 저장한 후에
	 	이들 중 '김'씨 성을 가진 사람의 이름을 출력하시오.
	 	(단, 입력은 Scanner객체를 이용한다.)
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> name = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		for(int i =0; i<5;i++){
			System.out.print(i+1 + "번째 사람 이름 >> ");
			name.add(scanner.nextLine());
		} 
			for(int i =0; i<name.size();i++){ // 틀린 답; 성이 아닌 이름에도 김이 있으면 출력됨
		if(name.get(i).contains("김")) {
			System.out.println(name.get(i));
			
			}
		}
			
			for(int i =0; i<name.size(); i++) {
//				if(name.get(i).indexOf("김") == 0 ) { // 성씨가 김씨인 사람 이라 인덱스 번호로 확인.. 
//					System.out.println(name.get(i));
//				}
				
//				if(name.get(i).substring(0, 1).equals("김")) {
//					System.out.println(name.get(i));
//				}
				
//				if(name.get(1).charAt(0)=='김') {
//					System.out.println(name.get(i));
//				}
				
				if(name.get(i).startsWith("김")) {
					System.out.println(name.get(i));
				}
			}
			


	}


} 


