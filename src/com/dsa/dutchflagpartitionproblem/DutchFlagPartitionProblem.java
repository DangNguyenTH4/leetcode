package com.dsa.dutchflagpartitionproblem;

public class DutchFlagPartitionProblem {
    public static int[] solution(int[] nums, int pivot) {
        int boundary = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<pivot){
                    nums = swap(nums,i, boundary);
                    boundary++;
            }
        }
        boundary = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>pivot){
                int temp = nums[i];
                nums[i] = nums[boundary];
                nums[boundary] = temp;
                boundary--;
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {3,8,2,3,4,1,5,6,1};
        a = solution(a,4);
        System.out.println(a);
    }
}
