package Math.Matrix;

public abstract class Matrix{
    //сложение
    public static float[][] add(float[][] firstObject, float[][] secondObject) {
        int row = firstObject.length;
        int col = firstObject[0].length;
        float[][] add = new float[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                add[i][j] = firstObject[i][j] + secondObject[i][j];
            }
        }
        return add;
    }

    //разность
    public static float[][] subtract(float[][] firstObject, float[][] secondObject) {
        int rows = firstObject.length;
        int cols = firstObject[0].length;
        float[][] subtract = new float[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                subtract[i][j] = firstObject[i][j] - secondObject[i][j];
            }
        }
        return subtract;
    }

    //умножение на скаляр
    public static float[][] multiByScalar(float[][] matrix, float scalar) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        float[][] multiByScalar = new float[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                multiByScalar[i][j] = matrix[i][j] * scalar;
            }
        }
        return multiByScalar;
    }

    //умножение на вектор
    public static float[] multiByVector(float[][] matrix, float[] vector) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        float[] multiByScalar = new float[rows];

        if (cols != vector.length) {
            throw new IllegalArgumentException(
                    String.format("Несовместимые размеры: матрица %dx%d, вектор длины %d",
                            rows, cols, vector.length)
            );
        }

        for (int i = 0; i < rows; i++) {
            float sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j] * vector[j];
            }
            multiByScalar[i] = sum;
        }

        return multiByScalar;
    }

    //деление на скаляр
    public static float[][] divByScalar(float[][] object, float scalar) {
        int row = object.length;
        int col = object[0].length;
        float[][] divByScalar = new float[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                divByScalar[i][j] = object[i][j] / scalar;
            }
        }
        return divByScalar;
    }
    //транспонирование
    public static float[][] transposition(float[][] matrix) {
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
}
