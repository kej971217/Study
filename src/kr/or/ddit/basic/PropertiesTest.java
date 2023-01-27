package kr.or.ddit.basic;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		/*
		 	Properties; Map 보다 기능이 축소된 객체
		 	
		 		   Map - key와 value 값에 모든 종류의 객체 사용 가능
						 put(), get() 메서드를 이용하여 데이터 입출력 
						 
		 	Properties - key와 value 값에 String만 사용 가능
		 				 setProperty(), getProperty() 메서드를 이용하여 데이터 입출력 
		  				 * 데이터 파일로 입출력 가능
		 	
		 */
		Properties prop =new Properties();
		
		// 데이터 저장하기
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "20");
		prop.setProperty("age2", String.valueOf(20)); // 숫자를 문자형으로 변경
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "서울");
		
		// 데이터 읽기
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel =prop.getProperty("tel");
		String addr = prop.getProperty("addr");

		
		System.out.println("이름 : "+ name);
		System.out.println("나이 : "+ age);
		System.out.println("전화 : "+ tel);
		System.out.println("주소 : "+ addr);
		
		prop.remove("age2");
		System.out.println("prop => " + prop);
	}

}
