package kr.or.ddit.basic;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Browser b = new Browser();
		b.goURL("1. 네이버");
		b.history();
		
		b.goURL("2. 야후");
		b.history();
		
		b.goURL("3. 구글");
		b.goURL("4. 다음");
		b.history();
		
		System.out.println();
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		System.out.println();
		
		System.out.println("앞으로가기 후...");
		b.goForward();
		b.history();
		System.out.println();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5. 네이트");
		b.history();
	}

}

// 웹브라우저의 앞으로가기, 뒤로가기 기능 구현하기(스택이용)
class Browser{
	private Stack<String> back;		// 이전 방문 내역이 저장될 Stack
	private Stack<String> forward;	// 다음 방문 내역이 저장될 Stack
	private String currentURL;
	
	// 생성자
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	// 사이트를 방문하는 메서드 => 인수값으로 방문할 URL을 넣는다.
	public void goURL(String url) {
		System.out.println(url + "사이트에 접속합니다...");
		if(!"".equals(currentURL)) { // 주어진 URL로 이동하기 전에 현재페이지가 있으면
			back.push(currentURL); // 현재 페이지를 back스택에 추가한다.
		}
		currentURL = url; // 현재 페이지 변경
		forward.clear(); // forward 스택의 전체데이터 삭제
	}
	
	// 뒤로가기
	public void goBack() {
		// isEmpty() 메서드 => Collection이 비어 있으면 true, 그렇지 않다면 false
		if(!back.isEmpty()) { // back 스택이 비어있지 않다면
			forward.push(currentURL); // 현재 페이지를 forward 스택에 추가
			currentURL = back.pop(); // back 스택에서 1개의 요소를 꺼내와 현재 페이지로 한다.
		}
	}
	
	// 앞으로 가기
	public void goForward() {
		if (!forward.isEmpty()) {
			back.push(currentURL); // 현재 페이지를 back 스택에 추가
			currentURL = forward.pop(); // forward 스택에서 1개의 요소를 꺼내와 현재페이지로 한다.
		}
	}
	// 방문 기록을 확인하기
	public void history() {
		System.out.println("--------------------");
		System.out.println("      방    문    기    록    ");
		System.out.println("--------------------");
		System.out.println("back	=> " + back);
		System.out.println("현재 	=> [" + currentURL + "]");
		System.out.println("forward => " + forward);
		System.out.println("--------------------");
		System.out.println();
		
	}
}