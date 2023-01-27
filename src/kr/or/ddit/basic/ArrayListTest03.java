package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중
	별명의 길이가 제일 긴 별명을 출력하시오.
	(단, 별명의 길이는 모두 다르게 입력한다.)
 */
public class ArrayListTest03 {

	public static void main(String[] args) {

		ArrayList<String> nickName = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		String maxLengthNickName;

		for (int i = 0; i < 5; i++) {
			System.out.print(i + 1 + "번째 사람 별명 >> ");
			nickName.add(scanner.nextLine());
		}
		maxLengthNickName = nickName.get(0);

		for (int i = 0; i < nickName.size(); i++) {
			if (nickName.get(i).length() > maxLengthNickName.length()) {
				maxLengthNickName = nickName.get(i);
			}

		}
		System.out.printf("제일 긴 별명 : " + maxLengthNickName);

	}

}
