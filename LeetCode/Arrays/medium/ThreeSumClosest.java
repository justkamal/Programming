package Arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem: https://leetcode.com/problems/3sum-closest/
 * Companies: bloomberg
 * */

public class ThreeSumClosest {
    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        HashMap<Integer, Pair> preSumMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                preSumMap.put(nums[i] + nums[j], new Pair(i, j));
            }
        }
        int minDiff = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for (int sum : preSumMap.keySet()) {
            for (int index = 0; index < nums.length; ++index) {
                Pair indexPair = preSumMap.get(sum);
                if (indexPair.x != index && indexPair.y != index) {
                    if (Math.abs(target - (nums[index] + sum)) < minDiff) {
                        minDiff = Math.abs(target - (nums[index] + sum));
                        closestSum = nums[index] + sum;
                    }
                }
            }
        }
        return closestSum;
    }

    public int threeSumClosest_Optimal(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; ++i) {
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                int currSum = nums[i] + nums[b] + nums[c];
                if (currSum < target) {
                    ++b;
                } else {
                    ++c;
                }
                if (Math.abs(currSum - target) < Math.abs(minDiff - target)) {
                    minDiff = currSum;
                }
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        ThreeSumClosest mainObj = new ThreeSumClosest();
        System.out.println(mainObj.threeSumClosest(new int[]{-816, -499, -724, 43, -468, -38, 672, 213, -121, 837, -431, -233, 304, 184, 940, -106, 507, -515, 388, 195, -531, 542, -859, 182, 971, 484, 615, 764, 922, -480, 978, -254, 726, -749, -479, 907, -494, 943, -542, -323, -12, -196, 276, -322, 283, -852, 757, -257, -40, 644, -771, 287, 537, -883, -460, 119, -66, -522, 309, 52, 803, 449, -909, -455, 464, 112, -744, 131, -90, 684, -34, 786, -739, 836, 504, -725, -396, -313, -861, 267, -876, -863, 457, 266, -853, 224, -341, -362, -598, -864, -895, -441, -730, 124, -668, -695, 705, 425, -841, -96, 704, 427, -27, -762, -893, -704, -189, 364, 697, 150, 108, -549, 736, 698, 743, -761, -518, 533, -326, -637, 600, 163, 807, 829, 36, -671, 538, -986, 526, -694, -20, -307, -182, 328, 125, -901, -190, -812, -980, -941, 216, -198, 723, -43, 640, -398, -361, 17, 203, 444, 38, 376, -70, -91, 520, -647, 731, 625, 104, -923, -337, -537, -382, 95, -200, 675, 920, -357, -232, -356, 536, -344, -734, -930, -938, 588, 389, 894, 752, 334, -314, 595, -629, -712, -571, -75, -84, -691, -928, -26, -244, -565, -33, 548, 87, -284, 612, -466, -796, -188, -61, -669, 7, -301, 730, -481, 305, 564, 561, 566, 482, 73, 180, -802, -495, 670, -530, -592, 456, 616, -754, -699, -677, -111, -599, -528, -408, 12, -141, 685, 288, 953, 318, 70, -953, -13, 668, 614, -797, 759, 605, 74, -302, 237, 587, 212, -24, 178, -62, 422, 905, -718, -30, 975, -500, -387, -505, -563, -23, 931, 797, 292, 784, 793, 608, 820, -826, -875, -370, -430, 296, -726, 15, 888, 629, -296, 278, 396, 653, -829, 916, -682, -785, 26, -768, -263, 643, -315, 690, 728, -605, -63, 724, -473, 44, 148, 114, 233, 576, 882, -483, -207, 289, -159, 55, -865, -251, -975, -855, -719, -877, -503, 877, 336, 948, 147, 545, -964, 518, -247, -94, -346, 367, -241, -213, -728, 519, 714, 673, -783, 568, 871, -435, -902, 791, 231, 627, 517, -532, -662, 481, -476, -41, -545, 596, 639, 236, 170, 782, -959, -769, 0, 68, 126, 263, -577, 293, -3, -230, 53, -681, -693, -420, -437, -644, -774, 144, -404, 912, 280, 878, 454, 513, 801, 534, 604, 69, 725, -343, -648, -4, -174, -454, 415, -472, 758, -805, -384, -568, 14, 177, 880, 413, 834, 487, -258, -933, 761, -965, 232, -389, 479, -932, -29, -271, 505, 31, 176, -891, -442, -664, -836, 111, 11, -623, 994, -811, 787, 252, 766, -177, -157, 490, -228, 835, 220, 645, -318, 132, -799, 94, 495, 748, -858, -156, -916, -551, -856, 593, 332, 206, 762, -432, 890, 198, -683, 445, -163, -533, 583, -32, 469, -175, -143, -591, 48, 841, 362, 515, 351, 188, 418, -981, 273, -146, 870, -561, 560, 414, 989, 9, 88, -915, -939, 755, -595, -35, 312, -711, 949, -488, 173, -179, -979, 497, -751, -723, 984, -548, 641, -960, -547, -806, -827, -275, -523, 695, -674, -452, 819, -987, 783, 354, -6}, -4492));
        System.out.println(mainObj.threeSumClosest(new int[]{-816, -499, -724, 43, -468, -38, 672, 213, -121, 837, -431, -233, 304, 184, 940, -106, 507, -515, 388, 195, -531, 542, -859, 182, 971, 484, 615, 764, 922, -480, 978, -254, 726, -749, -479, 907, -494, 943, -542, -323, -12, -196, 276, -322, 283, -852, 757, -257, -40, 644, -771, 287, 537, -883, -460, 119, -66, -522, 309, 52, 803, 449, -909, -455, 464, 112, -744, 131, -90, 684, -34, 786, -739, 836, 504, -725, -396, -313, -861, 267, -876, -863, 457, 266, -853, 224, -341, -362, -598, -864, -895, -441, -730, 124, -668, -695, 705, 425, -841, -96, 704, 427, -27, -762, -893, -704, -189, 364, 697, 150, 108, -549, 736, 698, 743, -761, -518, 533, -326, -637, 600, 163, 807, 829, 36, -671, 538, -986, 526, -694, -20, -307, -182, 328, 125, -901, -190, -812, -980, -941, 216, -198, 723, -43, 640, -398, -361, 17, 203, 444, 38, 376, -70, -91, 520, -647, 731, 625, 104, -923, -337, -537, -382, 95, -200, 675, 920, -357, -232, -356, 536, -344, -734, -930, -938, 588, 389, 894, 752, 334, -314, 595, -629, -712, -571, -75, -84, -691, -928, -26, -244, -565, -33, 548, 87, -284, 612, -466, -796, -188, -61, -669, 7, -301, 730, -481, 305, 564, 561, 566, 482, 73, 180, -802, -495, 670, -530, -592, 456, 616, -754, -699, -677, -111, -599, -528, -408, 12, -141, 685, 288, 953, 318, 70, -953, -13, 668, 614, -797, 759, 605, 74, -302, 237, 587, 212, -24, 178, -62, 422, 905, -718, -30, 975, -500, -387, -505, -563, -23, 931, 797, 292, 784, 793, 608, 820, -826, -875, -370, -430, 296, -726, 15, 888, 629, -296, 278, 396, 653, -829, 916, -682, -785, 26, -768, -263, 643, -315, 690, 728, -605, -63, 724, -473, 44, 148, 114, 233, 576, 882, -483, -207, 289, -159, 55, -865, -251, -975, -855, -719, -877, -503, 877, 336, 948, 147, 545, -964, 518, -247, -94, -346, 367, -241, -213, -728, 519, 714, 673, -783, 568, 871, -435, -902, 791, 231, 627, 517, -532, -662, 481, -476, -41, -545, 596, 639, 236, 170, 782, -959, -769, 0, 68, 126, 263, -577, 293, -3, -230, 53, -681, -693, -420, -437, -644, -774, 144, -404, 912, 280, 878, 454, 513, 801, 534, 604, 69, 725, -343, -648, -4, -174, -454, 415, -472, 758, -805, -384, -568, 14, 177, 880, 413, 834, 487, -258, -933, 761, -965, 232, -389, 479, -932, -29, -271, 505, 31, 176, -891, -442, -664, -836, 111, 11, -623, 994, -811, 787, 252, 766, -177, -157, 490, -228, 835, 220, 645, -318, 132, -799, 94, 495, 748, -858, -156, -916, -551, -856, 593, 332, 206, 762, -432, 890, 198, -683, 445, -163, -533, 583, -32, 469, -175, -143, -591, 48, 841, 362, 515, 351, 188, 418, -981, 273, -146, 870, -561, 560, 414, 989, 9, 88, -915, -939, 755, -595, -35, 312, -711, 949, -488, 173, -179, -979, 497, -751, -723, 984, -548, 641, -960, -547, -806, -827, -275, -523, 695, -674, -452, 819, -987, 783, 354, -6}, -4492));
    }
}
