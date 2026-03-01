package com.ssafy.ws.step5;

public class BoardTest {

	public static void main(String[] args) {

		IUserManager userManager = UserManagerImpl.getInstance();
		IArticleManager articleManager = ArticleManagerImpl.getInstance();

		// 회원가입
		userManager.signup(new User(1, "admin", "1234", "관리자", "master", "admin@test.com"));
		userManager.signup(new User(2, "user1", "1111", "홍길동", "hong", "hong@test.com"));
		userManager.signup(new User(3, "user2", "2222", "김철수", "kim", "kim@test.com"));

		// 로그인
		userManager.login("admin", "1234");
		System.out.println("로그인: " + userManager.getLoginUser());

		// 게시글 등록
		articleManager.addArticle(new Article(1, "자바 공부", "자바는 어렵다", 1));
		articleManager.addArticle(new Article(2, "DB 공부", "SQL 연습", 2));
		articleManager.addArticle(new ImageArticle(3, "풍경 사진", "여행 사진입니다", 3, "beach.jpg", 800, 600));
		articleManager.addArticle(new ImageArticle(4, "프로필 사진", "내 얼굴", 2, "me.png", 400, 400));

		// 댓글 추가
		articleManager.addComment(new Comment(1, 1, 2, "좋은 글입니다."));
		articleManager.addComment(new Comment(2, 1, 3, "공감합니다."));
		articleManager.addComment(new Comment(3, 3, 1, "사진 멋져요!"));

		// 전체 게시글
		System.out.println("\n=== 전체 게시글 ===");
		for (Article a : articleManager.getArticleList()) {
			System.out.println(a);
		}

		// 이미지 게시글 평균 크기
		System.out.println("\n이미지 평균 크기: " + articleManager.getImageSizeAvg());

		// 특정 게시글 조회 (조회수 증가 확인)
		System.out.println("\n게시글 1 조회:");
		System.out.println(articleManager.getArticle(1));
		System.out.println(articleManager.getArticle(1));

		// 댓글 출력
		System.out.println("\n게시글 1 댓글:");
		for (Comment c : articleManager.getCommentList(1)) {
			System.out.println(c);
		}

		// 검색
		System.out.println("\n제목 검색 '공부'");
		for (Article a : articleManager.search(1, "공부")) {
			System.out.println(a);
		}

		userManager.logout();
		System.out.println("\n로그아웃 완료");
	}
}