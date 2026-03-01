package com.ssafy.hw.step4;

public class ProductTest {
	public static void main(String[] args) {

		IProductManager manager = ProductManagerImpl.getInstance();

		manager.addProduct(new Product("P1", "TV", 1000, 5, "LG", "Smart TV"));
		manager.addProduct(new Refrigerator("R1", "냉장고", 2000, 3, "Samsung", "대형 냉장고", "양문형", 500, true, 2024));

		manager.addReview(new Review(1, "P1", "홍길동", "좋아요"));
		manager.addReview(new Review(2, "R1", "김철수", "최고입니다"));

		System.out.println("전체 상품:");
		for (Product p : manager.getProducts()) {
			System.out.println(p);
		}

		System.out.println("\n냉장고만:");
		for (Refrigerator r : manager.getRefrigerators()) {
			System.out.println(r);
		}

		System.out.println("\n총 재고 금액: " + manager.getTotalPrice());
	}
}