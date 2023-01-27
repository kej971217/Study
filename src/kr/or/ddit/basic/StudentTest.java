package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 	문제) 학번(int), 이름(String), 국어, 영어, 수학점수, 총점, 등수를 멤버로 갖는
 		 Student 클래스를 만든다. 이 Student클래스의 생성자에서는 학번, 이름, 국어, 영어, 수학점수만
 		  인수값으로 받아서 초기화 되도록 처리한다.
 		 
 		 이 Student 객체는 List에 저장하여 관리한다.
 		 
 		 List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
 		 총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를 작성하여 
 		 정렬된 결과를 출력하시오.
 		 
 		 (단, 등수는 List에 전체 데이터가 추가된 후에 구하도록 한다.)
*/

public class StudentTest {
	
	// 등수를 구하는 메서드
	public void setRank(ArrayList<Student> list) {
		for(Student std1 : list) { // 기준 데이터(std1)를 위한 반복분
			int rank = 1;		   // 처음에는 1등으로 설정해 놓고 시작한다.
			
			for(Student std2 : list) { // 비교 대상을 나타내는 반복문
				
				// 기준보다 큰 값을 만나면 rank값을 증가시킨다.
				if(std1.getTotalScore() < std2.getTotalScore()) {
					rank++;
				}
			}
			std1.setRank(rank);		// 구해진 등수를 기준 데이터의 등수로 저장
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		StudentTest stdTest = new StudentTest(); // setRank 가져오기위한 객체 생성
		
		studentList.add(new Student(1, "홍길동", 56, 75, 88));
		studentList.add(new Student(8, "이순신", 78, 94, 60));
		studentList.add(new Student(4, "성춘향", 40, 50, 92));
		studentList.add(new Student(5, "강감찬", 49, 50, 75));
		studentList.add(new Student(3, "일지매", 40, 50, 92));
		studentList.add(new Student(7, "변학도", 70, 59, 91));
		
		// 등수 구하기
		stdTest.setRank(studentList);
		
		
		System.out.println("정렬전");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("---------------------------------------------------------");
		Collections.sort(studentList);
		System.out.println("학번 오름차순 정렬 후");
		for(Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("---------------------------------------------------------");
		Collections.sort(studentList, new ScoreReverse());
		System.out.println("총점 역순 정렬 + 총점 같으면 이름 오름차순");
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
}

//총점 역순  후 같은 총점이면 이름 오름차순
class ScoreReverse implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTotalScore() == std2.getTotalScore()) {
			return std1.getName().compareTo(std2.getName());
		}else {
			return Integer.compare(std1.getTotalScore(), std2.getTotalScore()) * -1;
		}
	}
	// 내가 한 방법
//	@Override
//	public int compare(Student std1, Student std2) {
//		if(std1.getTotalScore()>std2.getTotalScore()) {
//			return -1;
//		}else if (std1.getTotalScore()<std2.getTotalScore()) {
//			return 1;
//		}else if (std1.getTotalScore()==std2.getTotalScore()) {
//			return std1.getName().compareTo(std2.getName());
//		}else {
//			return 0;
//		}
//	}
}

class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int score1;
	private int score2;
	private int score3;
	private int totalScore=score1+score2+score3;
	private int rank;
	
	public Student(int num, String name, int score1, int score2, int score3) {
		super();
		this.num = num;
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.totalScore=score1+score2+score3;
		
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

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = score1+score2+score3;
	}
	
	

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

//	@Override
//	public String toString() {
//		return "Student [num=" + num + ", name=" + name + ", score1=" + score1 + ", score2=" + score2 + ", score3="
//				+ score3 + ", totalScore=" + totalScore + "]";
//	}
	
	
	

	// 학번 기준으로 오름차순 정렬 (내방법)
//	@Override
//	public int compareTo(Student std) {
//		if(this.num > std.getNum()) {
//			return 1;
//		}else if (this.num < std.getNum()) {
//			return -1;
//		}else {
//			return 0;
//		}
//	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", score1=" + score1 + ", score2=" + score2 + ", score3="
				+ score3 + ", totalScore=" + totalScore + ", rank=" + rank + "]";
	}

	//학번의 오름차순
	@Override
	public int compareTo(Student std) {
		return Integer.compare(this.num, std.getNum());
	}
	
}

