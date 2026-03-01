package interface01;

// 완벽하게 추상화된 설계도
public interface MyInterface {
	//작성되는 메서드는 기본으로 추상메서드
	public abstract void method1();//구현부는 없음 ;으로 대체
	void method2(); //public abstract이 생략이 되어 있음
	
	//멤버필드는 아니고 -> 상수를 정의한 것과 같음
	public static final int NUMBER1 = 0;
	int NUMBER2 = 100;		//public static final 생략되어 있음
	
}
