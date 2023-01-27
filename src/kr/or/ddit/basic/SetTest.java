package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

public class SetTest {

	public static void main(String[] args) {
		/*
		 	* List와 Set의 차이점
		 		
		 	1. List
		 		- 데이터에 순서(int)가 있다.
		 		- 중복되는 데이터를 저장할 수 있다.
		 	1. Set
		 		- 데이터의 순서(index)가 없다.
		 		- 중복되는 데이터를 저장할 수 없다.		 		
		 */
		HashSet hs1 = new HashSet();
		
		// 데이터 추가 => add()메서드를 사용
		// 반환 값 : 추가 성공(true), 추가 실패(false)
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);

		System.out.println("set의 개수 : " + hs1.size() + "개");
		System.out.println("set 데이터 : " + hs1);
		System.out.println();
		
		// set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		System.out.println("set 데이터 : " + hs1);
		System.out.println();
		
		isAdd = hs1.add("FF");
		System.out.println("중복될 때 : " + isAdd);
		System.out.println("set 데이터 : " + hs1);
		System.out.println();
		
		// set의 데이터를 수정하려면 수정하는 메서드가 따로 없기 때문에
		// 해당 자료를 삭제한 후 추가해 주어야 한다.
		
		// 자료 삭제 => remove(삭제할 자료)  / clear(); 자료 전체 삭제 
		// 반환 값 : 삭제 성공(true), 삭제 실패(false)
		
		// "FF"데이터를 "EE"로 변경하기
		hs1.remove("FF");
		System.out.println("삭제 후 hs1 => " + hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("set 데이터 : " + hs1);
		System.out.println();
		
//		hs1.clear();
//		System.out.println("set 데이터 : " + hs1);

		/*
		 set 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러올 수 없다.
		 그래서 데이터를 하났기 얻기 위해서는 Iterator 형의 객체로 변환해야 한다.
		 <Iterator; 데이터를 순서대로 처리해주는 객체 >
		 
		 - set 데이터들을 Iterator 형의 객체로 변환하는 메서드 => set객체 변후. iterator()
		 */
		Iterator it = hs1.iterator();
		
		// Iterator 객체의 hasNext()메서드 
		// => Iterator의 데이터를 가리키는 포인터가 현재 가리키고 있는 위치의 다음번째에 데이터가 있는지 검사하는 메서드이다.
		//	  (현재의 다음번째 위치에 데이터가 있으면 true 없으면 false 반환)
		while(it.hasNext()) { // *가리키고*
			// Iterator객체의 next()메서드
			// => Iterator의 포인터를 다음번째 위치로 이동시키고, 이동한 곳의 데이터를 반환
			// Object obj = it.next(); System.out.println(obj); 아래와 같이 축약 가능
			System.out.println(it.next()); // *꺼내가고*
		}
		System.out.println("-------------------------------------------");
		
		// set 데이터를 처리할 때는 향상된 for문을 사용할 수 있음 
		System.out.println("향상된 for문 이용하기...");
		for(Object obj : hs1) {
			System.out.println(obj);
		}
		System.out.println("-------------------------------------------");
		
		// ex) 우리 반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자
		//		당첨번호를 출력하시오.
		//		(번호는 1 ~ 25번 까지 있고, 추첨할 인원은 세 명이다.)
		
		// 난수 생성 공식
		// 난수 범위 : 최솟값 ~ 최댓값
		// 			rnd.nextInt(최댓값 - 최솟값 + 1) + 최솟값;
		Random rnd = new Random();
		HashSet<Integer> testSet = new HashSet<Integer>();
		while(testSet.size()<3) { // 3개가 되면 사이즈가 3보자 작은 것이 거짓이 되어 false / set이기 때문에 중복된 데이터는 추가가 안됨 
			testSet.add(rnd.nextInt(25) + 1);
		}
		System.out.println("당첨 번호 : " + testSet);
		System.out.println();
		
		// set유형의 자료를 List형으로 변환
		
		ArrayList<Integer> testList = new ArrayList<Integer>(testSet); // set 데이터 List로 변환
		System.out.println("List 데이터 출력 ... ");
		for(int i=0; i<testList.size();i++) {
			System.out.println(testList.get(i));
		}
		
		
		
		
		
	}

}
