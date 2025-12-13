package Math.Vector;
import Math.MatrixAndVector;

public class Vector implements MatrixAndVector {

    /**
     * @param firstVector
     * @param secondVector
     * @return сложение
     */
    @Override
    public float[][] add(float[][] firstVector, float[][] secondVector) {
        int len = firstVector.length;
        float[][] add = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                add[i][j] = firstVector[i][j] + secondVector[i][j];
            }
        }
        return add;
    }

    /**
     * @param firstVector
     * @param secondVector
     * @return разность
     */
    @Override
    public float[][] subtract(float[][] firstVector, float[][] secondVector) {
        int len = firstVector.length;
        float[][] subtract = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                subtract[i][j] = firstVector[i][j] - secondVector[i][j];
            }
        }
        return subtract;
    }

    /**
     * @param vector
     * @param scalar
     * @return умножение на скаляр
     */
    @Override
    public float[][] multiByScalar(float[][] vector, float scalar) {
        int len = vector.length;
        float[][] multiByScalar = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                multiByScalar[i][j] = vector[i][j] * scalar;
            }
        }
        return multiByScalar;
    }

    /**
     * @param vector
     * @param scalar
     * @return деление на скаляр
     */
    @Override
    public float[][] divByScalar(float[][] vector, float scalar) {
        int len = vector.length;

        float[][] multiByScalar = new float[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                multiByScalar[i][j] = vector[i][j] / scalar;
            }
        }
        return multiByScalar;
    }

    //Вычисления длины
    public float vectorLength(float[][] vector){
        int len = vector.length;
        float sum = 0;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                sum += vector[i][j] * vector[i][j];
            }
        }
        return (float)Math.sqrt(sum);
    }

    //нормализация
    public float[][] normalization(float[][] vector){
        int len = vector.length;
        float[][] normalizationVector = new float[len][len];
        float vectorLength = vectorLength(vector);

        for (int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                normalizationVector[i][j] = vector[i][j] / vectorLength;
            }
        }
        return normalizationVector;

    }

    //скалярное произведение
    public float scalarMultiplication(float[][] firstVector, float[][] secondVector){
        int len = firstVector.length;
        float scalarMultiplication = 0;

        for(int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                scalarMultiplication += firstVector[i][j] * secondVector[i][j];
            }
        }
        return scalarMultiplication;
    }
}
