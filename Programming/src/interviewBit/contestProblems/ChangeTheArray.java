package interviewBit.contestProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChangeTheArray {
	private class Element{
        int x = 0;
        int num = 0;
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Collections.sort(A, Collections.reverseOrder());
        ArrayList<Element> arr = new ArrayList<Element>();
        
        for(int i = 0; i < B.size(); ++i){
            Element e = new Element();
            e.x = B.get(i);
            e.num = C.get(i);
            arr.add(e);
        }
        
        Collections.sort(arr, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                return e1.num - e2.num;
            }
        });
        
        int i = 0, j = 0;
        while(i < A.size() && j < arr.size()){
            int b = arr.get(j).x;
            int v = arr.get(j).num;
            while(b-- > 0){
                A.set(i, v);
                ++i;
            }
            ++j;
        }
        
        int sum = 0;
        for(int x : A)
            sum += x;
        
        return sum;
    }
    
    public static void main(String[] args) {
		
	}
}
