package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest01 {
	/*
	  
	 * 정렬과 관련된 interface => [ Comparable / Comparator ]
	  
	 * [Comparable] - Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 interface 
	 				- compareTo()메서드를 재정의
	 
	 * [Comparator] - 외부에 별도로 정렬기준을 구현하고 싶을 때 구현하는 interface 
	 				- compare()메서드를 재정의
	 
	 * String 클래스, Wrapper 클래스, Data 클래스, File 클래스에는 내부 정렬 기준이 구현되어 있음
	  (내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있다.)
	  
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬 전 : " + list);
		System.out.println();

		// 정렬은 Collections.sort() 메서드를 이용하여 정렬함
		// Collections.sort() 메서드는 기본적으로 내부 정렬기준으로 정렬함
		Collections.sort(list);

		System.out.println("기본 정렬 후 : " + list); // 오름차순 ASC
		System.out.println();
		
		Collections.shuffle(list); // 자료 석기
		System.out.println("자료 섞기 후 : " + list);
		System.out.println();
		
		// 외부 정렬 기준을 이용한 정렬
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : " + list);
	}
}

// 외부 정렬 기준을 구성하는 class 작성하기 => 외부 정렬 기준 클래스라고 지칭
// => Comparator 인터페이스를 구현해서 작성
class Desc implements Comparator<String> {

	// 데이터를 두 개씩 비교 => str1(비교군1) str2(비교군2)
	// compare() 메서드를 이용하여 정렬하고자 하는 기준을 정립
	// compare() 메서드의 반환 값의 의미를 지정
	// ㄴ Desc : return [0; 두 값이 같음 / 양수; 앞, 뒤 순서를 바꿈 / 음수; 앞, 뒤 순서 유지]
	// 			reutrn [앞의 값이 크면 양수 / 같으면 0 / 앞의 값이 작으면 음수]

	@Override
	public int compare(String str1, String str2) {

		// 내림차순 구현
//		if (str1.compareTo(str2) > 0) { // 양수면
//			return -1; // 음수를 반환
//		} else if (str1.compareTo(str2) < 0) { // 오름차순이 되어있다면
//			return 1;
//		} else {
//			return 0;
//		}
		
		return str1.compareTo(str2) * -1;
		
	}

}
