package java_programming.hashmap;

public class Triangle extends Shape {

	private int perimeter;

	public Triangle(int perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public void display() {
		System.out.println("Triangle" + perimeter);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Triangle)
			if(this.perimeter == ((Triangle)obj).perimeter)
				return true;
		return false;
	}

	@Override
	public String toString() {
		return "Triangle : " + perimeter;
	}
}
