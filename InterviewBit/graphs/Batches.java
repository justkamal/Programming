package graphs;

import java.util.Arrays;
import java.util.HashMap;

public class Batches {

	int[] batch;

	public int findBatch(int node) {
		if (batch[node] == node)
			return node;
		int root = findBatch(batch[node]);
		batch[node] = root;
		return root;
	}

	public void union(HashMap<Integer, Integer> batchStrengthMap, int[] strength, int friend1, int friend2) {
		int batchId1 = findBatch(friend1);
		int batchId2 = findBatch(friend2);
		if (batchId1 != batchId2) {
			/*
			 * unite the batches if the batch-mates are connected and remove the older batch
			 * (batch2 here) as it's a part of batch1
			 */		
			int strengthOfBatch2 = batchStrengthMap.getOrDefault(batchId2, strength[batchId2]);
			
			batchStrengthMap.put(batchId1, batchStrengthMap.getOrDefault(batchId1, strength[batchId1]) + strengthOfBatch2);
			
			batchStrengthMap.remove(batchId2); // removing older batch
			
			batch[batchId2] = batchId1;	//union step
		}
	}

	public int solve(int nStudents, int[] strength, int[][] connection, int strengthLimit) {
		HashMap<Integer, Integer> batchStrengthMap = new HashMap<Integer, Integer>();

		batch = new int[nStudents];

		for (int i = 0; i < batch.length; ++i)
			batch[i] = i;

		for (int i = 0; i < connection.length; ++i) {
			int friend1 = connection[i][0] - 1;
			int friend2 = connection[i][1] - 1;

			union(batchStrengthMap, strength, friend1, friend2);
		}

		int count = 0;

		for (int batchId : batch) {
			if (!batchStrengthMap.containsKey(batchId) && batch[batchId] == batchId
					&& strength[batchId] >= strengthLimit)
				++count;
		}

		for (int batchId : batchStrengthMap.keySet()) {
			if (batchStrengthMap.get(batchId) >= strengthLimit)
				++count;
		}

		System.out.println(Arrays.toString(batch));
		System.out.println(batchStrengthMap);

		return count;
	}

	public static void main(String[] args) {
		Batches obj = new Batches();
		int[][] connection = { {1,6}, {3,6}};
		int[] strength = { 2, 8, 6, 10, 8, 10};
		System.out.println(obj.solve(6, strength, connection, 2));
	}

}
