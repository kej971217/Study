package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.naming.directory.SearchControls;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class PhoneBookTest {
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	
	public PhoneBookTest() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}

	public static void main(String[] args) {
		new PhoneBookTest().phoneBookStart();
	}
	// 시작 메서드
	private void phoneBookStart() {
		System.out.println();
		System.out.println("************************");
		System.out.println("  전 화 번 호 관 리 프 로 그 램");
		System.out.println("************************");
		System.out.println();
		
		while (true) {
			int choice = displayMenu();
			
			switch(choice) {
			case 1: // 전화번호 등록
				insert();
				break;
			case 2: // 전화번호 수정
				update();
				break;
			case 3: // 전화번호 삭제
				delete();
				break;
			case 4: // 전화번호 검색
				search();
				break;
			case 5: // 전화번호 전체 출력
				displayAll();break;
			case 0: // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return; // 끝내기
			default:
				System.out.println("번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
				break;
			}
		}
			
	}
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.print("이    름 >>");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)) { // 해당 사람이 없으면 삭제작업을 못 함
			System.out.println(name + "씨 전화번호 정보가 없습니다.");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		
		System.out.println("    검 색 결 과");
		System.out.println("----------------");
		System.out.println(" 이     름 : " + p.getName());
		System.out.println(" 전화번호: " + p.getTel());
		System.out.println(" 주     소 : " + p.getAddr());
		System.out.println();
		
	}

	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요...");
		System.out.print(" 이     름 >> ");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)) { // 해당 사람이 없으면 삭제작업을 못 함
			System.out.println(name + "씨 전화번호 정보가 없습니다.");
			System.out.println("삭제 작업을 마칩니다... ");
			return;
	}
		phoneBookMap.remove(name);
		System.out.println(name + "씨 삭제되었습니다.");
	}

	// 전화번호 정보를 수정하는 메서드
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요...");
		System.out.print(" 이     름 >> ");
		String name = scan.next();
		
		if(!phoneBookMap.containsKey(name)) { // 해당 사람이 없으면 수정작업을 못 함
			System.out.println(name + "씨 전화번호 정보가 없습니다.");
			System.out.println("수정 작업을 마칩니다... ");
			
			return;
			
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();
		
		System.out.print("새로운 주소 >> ");
		String newAddr = scan.next();
		
		// 같은 key 값으로 새로운 전화번호 정보를 저장하면 데이터가 수정된다.
		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
		
		System.out.println(name + "씨 전화번호 수정 완료!!! ");
	}

	// 전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println("---------------------------------------");
		System.out.println(" 번호  이름   전화번호               주소");
		System.out.println("---------------------------------------");
		
		Set<String> phoneKeyset = phoneBookMap.keySet(); // 폰북맵에서 키셋을 다 가져옴
		
		if(phoneKeyset.size() == 0) {
			System.out.println("등록된 전화번호가 하나도 없습니다.");
		}else {
			int num = 0; // 번호가 저장될 변수
			for(String name : phoneKeyset) {
				num ++;
				Phone p =phoneBookMap.get(name);
				System.out.println(" " + num + " " + p.getName() +"  " + p.getTel() + " " + p.getAddr());
			}
		}
		System.out.println("---------------------------------------");
		System.out.println("출력 끝 ... ");
		
	}

	// 전화번호 정보를 등록(추가)하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print(" 이     름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 검사 => containsKey()메서드 또는 get()메서드를 이용해서 검사할 수 있다.
		// 방법 1
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
			
		}
		
		// 방법 2
//		if(phoneBookMap.get(name)!=null) {
//			System.out.println(name + "씨는 이미 등록된 사람입니다.");
//			return;
//		}
		
		System.out.print(" 전화번호 >> ");
		String tel = scan.next();
		
		System.out.print(" 주     소 >> ");
		String addr = scan.next();
		
//		Phone phone = new Phone(name, tel, addr);
//		phoneBookMap.put(name, phone);
		phoneBookMap.put(name, new Phone(name, tel, addr));
		
		System.out.println(name + "씨의 전화번호를 등록 했습니다.");
		
		
	}
	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		
		System.out.println("------------------");
		System.out.println(" 다음 메뉴를 선택하세요.");
		System.out.println("------------------");
		System.out.println(" 1. 전화번호 등록 ");
		System.out.println(" 2. 전화번호 수정");
		System.out.println(" 3. 전화번호 삭제");
		System.out.println(" 4. 전화번호 검색");
		System.out.println(" 5. 전화번호 전체 출력");
		System.out.println(" 0. 프로그램 종료 ");
		System.out.println("------------------");
		System.out.print(" 번호 입력 >> ");
		
		return scan.nextInt();
		
	}

}

class Phone{
	private String name;
	private String addr;
	private String tel;
	public Phone(String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
