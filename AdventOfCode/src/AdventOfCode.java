public class AdventOfCode {
    // Day 1
    // Problem 1
    public static int d1p1(int mass) {
        return mass / 3 - 2;
    }
    // Problem 2
    public static int d1p2(int mass) {
        int fuel = mass / 3 - 2;
        int sum = 0;
        while(fuel > 0) {
            sum += fuel;
            fuel = fuel / 3 - 2;
        }
        return sum;
    }

    // Day 2
    // Problem 1
    public static int[] d2p1(int[] nums) {
        for(int i = 0; i < nums.length; i += 4) {
            if(nums[i] == 1) {
                nums[nums[i+3]] = nums[nums[i+1]] + nums[nums[i+2]];
            } else if(nums[i] == 2) {
                nums[nums[i+3]] = nums[nums[i+1]] * nums[nums[i+2]];
            } else if(nums[i] == 99) {
                return nums;
            }
        }
        return new int[]{-1};
    }
    // Problem 2
    public static int d2p2(int[] nums) {
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                int[] numsClone = nums.clone();
                numsClone[1] = i;
                numsClone[2] = j;
                numsClone = d2p1(numsClone);
                if(numsClone[0] == 19690720) {
                    return 100 * i + j;
                }
            }
        }
        return -1;
    }
}