package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중
별명의 길이가 제일 긴 별명을 출력하시오.
(단, 별명의 길이가 중복될 수 있다.)
*/

public class ArrayListTest04 {

	public static void main(String[] args) {
		// 제일 긴 별명의 길이를 저장할 변수를 선언하고 첫번째 별명의 길이로 초기화 한다.
		ArrayList<String> nickName = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> nickNameArray=new ArrayList<String>();
		
		for(int i =0; i<5;i++){
			System.out.print(i+1 + "번째 사람 별명 >> ");
			nickName.add(scanner.nextLine());
		} 
		
		// 선생님 답안
		int maxLength = nickName.get(0).length();
		
		for(int i = 1; i<nickName.size();i++) {
			if(maxLength < nickName.get(i).length()) {
				maxLength = nickName.get(i).length();
			}
		}
		
		System.out.println("제일 긴 별명들 ...");
		for(int i =0; i<nickName.size();i++) {
			if(maxLength == nickName.get(i).length()) {
				System.out.println(nickName.get(i));
				
			}
		}

		// 나
		
		String maxLengthNickName = nickName.get(0);
		for(int i = 0; i<nickName.size();i++) {
			if(nickName.get(i).length()>maxLengthNickName.length()) {
				maxLengthNickName=nickName.get(i);
			}
		}
			for(int i = 0; i <nickName.size();i++) {
			if(nickName.get(i).length()>=maxLengthNickName.length()) {
				nickNameArray.add(nickName.get(i));
			}

	}
			System.out.println(nickNameArray);
	}

}
