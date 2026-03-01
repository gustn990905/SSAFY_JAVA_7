package com.ssafy.ws.step5;

public class ArticleManagerImpl implements IArticleManager {

	private static final int MAX_ARTICLE_SIZE = 100;
	private static final int MAX_COMMENT_SIZE = 200;

	private Article[] articles = new Article[MAX_ARTICLE_SIZE];
	private Comment[] comments = new Comment[MAX_COMMENT_SIZE];

	private int articleSize = 0;
	private int commentSize = 0;

	private static IArticleManager instance = new ArticleManagerImpl();

	private ArticleManagerImpl() {
	}

	public static IArticleManager getInstance() {
		return instance;
	}

	@Override
	public void addArticle(Article article) {
		articles[articleSize++] = article;
	}

	@Override
	public Article[] getArticleList() {
		Article[] result = new Article[articleSize];
		System.arraycopy(articles, 0, result, 0, articleSize);
		return result;
	}

	@Override
	public Article getArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId) {
				articles[i].setViewCnt(articles[i].getViewCnt() + 1);
				return articles[i];
			}
		}
		return null;
	}

	@Override
	public void removeArticle(int articleId) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == articleId) {
				articles[i] = articles[--articleSize];
				articles[articleSize] = null;
				break;
			}
		}
	}

	@Override
	public void updateArticle(Article article) {
		for (int i = 0; i < articleSize; i++) {
			if (articles[i].getArticleId() == article.getArticleId()) {
				articles[i] = article;
				break;
			}
		}
	}

	@Override
	public Article[] getTextArticleList() {
		Article[] temp = new Article[articleSize];
		int count = 0;
		for (int i = 0; i < articleSize; i++) {
			if (!(articles[i] instanceof ImageArticle)) {
				temp[count++] = articles[i];
			}
		}
		Article[] result = new Article[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public ImageArticle[] getImageArticleList() {
		ImageArticle[] temp = new ImageArticle[articleSize];
		int count = 0;
		for (int i = 0; i < articleSize; i++) {
			if (articles[i] instanceof ImageArticle) {
				temp[count++] = (ImageArticle) articles[i];
			}
		}
		ImageArticle[] result = new ImageArticle[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public double getImageSizeAvg() {
		ImageArticle[] imgs = getImageArticleList();
		if (imgs.length == 0)
			return 0;
		double sum = 0;
		for (ImageArticle img : imgs) {
			sum += img.getWidth() * img.getHeight();
		}
		return sum / imgs.length;
	}

	@Override
	public Article[] search(int option, String keyword) {
		Article[] temp = new Article[articleSize];
		int count = 0;
		for (int i = 0; i < articleSize; i++) {
			if (option == 1 && articles[i].getTitle().contains(keyword))
				temp[count++] = articles[i];
			else if (option == 2 && articles[i].getContent().contains(keyword))
				temp[count++] = articles[i];
		}
		Article[] result = new Article[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public void addComment(Comment comment) {
		comments[commentSize++] = comment;
	}

	@Override
	public void removeComment(int commentId) {
		for (int i = 0; i < commentSize; i++) {
			if (comments[i].getCommentId() == commentId) {
				comments[i] = comments[--commentSize];
				comments[commentSize] = null;
				break;
			}
		}
	}

	@Override
	public Comment[] getCommentList(int articleId) {
		Comment[] temp = new Comment[commentSize];
		int count = 0;
		for (int i = 0; i < commentSize; i++) {
			if (comments[i].getArticleId() == articleId)
				temp[count++] = comments[i];
		}
		Comment[] result = new Comment[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}
}