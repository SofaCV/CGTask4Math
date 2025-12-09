package Math;

public class Matrix implements MatrixAndVector{
    private final int rowCol;

    public Matrix(int rowCol){
        this.rowCol = rowCol;
    }

    /**
     * @param firstMatrix
     * @param secondMatrix
     * @return сложение матриц
     */
    @Override
    public float[][] add(float[][] firstMatrix, float[][] secondMatrix) {
        float[][] add = new float[rowCol][rowCol];

        for(int i = 0; i < rowCol; i++){
            for(int j = 0; j < rowCol; j++){
                add[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return add;
    }

    /**
     * @param firstMatrix
     * @param secondMatrix
     * @return разность матриц
     */
    @Override
    public float[][] subtract(float[][] firstMatrix, float[][] secondMatrix) {
        float[][] subtract = new float[rowCol][rowCol];

        for(int i = 0; i < rowCol; i++){
            for(int j = 0; j < rowCol; j++){
                subtract[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return subtract;
    }

    /**
     * @param matrix
     * @param scalar
     * @return умножение матрицы на скаляр
     */
    @Override
    public float[][] multiByScalar(float[][] matrix, float scalar) {
        float[][] multiByScalar = new float[rowCol][rowCol];

        for(int i = 0; i < rowCol; i++){
            for(int j = 0; j < rowCol; j++){
                multiByScalar[i][j] = matrix[i][j] - scalar;
            }
        }
        return multiByScalar;
    }

    //транспонирование матрицы
    public float[][] transposition(float[][] matrix) {
        float buffer;
        for (int i = 0; i < rowCol; i++) {
            for (int j = i + 1; j < rowCol; j++) {
                buffer = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = buffer;
            }
        }
        return matrix;
    }

    //единичная матрица
    public float[][] identityMatrix() {
        float[][] identityMatrix = new float[rowCol][rowCol];

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
    public static float[][] zeroMatrix() {
        float[][] zeroMatrix = new float[rowCol][rowCol];

        for(int i = 0; i < zeroMatrix.length; i++){
            for (int j = 0; j < zeroMatrix.length; j++){
                zeroMatrix[i][j] = 0;
            }
        }
        return zeroMatrix;
    }
}
