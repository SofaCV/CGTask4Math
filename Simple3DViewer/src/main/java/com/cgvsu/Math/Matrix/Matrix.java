package Math.Matrix;

import Math.Vector.Vector;

public abstract class Matrix <T extends Matrix<T>>{
    private final float[][] matrix;

    public Matrix(float[][] matrix){
        this.matrix = matrix.clone();
    }

    public float[][] getMatrix() {
        return matrix;
    }

    public abstract T createNewMatrix(float[][] res);

    //сложение
    public T add(T argument) {
        checkArguments(argument);
        float[][] argMatrix = argument.getMatrix();
        int size = argMatrix.length;
        float[][] resAdd = new float[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                resAdd[i][j] = matrix[i][j] + argMatrix[i][j];
            }
        }
        return createNewMatrix(resAdd);
    }

    //разность
    public T subtract(T argument) {
        checkArguments(argument);
        float[][] argMatrix = argument.getMatrix();
        int size = argMatrix.length;
        float[][] resSubtract = new float[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                resSubtract[i][j] = matrix[i][j] - argMatrix[i][j];
            }
        }
        return createNewMatrix(resSubtract);
    }

    //умножение на скаляр
    public T multiByScalar(float scalar) {
        int size = matrix.length;
        float[][] resMultiByScalar = new float[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                resMultiByScalar[i][j] = matrix[i][j] * scalar;
            }
        }
        return createNewMatrix(resMultiByScalar);
    }

    public abstract <V extends Vector<V>> V createVector(float[] vector);

    // Умножение на вектор
    public <V extends Vector<V>> V multiplyByVector(V vector) {
        checkArgumentsForVector(vector, matrix.length);
        float[] vectorArr = vector.getVector();
        int size = matrix.length;

        float[] result = new float[size];

        for (int i = 0; i < size; i++) {
            float sum = 0;
            for (int j = 0; j < size; j++) {
                sum += matrix[i][j] * vectorArr[j];
            }
            result[i] = sum;
        }

        return createVector(result);
    }

    //деление на скаляр
    public T divByScalar(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        int size = matrix.length;
        float[][] divByScalar = new float[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                divByScalar[i][j] = matrix[i][j] / scalar;
            }
        }
        return createNewMatrix(divByScalar);
    }

    //умножение матриц
    public T mult(T argument){
        checkArguments(argument);
        float[][] argMatrix = argument.getMatrix();
        int size = argMatrix.length;
        float[][] mult = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                float sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += matrix[i][k] * argMatrix[k][j];
                }
                mult[i][j] = sum;
            }
        }
        return createNewMatrix(mult);
    }

    //транспонирование
    public T transposition() {
        int size = matrix.length;
        float[][] transposition = new float[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposition[i][j] = matrix[j][i];
            }
        }
        return createNewMatrix(transposition);
    }

    //исключения на проверку входных данных
    private void checkArguments(T argument){
        if (argument == null) {
            throw new IllegalArgumentException("аргумент не может быть null");
        }
    }

    private <V extends Vector<V>> void checkArgumentsForVector(V argument, int size) {
        if (argument == null) {
            throw new IllegalArgumentException("Вектор не может быть null");
        }
        int length = argument.getVector().length;
        if(length != size){
            throw new IllegalArgumentException(
                    String.format("Несовместимые размеры: матрица %dx%d, вектор длины %d",
                            size, size, length)
            );
        }
    }
}
