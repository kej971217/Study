package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>(); // 리스트 생성
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		
		System.out.println("정렬 전");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------");
		
		Collections.sort(memList); // 객체 타입으로 둔 Member에 내부정렬기준이 없으면 오류 발생.
		System.out.println("정렬 후");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------");
		
		// 회원 이름을 기준으로 오름차순 정렬하는 외부 정렬 기준 클래스를 이용하여 정렬하시오.
		// 클래스이름 SortNameAsc
		
		Collections.sort(memList, new SortNameAsc()); // 객체 타입으로 둔 Member에 내부정렬기준이 없으면 오류 발생.
		System.out.println("이름 오름차순 정렬 후");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-------------------------------------------");

	}

}

// 회원데이터를 처리할 클래스 생성
// 회원번호를 기준으로 오름차순 정렬이 되도록 내부 정렬 기준을 추가해주기.
// => Comparable 인터페이스를 구현한다.
class Member implements Comparable<Member>{
	private int num; // 회원번호
	private String name; // 회원이름
	private String tel; // 전화번호
	
	// 생성자
	public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 회원 이름을 기준으로 오름차순 정렬
	@Override
	public int compareTo(Member mem) { // 자신과 괄호안 데이터를 비교 
		/*
		if(this.num > mem.getNum()) {
			return 1; // 양수를 반환하여 두 값의 순서를 바꿈
		}else if(this.num < mem.getNum()) {
			return -1;			 
		}else {
			return 0;
		}
		*/
		return this.num - mem.getNum(); // [앞의 갚이 크면 양수 / 작으면 음수] * 비교 값이 모두 양수 일 때 사용 가능*
		
		// Wrapper 클래스를 이용하는 방법 1
		//return new Integer(this.num).compareTo(mem.getNum());
		
		// Wrapper 클래스를 이용하는 방법 2
		//return Integer.compare(this.num, mem.getNum());
	}
}

class SortNameAsc implements Comparator<Member>{
	// 회원 이름을 기준으로 오름차순 정렬
	@Override
	public int compare(Member mem1, Member mem2) {
		
		return mem1.getName().compareTo(mem2.getName());
	}
	
}