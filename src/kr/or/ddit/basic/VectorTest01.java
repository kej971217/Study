package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("처음 크기 : "+ v1.size());
		
		// 데이터 추가 : add(추가할 데이터)
		// 변환값 : 성공(true), 실패(false)
		v1.add("AAAA");
		v1.add(new Integer(111)); // 예전 방식; 숫자 데이터를 입력시 객체화 / Integer같은 기본 데이터를 객체화 시켜주는 클래스를 wrapper 클래스라 함.
		v1.add(123); // 오토박싱
		v1.add('a'); // ''=> character Type
		v1.add(true);
		boolean r = v1.add(3.14);
		
		System.out.println("현재 크기: " + v1.size()); // => 6
		System.out.println("반환 값: " + r);
		
		// 데이터 추가 2 : addElement(추가할 데이터)
		// 이전 버전의 프로그램도 사용할 수 있도록 하기 위해 남아있는 메서드
		v1.addElement("CCCC");
		System.out.println("v1=> "+v1.toString());
		System.out.println("v1=> "+v1); // 출력할 때만 생략 가능
		
		// 데이터 추가 3 : add(index, 데이터)
		// => 'index'번째에 '데이터'를 끼워 넣는다
		// => 반환값이 없다.
		 v1.add(1,"KKKK");
		 System.out.println("v1 => " +v1);
		
		// 데이터 꺼내오기 : get(index)
		// ==> 'index'번째 데이터를 반환한다. (index는 0부터 시작한다.)
		
		int data = (int)v1.get(1); // 변수에 들어갈 때는 형변환 필요
		System.out.println("꺼내온 데이터 : "+data); // 형변환 필요 없음
		System.out.println("꺼내온 데이터2 : "+v1.get(3));
		System.out.println();
		
		// 데이터 수정 : set(index, 새로운 값);
		// 배열변수[index] = 새로운 값
		// 반환값 : 변경되기 전의 데이터
		String temp = (String)v1.set(0, "ZZZZ");
		System.out.println("변경 후 v1 => " + v1);
		System.out.println("변경 전의 데이터 : " + temp);
		
		// 데이터 삭제 : remove(index)
		// => 'index'번째 데이터를 삭제한다.
		// => 반환 값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1 => "+ v1);
		
		temp = (String)v1.remove(0);
		System.out.println("삭제 후 v1 => " + v1);
		System.out.println("삭제된 데이터: " + temp);
		System.out.println();
		
		// 데이터 삭제 : remove(삭제할 데이터)
		// => '삭제할 데이터'를 찾아서 삭제한다.
		// => '삭제할 데이터'가 여러개 이면 앞에서 부터 삭제를 한다.
		// => 반환 값 : 삭제성공(true),삭제실패(false)
		// => '삭제할 데이터'가 '정수형'이거나 'char형'일 경우에는 반드시 객체로 반환해서 사용해야 한다.
		v1.remove("CCCC");
		System.out.println("삭제 후 v1 => " + v1);
		v1.remove(123); 
		System.out.println("삭제 후 v1 => " + v1);// => 오류; 인덱스로 인식해서 오류가 남
		v1.remove(new Integer(123)); // ㄴ객체로 형변환 하여 삭제 
		System.out.println("삭제 후 v1 => " + v1);
		v1.add('a');
		System.out.println("삭제 후 v1 =>" + v1);// => 오류; a의 숫자형식으로 나와서 인덱스로 인식해서 오류가 남
		v1.remove(new Character('a'));
		System.out.println("삭제 후 v1 =>" + v1);
		v1.remove(3.14); // 정수가 아니기 때문에 자동으로 언박싱이 됨
		System.out.println("삭제 후 v1 =>" + v1);
		v1.remove(true);
		System.out.println("삭제 후 v1 =>" + v1); // 잘 삭제 됨..
		System.out.println("--------------------------------------------");
		/*
		 - 제네릭타입(Generic Type) => 클래스 내부에서 사용할 데이터의 타입을 외부에서 지정하는 기법으로 
		 							객체를 선언할 때 괄호(< >) 안에 객체의 내부에서  사용할 데이터의 타입을 정해주는 것을  말한다.
		 							이런식으로 선언하게 되면 지정한 데이터 타입 이외의 다른 데이터를 저장할 수 없다.
		 							제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		 							그래서 int는 Integer, boolean은 Boolean, char은 Character 등으로 대체해서 사용해야 한다.
		 							
		 							제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요 없다.
		 */
		Vector<String> v2 = new Vector<String>(); // String만 저장 할 수 있음
		Vector<Integer> v3 = new Vector<Integer>();
		
		v2.add("안녕하세요");
		// v2.add(123); => 오류; 제네릭타입과 다른 종류의 데이터를 추가할 수 없다.
		
		String temp2 = v2.get(0); // 제네릭 타입이 String이기 때문에 별도의 형변환이 없이 자료를 꺼내올 수 있다.
		
		Vector<Vector> vv = new Vector<Vector>(); // 2차원 베열의 느낌
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		System.out.println("--------------------------------------------");
		
		v2.clear(); // 전체 데이터 삭제하기
		System.out.println("v2의 size : " + v2.size());
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v2 => " + v2);
		System.out.println("v4 => " + v4);
		
		// 데이터 삭제 : removeAll(Collection객체)
		// => 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		// => 반환 값: 삭제성공(true), 삭제실패(false)
		v2.removeAll(v4);
		System.out.println("삭제 후 v2 => " + v2);
		
		// 벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.
		// (보통 for문을  사용한다.)
		v2.clear();
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		for(int i = 0; i<v2.size(); i++) {
			System.out.println(i+"번째 자료: " + v2.get(i));
		}
		System.out.println("--------------------------------------------");
		
		// 향상된 for문
		for(String s : v2) {
			System.out.println(s);
		}
		
				
	}

}
