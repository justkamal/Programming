package java_programming.hashmap;

public class Rectangle extends Shape {

	private int perimeter;
	
	public Rectangle(int perimeter) {
		this.perimeter = perimeter;
	}
	
	@Override
	public void display() {
		System.out.println("Rectangle " + perimeter);
	}
	
	@Override
	public String toString() {
		return "Rectangle : " + perimeter;
	}
}