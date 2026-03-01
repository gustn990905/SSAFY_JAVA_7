package interface03_method;

public interface MyInterface1 {
	void method1();
	
	//public 생략 가능
	default void method2() {
		System.out.println("MyInterface1 -> default");
	}
}
