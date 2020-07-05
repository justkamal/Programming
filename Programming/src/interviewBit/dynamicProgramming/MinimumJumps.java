package interviewBit.dynamicProgramming;

public class MinimumJumps {

	public int jump(int[] arr) {
		int n = arr.length;
		if(n <= 1){
            return 0;
        }
        int maxReachPos = arr[0];
        int curMaxReachPos = arr[0];
        int curStep = 1;
        for(int i = 1; i <= maxReachPos; i++){
            if(i == n - 1){
                return curStep;
            }
            curMaxReachPos = Math.max(curMaxReachPos, i + arr[i]);
            if(i == maxReachPos){
                if (curMaxReachPos <= i) return -1;
                maxReachPos = curMaxReachPos;
                curStep++;
            }
        }
        return -1;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 0 , 0};
		int[] arr2 = {1, 2 , 3, 2, 1, 0, 0};
		MinimumJumps obj = new MinimumJumps();
		//System.out.println(obj.jump(arr1));
		System.out.println(obj.jump(arr2));
	}

}
