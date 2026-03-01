package com.ssafy.ws.step3;

import java.util.Arrays;

public class BookManagerImpl implements IBookManager {

	private final int MAX_SIZE = 100;
	private Book[] books = new Book[MAX_SIZE];
	private int size = 0;

	private static IBookManager instance = new BookManagerImpl();

	private BookManagerImpl() {
	}

	public static IBookManager getInstance() {
		return instance;
	}

	@Override
	public void add(Book book) {
		if (size < MAX_SIZE) {
			books[size++] = book;
		} else {
			System.out.println("저장 공간이 가득 찼습니다.");
		}
	}

	@Override
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				for (int j = i; j < size - 1; j++) {
					books[j] = books[j + 1];
				}
				books[--size] = null;
				break;
			}
		}
	}

	@Override
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		Book[] result = new Book[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (books[i].getTitle().contains(title)) {
				result[idx++] = books[i];
			}
		}

		return result;
	}

	@Override
	public Magazine[] getMagazines() {

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		Magazine[] result = new Magazine[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (books[i] instanceof Magazine) {
				result[idx++] = (Magazine) books[i];
			}
		}

		return result;
	}

	@Override
	public Book[] getBooks() {

		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		Book[] result = new Book[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (!(books[i] instanceof Magazine)) {
				result[idx++] = books[i];
			}
		}

		return result;
	}

	@Override
	public int getTotalPrice() {

		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += books[i].getPrice();
		}

		return sum;
	}

	@Override
	public double getPriceAvg() {

		if (size == 0)
			return 0;

		return (double) getTotalPrice() / size;
	}
}