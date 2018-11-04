package com.example.andersmaehlumhalvorsen.fotosort;

public class Matrix {

    public double[][] data;

    public int column;
    public int row;

    public int i = 0;
    public int j = 0;

    public int count;



    public Matrix(int column, int row) {

        data = new double[column][row];
        this.row = row;
        this.column = column;
        count = 0;
    }

    public void add(double x) {

       if(i <= column-1 ) {

           data[i][j] = x;
           j++;
           count++;

           if(j > row-1) {
               i++;
               j = 0;
               count++;
           }


       }
    }

    public boolean isSquare() {
        return row == column;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(column, row);

        for (int row = 0; row < row; ++row) {
            for (int col = 0; col < column; ++col) {
                result.data[col][row] = data[row][col];
            }
        }

        return result;
    }

    public static Matrix subMatrix(Matrix matrix, int exclude_row, int exclude_col) {
        Matrix result = new Matrix(matrix.row - 1, matrix.column - 1);

        for (int row = 0, p = 0; row < matrix.row; ++row) {
            if (row != exclude_row - 1) {
                for (int col = 0, q = 0; col < matrix.column; ++col) {
                    if (col != exclude_col - 1) {
                        result.data[p][q] = matrix.data[row][col];

                        ++q;
                    }
                }

                ++p;
            }
        }

        return result;
    }

    public static double[][] transposeMatrix(double [][] m){
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    public static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    public static double[][] inverse(double[][] matrix) {

        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j) * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

}
