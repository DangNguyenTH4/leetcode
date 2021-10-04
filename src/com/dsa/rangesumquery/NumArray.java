package com.dsa.rangesumquery;

public class NumArray {

    int[] sumTemp;

    public NumArray(int[] nums) {
        sumTemp = new int[nums.length];
        sumTemp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumTemp[i] = sumTemp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumTemp[right];
        }
        return sumTemp[right] - sumTemp[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */