package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {

		IBookManager manager = BookManagerImpl.getInstance();

		Book b1 = new Book("1111", "자바의 정석", "남궁성", "도우출판", 30000, "자바 기본서");

		Book b2 = new Book("2222", "알고리즘", "홍길동", "싸피출판", 25000, "자료구조 알고리즘");

		Magazine m1 = new Magazine("3333", "월간 자바", "김싸피", "싸피출판", 15000, "자바 월간지", 2025, 3);

		manager.add(b1);
		manager.add(b2);
		manager.add(m1);

		System.out.println("전체 목록");
		System.out.println(Arrays.toString(manager.getList()));

		System.out.println("\nISBN 검색");
		System.out.println(manager.searchByIsbn("1111"));

		System.out.println("\n제목 검색");
		System.out.println(Arrays.toString(manager.searchByTitle("자바")));

		System.out.println("\n일반 도서 목록");
		System.out.println(Arrays.toString(manager.getBooks()));

		System.out.println("\n잡지 목록");
		System.out.println(Arrays.toString(manager.getMagazines()));

		System.out.println("\n총 가격");
		System.out.println(manager.getTotalPrice());

		System.out.println("\n평균 가격");
		System.out.println(manager.getPriceAvg());
	}
}