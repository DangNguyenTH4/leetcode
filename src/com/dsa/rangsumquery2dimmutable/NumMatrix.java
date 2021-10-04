package com.dsa.rangsumquery2dimmutable;

class NumMatrix {
    int[][] sumTemp;

    public NumMatrix(int[][] matrix) {
        sumTemp = new int[matrix.length][matrix[0].length];
        sumTemp[0][0] = matrix[0][0];

        for (int i = 1; i < matrix[0].length; i++) {
            sumTemp[0][i] = sumTemp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            sumTemp[i][0] = sumTemp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                sumTemp[i][j] = matrix[i][j] + sumTemp[i][j - 1] + sumTemp[i - 1][j] - sumTemp[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int biggestSum = sumTemp[row2][col2];
        int leftSum = col1 == 0 ? 0 : sumTemp[row2][col1 - 1];
        int topSum = row1 == 0 ? 0 : sumTemp[row1 - 1][col2];
        int commonSum = 0;
        if (row1 != 0 && col1 != 0) {
            commonSum = sumTemp[row1 - 1][col1 - 1];
        }
        return biggestSum - leftSum - topSum + commonSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        System.out.println(new NumMatrix(matrix).sumRegion(0, 0, 0, 1));
    }
}