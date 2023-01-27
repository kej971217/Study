package kr.or.ddit.basic;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
	Map<Integer, Room> hotelMap;
	Scanner scanner;

	
	public Hotel() {
		hotelMap = new HashMap<Integer, Room>();
		scanner = new Scanner(System.in);
		
		// 객실 초기화
		for(int i=2; i<4; i++) {
			String type = null;
			switch (i) {
			case 2: type = "싱글룸"; break;
			case 3: type = "더블룸"; break;
			case 4: type = "스위트룸"; break;
			default:
				break;
			}
			for(int j=1; j<=9; j++) {
				int num = i*100+j;
				hotelMap.put(num, new Room(num, type));
			}
		}
	}


	public static void main(String[] args) {
		new Hotel().hotelStart();
		
	}


	private void hotelStart() {
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시오.");
		System.out.println("*********************************************");
		System.out.print("");
		
		while (true) {
			switch (displayMenu()) {
			case 1: checkIn(); break;
			case 2: checkOut(); break;
			case 3: displayRoom(); break;
			case 4: break;

			default:
				break;
			}
		}
	}


	private void displayRoom() {
		
		
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
		
		if(hotelMap.get(num).getGuestName()==null) {
			System.out.println(num + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		String name = hotelMap.get(num).getGuestName();
		hotelMap.get(num).setGuestName(null);
		System.out.println(num + "호 객실에서 " + name + "님이 체크아웃 했습니다.");
	}


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
		
		if(!hotelMap.containsKey(num)){
			System.out.println(num + "호 객실은 존재하지 않습니다.");
			return;
		}
		if(hotelMap.get(num).getGuestName()!=null) {
			System.out.println(num + "호 객실에는 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >> ");
		String name = scanner.next();
		
		hotelMap.get(num).setGuestName(name);
		System.out.println(name + "씨가 " + num +"호 객실에 체크인 했습니다.");
	}


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

class Room { 
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