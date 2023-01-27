package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	/*
	 	Map => key 값과 value값을 한 쌍으로 관리하는 객체
	 		- key 값 : 중복을 하용하지 않고, 순서가 없음 (Set의 특징을 갖는다.)
	 		- value 값 : 중복 허용
	 */

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 => put(key 값, value 값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		// 자료 수정 => 데이터를 추가할 때 key 값이 같으면 나중에 추가한 값이 저장됨
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 자료 삭제 => remove(key 값) : key 값이 같은 자료를 삭제
		// 반환 값 : 삭제된 데이터의 value값
//		String removeData = map.remove("tel");
//		System.out.println("map => " + map);
//		System.out.println("삭제된 값 " + removeData);
		
		// 자료 읽기 => get(key값) : 해당 key 값과 짝이 되는 value값을 반환
		//						: key 값이 없으면 null 반환
		System.out.println("이름 : " + map.get("name"));
		System.out.println("성별 : " + map.get("gender"));
		System.out.println();
		
		// key 값이 존재하는지 여부를 나타대는 메서드 => containsKey(key값)
		// => 해당 키 값이 있으면 true, 없으면 false가 반환
		System.out.println("tel 키 값의 존재 여부 : " + map.containsKey("tel"));
		System.out.println("age 키 값의 존재 여부 : " + map.containsKey("age"));
		System.out.println();
		
		// Map에 저장된 전체 데이터를 가져와 사용하기
		
		// 방법 1 : 전제 key 값들을 가져와 처리하기 => keySet()메서드 이용하기
		// keySet() 메서드 => Map의 모든 key 값들을 읽어와 Set형으로 반환
		
		// 방법 1-1 : keySet()과 Iterator를 이용한 방법
		Set<String> keyset = map.keySet();
		
		Iterator<String> keyIt = keyset.iterator();
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("------------------------------------");
		
		// 방법 1-2 : keySet()와 향상된 for문을 이용하는 방법
		for(String key2 : keyset) {
			String value2 = map.get(key2);
			System.out.println(key2 + " : " + value2);
		}
		System.out.println("------------------------------------");
		
		// 방법2 : value값만 읽어와 처리하기 => values()메서드 이용하기
		for(String value3 : map.values())
			System.out.println(value3);
	}

}
