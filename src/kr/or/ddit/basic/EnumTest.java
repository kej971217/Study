package kr.or.ddit.basic;

/*
 	enum(열거형) => 서로 관련 있는 상수들의 집합
 			   => 클래스처럼 보이게 하는 상수
 	 - 만드는 위치 => 열거형은 클래스 처럼 독립된 java 파일에 만들 수 있고,
 		    	    하나의 java 파일에 클래스와 같이 만들 수 있고,
 		    	    클래스 안에 내부 클래스처럼 만들 수 있음
 		    	    
 	 - 열거형의 속성 및 메서드
 	  . name() => 열거형 상수의 이름을 문자열로 반환
 	  . ordinal() => 열거형 상수가 정의된 순서값(index값)을 반환 (0부터 시작)
 	  . valueOf("열거형상수이름") => 지정된 열거형에서 '열거형상수이름'과 일치하는 열거형 상수를 반환
 	  . 열거형이름.상수이름 => valueOf()메서드와 같다.
 	  . 열거형이름.values() => 모든 열거형 상수를 배열로 가져올 수 있음
 	  
 	 - 열거형 선언하기
 	  방법 1) 
		enum 열거형이름{ 상수이름1, 상수이름2, 상수이름3, ...}
	  방법 2)
		enum 열거형이름{
			상수이름1(갑들...),
			상수이름2(값들...),
			...
			상수이름n(값들...);
			
			// '값들'이 저장될 변수들 선언
			private 자료형이름 변수명1;
			...
			
			// 열거형의 생성자를 만듦
			// 열거형의 생성자는 '열거형 상수'에 설정될 '값들'을 변수에 셋팅하는 역할을 수행
			// 열거형의 생성자는 묵시적으로 'private'
			 
			// '변수명'의 개수는 '값들'과 같고 자료형도 맞아야 함
			private 열거형이름(자료형이름 변수명, ...){
				위에 선언된 변수들을 초기화한다.
				...
			}	
			// 위에서 구성된 '값들'을 외부에서 불러올 수 있는 getter 메서드를 작성한다.
		}
	 
 */
public class EnumTest {
	
	public enum Color {RED, GREEN, BLUE}
	public enum Count {ONE, TWO, THREE}
		
	public enum Season {
		// 상수이름(값들..)형식의 선언
		봄("3월부터 5월까지", 12),
		여름("6월부터 8월까지", 32),
		가을("9월부터 11월까지", 23),
		겨울("12월부터 2월까지", -11);
		
		// '값들'이 저장될 변수들 선언
		private String span;
		private int temp;
		
		// 생성자
		Season(String span, int temp){ // => private Season(String span, int temp){ 와 같다.
			// 변수들 초기화 작업
			this.span = span;
			this.temp = temp;
	}
		public String getSpan() {
			return span;
		}
		
		public int getTemp() {
			return temp;
		}
	}
	public static void main(String[] args) {
		
//		System.out.println("RED : " + ConstTest.RED);
//		System.out.println("Three : " + ConstTest.THREE);
//		
//		if(ConstTest.RED == ConstTest.TWO) {
//			System.out.println("....");
//		}else {
//			System.out.println("####");
//		}
		
		Color mycol = Color.valueOf("GREEN"); // Color.GREEN 과 같음
		Count mycnt = Count.ONE;			  // Count.valueOf("ONE")과 같음
		
		System.out.println("mycol : " + mycol);
		System.out.println("mycnt : " + mycnt);
		System.out.println();
		
		System.out.println("mycol ordinal : " + mycol.ordinal());
		System.out.println("mycnt ordinal : " + mycnt.ordinal());
		
		// 서로 다른 종류의 열거형 끼리의 비교는 불가능
//		if(Color.RED == Count.TWO) {
//			System.out.println("....");
//		}
		
		if(mycol == Color.GREEN) {
			System.out.println("같다...");
		}else {
			System.out.println("다르다...");
		}
		System.out.println();
		
		for(Color col : Color.values()) {
			System.out.println(col.name());
			System.out.println(col);
		}
		
		// 열거형을 switch문에서 사용 가능
		// switch문의 case문에 사용할 때는 '열거형이름'은 생략하고 '상수이름'만으로 작성
		switch (mycnt) {
		case ONE : System.out.println("하나"); break;
		case TWO : System.out.println("둘"); break;
		case THREE : System.out.println("셋"); break;
		default:
			break;
		}
		System.out.println("-----------------------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println("temp : " + ss.getTemp());
		System.out.println();
		
		for(Season s : Season.values()) {
			System.out.println(s.name() + "==" + s + "--> 평균온도" + s.getTemp());
		}
	}

}

