package interface02_다중;

public class Duck implements Swimmable, Flyable{

	@Override
	public void fly() {
		System.out.println("날개로 하늘을 난다.");
	}

	@Override
	public void swim() {
		System.out.println("수영을 할 수 있다.");
	}

}
