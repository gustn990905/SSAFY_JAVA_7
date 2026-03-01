package com.ssafy.ws.step2;

import java.util.Arrays;

public class MovieManagerImpl implements IMovieManager {

	private Movie[] movieList = new Movie[100];
	private final int MAX_SIZE = 100;
	private int size = 0;

	private static IMovieManager instance = new MovieManagerImpl();

	private MovieManagerImpl() {
	}

	public static IMovieManager getInstance() {
		return instance;
	}

	@Override
	public void add(Movie movie) {
		if (size < MAX_SIZE) {
			movieList[size++] = movie;
		} else {
			System.out.println("저장 공간이 가득 찼습니다.");
		}
	}

	@Override
	public Movie[] getList() {
		return Arrays.copyOfRange(movieList, 0, size);
	}

	@Override
	public Movie[] searchByTitle(String title) {

		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		Movie[] result = new Movie[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				result[idx++] = movieList[i];
			}
		}

		return result;
	}

	@Override
	public Movie[] getMovies() {

		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		Movie[] result = new Movie[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				result[idx++] = movieList[i];
			}
		}

		return result;
	}

	@Override
	public SeriesMovie[] getSeriesMovies() {

		int cnt = 0;

		for (int i = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}

		if (cnt == 0)
			return null;

		SeriesMovie[] result = new SeriesMovie[cnt];

		for (int i = 0, idx = 0; i < size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				result[idx++] = (SeriesMovie) movieList[i];
			}
		}

		return result;
	}

	@Override
	public double getRunningTimeAvg() {

		if (size == 0)
			return 0;

		int sum = 0;

		for (int i = 0; i < size; i++) {
			sum += movieList[i].getRunningTime();
		}

		return (double) sum / size;
	}
}