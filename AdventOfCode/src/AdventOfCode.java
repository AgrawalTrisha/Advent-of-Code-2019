import java.util.ArrayList;

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

    // Day 4
    public static int d4p1(String range) {
        String[] rangeArray = range.split("-");
        int count = 0;
        for(int currentNum = Integer.parseInt(rangeArray[0]); currentNum < Integer.parseInt(rangeArray[1]); currentNum++) {
            if(isValid(currentNum)){
                count++;
            }
        }
        return count;
    }
    // problem 1 helper method
    public static boolean isValid(int num) {
        ArrayList<Integer> digitList = new ArrayList<>();
        while(num > 0) {
            int digit = num % 10;
            digitList.add(0,digit);
            num /= 10;
        }
        boolean isIncreasing = true;
        boolean hasPair = false;
        for(int i = 0; i < digitList.size() - 1; i++) {
            if(digitList.get(i) > digitList.get(i+1)) {
                isIncreasing = false;
            }
            if(digitList.get(i) == digitList.get(i+1)) {
                hasPair = true;
            }
        }
        return isIncreasing && hasPair;
    }

    public static int d4p2(String range) {
        String[] rangeArray = range.split("-");
        ArrayList<Integer> possiblePasswords = new ArrayList<>();
        for(int currentNum = Integer.parseInt(rangeArray[0]); currentNum <= Integer.parseInt(rangeArray[1]); currentNum++) {
            if(isValid(currentNum)){
                possiblePasswords.add(currentNum);
            }
        }
        int count = 0;
        for(Integer pw : possiblePasswords) {
            if(isValid2(pw))
                count++;
        }
        return count;
    }
    // problem 2 helper method
    public static boolean isValid2(int num) {
        ArrayList<Integer> digitList = new ArrayList<>();
        while(num > 0) {
            int digit = num % 10;
            digitList.add(0,digit);
            num /= 10;
        }
        boolean hasPair = false;
        for(int i = 0; i < 5 && !hasPair; i++) {
            if(i == 0) {
                hasPair = (digitList.get(i) == digitList.get(i+1) && digitList.get(i+1) != digitList.get(i+2));
            } else if(i == 4) {
                hasPair = (digitList.get(i-1) != digitList.get(i) && digitList.get(i) == digitList.get(i+1));
            } else {
                hasPair = (digitList.get(i - 1) != digitList.get(i) && digitList.get(i) == digitList.get(i+1) && digitList.get(i+1) != digitList.get(i+2));
            }
        }
        return hasPair;
    }
}