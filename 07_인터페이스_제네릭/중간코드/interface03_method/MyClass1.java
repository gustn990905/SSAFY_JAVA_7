package interface03_method;

public class MyClass1 implements MyInterface1{

	@Override
	public void method1() {
		System.out.println("MyClass1 -> method1");
	}
	
	@Override
	public void method2() {
		System.out.println("MyClass1 -> method2");
	}
	
	
	public void method3() {
		System.out.println("MyClass3 -> method3");
	}

}
