package com.ssafy.hw.step4;

public class ProductManagerImpl implements IProductManager {

	private static final int MAX_PRODUCT_SIZE = 100;
	private static final int MAX_REVIEW_SIZE = 100;

	private Product[] products = new Product[MAX_PRODUCT_SIZE];
	private Review[] reviews = new Review[MAX_REVIEW_SIZE];

	private int pCount = 0;
	private int rCount = 0;

	private static IProductManager instance = new ProductManagerImpl();

	private ProductManagerImpl() {
	}

	public static IProductManager getInstance() {
		return instance;
	}

	@Override
	public boolean addProduct(Product product) {
		if (pCount >= MAX_PRODUCT_SIZE)
			return false;
		products[pCount++] = product;
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(product.getpCode())) {
				products[i] = product;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeProduct(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode)) {
				products[i] = products[--pCount];
				products[pCount] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public int sell(String pCode, int cnt) {
		Product p = searchByCode(pCode);
		if (p != null && p.getQuantity() >= cnt) {
			p.setQuantity(p.getQuantity() - cnt);
			return p.getPrice() * cnt;
		}
		return -1;
	}

	@Override
	public Product[] getProductList() {
		Product[] result = new Product[pCount];
		System.arraycopy(products, 0, result, 0, pCount);
		return result;
	}

	@Override
	public Product searchByCode(String pCode) {
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpCode().equals(pCode))
				return products[i];
		}
		return null;
	}

	@Override
	public boolean addReview(Review review) {
		if (rCount >= MAX_REVIEW_SIZE)
			return false;
		reviews[rCount++] = review;
		return true;
	}

	@Override
	public boolean removeReview(int reviewId) {
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getReviewId() == reviewId) {
				reviews[i] = reviews[--rCount];
				reviews[rCount] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public Review[] getProductReview(String pCode) {
		Review[] temp = new Review[rCount];
		int count = 0;
		for (int i = 0; i < rCount; i++) {
			if (reviews[i].getpCode().equals(pCode)) {
				temp[count++] = reviews[i];
			}
		}
		Review[] result = new Review[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public Product[] searchByName(String name) {
		Product[] temp = new Product[pCount];
		int count = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i].getpName().contains(name)) {
				temp[count++] = products[i];
			}
		}
		Product[] result = new Product[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public long getTotalPrice() {
		long sum = 0;
		for (int i = 0; i < pCount; i++) {
			sum += (long) products[i].getPrice() * products[i].getQuantity();
		}
		return sum;
	}

	@Override
	public Product[] getProducts() {
		return getProductList();
	}

	@Override
	public Refrigerator[] getRefrigerators() {
		Refrigerator[] temp = new Refrigerator[pCount];
		int count = 0;
		for (int i = 0; i < pCount; i++) {
			if (products[i] instanceof Refrigerator) {
				temp[count++] = (Refrigerator) products[i];
			}
		}
		Refrigerator[] result = new Refrigerator[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}

	@Override
	public Refrigerator[] getRefrigeratorsFreezer(boolean freezer) {
		Refrigerator[] temp = new Refrigerator[pCount];
		int count = 0;
		for (Refrigerator r : getRefrigerators()) {
			if (r.isFreezer() == freezer) {
				temp[count++] = r;
			}
		}
		Refrigerator[] result = new Refrigerator[count];
		System.arraycopy(temp, 0, result, 0, count);
		return result;
	}
}