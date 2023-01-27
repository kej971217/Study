package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest { // 데이터 저장 공간; 자료구조
	/*
	 	Stack => 후입선출(LIFO; Last In First Out)의 자료구조
	 	Queue => 선입선출(FIFO; First In First Out)의 자료구조
	 */
	

	public static void main(String[] args) {
	/*
	 	Stack의 명령 // 앞으로가기 / 뒤로가기
	 	1. 자료 입력 : push(입력값)
	 	2. 자료 출력 : pop() => 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
	 				peek() => 삭제없이 자료를 꺼내온다. (시행 검토를 위해 사용)
	 */
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재  stack값: "+ stack);
		
		String data = stack.pop(); 
		System.out.println("꺼내온 값 : "+ data); // 강감찬
		System.out.println("꺼내온 값 : "+ stack.pop()); // 변학도
		System.out.println("현재 stack 값 : " + stack); // [홍길동, 일지매]
		
		stack.push("성춘향");
		System.out.println("추가후 stack값 : "+ stack); // [홍길동, 일지매, 성춘향]
		
		System.out.println("꺼내온 값 : " + stack.pop() ); // 성춘향
		System.out.println("현재 stack 값 : " + stack); // [홍길동, 일지매]
		System.out.println("삭제 없이 꺼내온 값 : " + stack.peek()); // 일지매
		System.out.println("현재 stack 값 : " + stack); // [홍길동, 일지매]
		
		System.out.println("-------------------------------------------------");
		
		/*
	 	Queue의 명령 // 프린터
	 	1. 자료 입력 : offer(입력값)
	 	2. 자료 출력 : poll() => 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
	 				push() => 삭제없이 자료를 꺼내온다.
		 */
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재의 queue값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재의 queue값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue값 : " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("현재의 queue값 : " + queue); // [강감찬, 성춘향]
		
		System.out.println("꺼내온 값 : " + queue.peek());
		System.out.println("현재의 queue값 : " + queue); // [강감찬, 성춘향]
		
		
		
	}

}
