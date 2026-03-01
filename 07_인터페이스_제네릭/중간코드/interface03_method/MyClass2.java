package interface03_method;

public class MyClass2 implements MyInterface1, MyInterface2{

	@Override
	public void method2() {
		//MyInterface1에 기본 메서드
		//MyInterface2에 기본 메서드
//		이름이 똑같다 -> 구현의 강제성이 부여된다.
//		MyInterface1.super.method2();
	}

	@Override
	public void method1() {
		//추상 메서드라서 재정의 해야되는건 맞아여
	}

}
