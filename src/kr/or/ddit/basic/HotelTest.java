package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelTest {
	
	Map<Integer,Room> hotelMap;
	Scanner scanner;
	
	// 생성자
	public HotelTest() {
		hotelMap = new HashMap<Integer, Room>();
		scanner= new Scanner(System.in);
		
		// 객실 초기화
		for(int i=2; i<=4; i++) {
			String type =null;
			switch (i) {
			case 2: type = "싱글룸";break;
			case 3: type = "더블룸";break;
			case 4: type = "스위트룸";break;
			default:
				break;
			}
			for(int j=1; j<=9; j++) {
				int num = i*100+j;
				hotelMap.put(num, new Room(num, type));
			}
		}
	} // 생성자 끝...


	public static void main(String[] args) {
		new HotelTest().hotelStart();
	}
	
	// 시작 메서드
	public void hotelStart() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시오.");
		System.out.println("*********************************************");
		System.out.print("");
		
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // 체크인
				checkIn(); break;
			case 2: // 체크아웃
				checkOut(); break;
			case 3: // 객실 상태
				displayRoom(); break;
			case 4: // 종료
				System.out.println("*********************************************");
				System.out.println("			호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시 선택하세요.");
				break;
			}
		}
	}
	
	private void checkOut() {
		System.out.println("----------------------------------------------");
		System.out.println("	체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" 체크아웃 할 방 번호를 입력하세요.");
		System.out.print(" 방 번호 입력 >> ");
		int num = scanner.nextInt();
		
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		
		// 해당 객실에 손님이 없는지 여부 검사
		if(hotelMap.get(num).getGuestName()==null) {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		
		// 체크아웃 작업은 해당 객실의 손님 이름을 null로 변경하면 된다.
		String name = hotelMap.get(num).getGuestName(); // 현재 손님의 이름 구하기
		
		hotelMap.get(num).setGuestName(null);
		
		System.out.println(num + "호 객실에서 " + name + " 님이 체크아웃 했습니다.");
	}


	// 객실 상태를 출력하는 메서드
	private void displayRoom() {
		
		// 방 번호를 순서대로 출력하기 위해 방 번호(Map의 key 값)만 List에 넣은 후 정렬하여 사용
		ArrayList<Integer> numList = new ArrayList<Integer>(hotelMap.keySet());
		
		// 정렬하기
		Collections.sort(numList);
		
		System.out.println("--------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("--------------------------------");
		System.out.println(" 방 번호	 방 종류	 투숙객 이름");
		System.out.print("--------------------------------");
		
		// List에서 방 번호 하나씩 차례로 꺼내와 Map에서 해당 방 번호에 저장된 Room 객체를 구해서 출력한다.
		for(int i=0; i<numList.size(); i ++) {
			Room r = hotelMap.get(numList.get(i));
			String name = r.getGuestName()!=null? r.getGuestName() : "-";
			
			System.out.println(r.getRoomNum() + "\t" + r.getRoomType()+ "\t" + name);
		}
		System.out.println("--------------------------------");
		System.out.println();
	}


	// 체크인을 처리하는 메서드
	private void checkIn() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print(" 방 번호 입력 >> ");
		int num = scanner.nextInt();
		
		// 입력한 방번호가 Map의 key 값에 없으면 없는 방 번호 이다.
		if(!hotelMap.containsKey(num)) {
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		// 해당 객실에 이미 다른 손님이 있는지 검사
		if(hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print(" 이름 입력 >> ");
		String name = scanner.next();
		
		// 입력 받은 손님의 이름을 해당 객실의 투숙객 이름이 저장될 변수에 저장한다.
		hotelMap.get(num).setGuestName(name);
		
		System.out.println(name + "씨가 " + num+"호 객실에 체크인 했습니다.");
		
	}


	// 메뉴를 출력하고 작업번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println(" 어떤 업무를 하시겠습니까? ");
		System.out.println(" 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print(" 선택 >> ");
		
		return scanner.nextInt();
		
	}
}

// 생성자
class Room{
	private int roomNum;
	private String roomType;
	private String guestName;
	
	public Room(int roomNum, String roomType) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
		
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public String getGuestName() {
		return guestName;
	}
	
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
}