package java_programming.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class MainClass {

	public static void main(String[] args) {
		Shape t1 = new Triangle(20);
		Shape t2 = new Triangle(21);
		Shape r1 = new Rectangle(40);
		HashMap<Shape, Integer> map = new HashMap<Shape, Integer>();
		map.put(t1, 3);
		map.put(t2, 4);
		map.put(r1, 8);
		System.out.println(map);
		HashSet<Shape> set = new HashSet<>();
		set.add(t1);
		set.add(t2);
		System.out.println(set);
	}

}