package com.ssafy.ws.step2;

import java.util.Arrays;

public class MovieTest {

	public static void main(String[] args) {

		IMovieManager manager = MovieManagerImpl.getInstance();

		Movie m1 = new Movie(1, "인터스텔라", "크리스토퍼 놀란", "SF", 169);
		Movie m2 = new Movie(2, "기생충", "봉준호", "드라마", 132);
		SeriesMovie sm1 = new SeriesMovie(3, "어벤져스", "루소 형제", "액션", 150, 1, "엔드게임");

		manager.add(m1);
		manager.add(m2);
		manager.add(sm1);

		System.out.println("전체 목록");
		System.out.println(Arrays.toString(manager.getList()));

		System.out.println("\n일반 영화 목록");
		System.out.println(Arrays.toString(manager.getMovies()));

		System.out.println("\n시리즈 영화 목록");
		System.out.println(Arrays.toString(manager.getSeriesMovies()));

		System.out.println("\n제목 검색 (어벤)");
		System.out.println(Arrays.toString(manager.searchByTitle("어벤")));

		System.out.println("\n평균 상영시간");
		System.out.println(manager.getRunningTimeAvg());
	}
}