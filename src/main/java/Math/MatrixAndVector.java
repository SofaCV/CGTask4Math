package Math;

public interface MatrixAndVector {
    //сложение матриц
    float[][] add(float[][] firstMatrix, float[][] secondMatrix);

    //разность матриц
    float[][] subtract(float[][] firstMatrix, float[][] secondMatrix);

    //умножение на скаляр
    float[][] multiByScalar(float[][] matrix, float scalar);

}