package Math.Vector;

public abstract class Vector<T extends Vector<T>>{
    private final float[] vector;

    protected Vector(float[] vector){
        this.vector = vector.clone();
    }

    public float[] getVector() {
        return vector;
    }

    public abstract T createNewVector(float[] result);

    //сложение
    public T add(T argument) {
        checkArguments(argument);
        float[] argVector = argument.getVector();
        int len = argVector.length;
        float[] resAdd = new float[len];

        for(int i = 0; i < len; i++){
            resAdd[i] = vector[i] + argVector[i];
        }
        return createNewVector(resAdd);
    }

    //разность
    public T subtract(T argument) {
        checkArguments(argument);
        float[] argVector = argument.getVector();
        int len = argVector.length;
        float[] resSubtract = new float[len];

        for(int i = 0; i < len; i++){
            resSubtract[i] = vector[i] - argVector[i];
        }
        return createNewVector(resSubtract);
    }

    //умножение на скаляр
    public T multiByScalar(float scalar) {
        int len = vector.length;
        float[] resMultiByScalar = new float[len];

        for(int i = 0; i < len; i++){
            resMultiByScalar[i] = vector[i] * scalar;
        }
        return createNewVector(resMultiByScalar);
    }

    //деление на скаляр
    public T divByScalar(float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        int len = vector.length;
        float[] resDivByScalar = new float[len];

        for(int i = 0; i < len; i++){
            resDivByScalar[i] = vector[i] / scalar;
        }
        return createNewVector(resDivByScalar);
    }

    //длина
    public float vectorLength() {
        int len = vector.length;
        float sum = 0;

        for (int i = 0; i < len; i++){
            sum += vector[i] * vector[i];
        }
        return (float)Math.sqrt(sum);
    }

    //нормализация
    public T normalization() {
        float length = vectorLength();
        float[] normalized = new float[vector.length];

        for (int i = 0; i < vector.length; i++) {
            normalized[i] = vector[i] / length;
        }
        return createNewVector(normalized);
    }

    //скалярное произведение
    public float scalarMultiplication(T argument) {
        checkArguments(argument);
        float[] argVector = argument.getVector();
        int len = argVector.length;
        float scalarMultiplication = 0;

        for(int i = 0; i < len; i++){
            scalarMultiplication += vector[i] * argVector[i];
        }
        return scalarMultiplication;
    }

    //исключения на проверку входных данных
    private void checkArguments(T argument){
        if (argument == null) {
            throw new IllegalArgumentException("аргумент не может быть null");
        }
    }
}
