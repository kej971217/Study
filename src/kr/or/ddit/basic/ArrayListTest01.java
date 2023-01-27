package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ArrayList는 기본적으로 사용법이 Vector와 같다.
		
		ArrayList list1 = new ArrayList();
		
		// add()메서드를 이용해서 추가한다.
		list1.add("AAA");
		list1.add("AAA");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		
		System.out.println("list1 => " + list1);
		System.out.println("size => " + list1.size());
		
		// get()메서드로 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));
		
		// 데이터 끼워넣기도 같다.
		list1.add(3,"ZZZ");
		System.out.println("list1 => " + list1);
		
		// 데이터 변경하기
		String temp = (String)list1.set(3, "YYY");
		System.out.println("list1 => " +list1);
		System.out.println("temp => "+temp);
		
		// 삭제도 같다.
		list1.remove(3);
		System.out.println("list1 => " + list1);
		
		list1.remove("BBB");
		System.out.println("list1 => "+ list1);
		
		// 제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("aaaaa");
		list2.add("bbbbb");
		list2.add("ccccc");
		list2.add("ddddd");
		list2.add("eeeee");
		list2.add("ccccc");
		list2.add("fffff");
		
		for(int i = 0; i<list2.size(); i++) {
			System.out.println(i + " => " + list2.get(1));
		}
		System.out.println("--------------------------------------------");
		
		for(String s : list2) {
			System.out.println(s);
		}
		System.out.println("--------------------------------------------");
		
		// contains(비교데이터)
		// => List에 '비교데이터'가 있으면 true, 없으면 false를 반환한다.
		System.out.println("zzzzz값 : " + list2.contains("zzzzz"));
		System.out.println("ccccc값 : " + list2.contains("ccccc"));
		System.out.println("--------------------------------------------");
		
		// indexOf(비교데이터)
		// lastIndex(비교데이터)
		// => List에 '비교데이터'가 있으면 '비교데이터'가 있는 index값을 반환한고, 없으면 -1을 반환한다.
		// => indexOf()는 앞에서 부터 검색하고 lastIndexOf()는 뒤에서부터 검색한다.
		System.out.println("ccccc의 위치 값 : " + list2.indexOf("ccccc")); // 0, 1, 2
		System.out.println("ccccc의 위치 값 : " + list2.lastIndexOf("ccccc"));
		System.out.println("--------------------------------------------");
		
		// toArray() => List 안의 데이터를 배열로 변환해서 반환한다.
		//			 => 기본적으로 Object형 배열로 변환한다.
		// toArray(new 제네릭타입[0]) => 제네릭 타입의 배열로 반환한다.
		
		Object[] strArr = list2.toArray(); // Object 타입의 배열
		// String[] strArr2 = (String[]) list2.toArray(); 오류 ; 이러한 형변환은 사용할 수 없음
		System.out.println("배열의 개수 : " + strArr.length);
		for(int i = 0; i<strArr.length; i++) {
			System.out.println(i+"번째 자료 : " + strArr[i]);
		}
		System.out.println("--------------------------------------------");
		
		String[] strArr2 = list2.toArray(new String[0]); // String 타입의 배열
		for(String str : strArr2) {
			System.out.println(str);
		}
	}

}
