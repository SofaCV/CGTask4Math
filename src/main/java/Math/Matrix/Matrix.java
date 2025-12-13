package Math.Matrix;
import Math.MatrixAndVector;

public class Matrix implements MatrixAndVector {

    /**
     * @param firstMatrix
     * @param secondMatrix
     * @return сложение
     */
    @Override
    public float[][] add(float[][] firstMatrix, float[][] secondMatrix) {
        int len = firstMatrix.length;
        float[][] add = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                add[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return add;
    }

    /**
     * @param firstMatrix
     * @param secondMatrix
     * @return разность
     */
    @Override
    public float[][] subtract(float[][] firstMatrix, float[][] secondMatrix) {
        int len = firstMatrix.length;
        float[][] subtract = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                subtract[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return subtract;
    }

    /**
     * @param matrix
     * @param scalar
     * @return умножение на скаляр
     */
    @Override
    public float[][] multiByScalar(float[][] matrix, float scalar) {
        int len = matrix.length;
        float[][] multiByScalar = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                multiByScalar[i][j] = matrix[i][j] * scalar;
            }
        }
        return multiByScalar;
    }

    /**
     * @param matrix
     * @param scalar
     * @return деление на скаляр
     */
    @Override
    public float[][] divByScalar(float[][] matrix, float scalar) {
        int len = matrix.length;
        float[][] divByScalar = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                divByScalar[i][j] = matrix[i][j] / scalar;
            }
        }
        return divByScalar;
    }

    //транспонирование
    public float[][] transposition(float[][] matrix) {
        int len = matrix.length;
        float buffer;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                buffer = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = buffer;
            }
        }
        return matrix;
    }

    //единичная матрица
    public float[][] identityMatrix(int row, int col) {
        float[][] identityMatrix = new float[row][col];

        for(int i = 0; i < identityMatrix.length; i++){
            for (int j = 0; j < identityMatrix.length; j++){
                identityMatrix[i][j] = 0;

                if(i == j){
                    identityMatrix[i][j] = 1;
                }
            }
        }
        return identityMatrix;
    }

    //нулевая матрица
    public static float[][] zeroMatrix(int row, int col) {
        float[][] zeroMatrix = new float[row][col];

        for(int i = 0; i < zeroMatrix.length; i++){
            for (int j = 0; j < zeroMatrix.length; j++){
                zeroMatrix[i][j] = 0;
            }
        }
        return zeroMatrix;
    }
}
