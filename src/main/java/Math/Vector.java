package Math;

public class Vector implements MatrixAndVector{
    private final int row;
    private final int col = 1;

    public Vector(int row){
        this.row = row;
    }

    /**
     * @param firstVector
     * @param secondVector
     * @return
     */
    @Override
    public float[][] add(float[][] firstVector, float[][] secondVector) {
        float[][] add = new float[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                add[i][j] = firstVector[i][j] + secondVector[i][j];
            }
        }
        return add;
    }

    /**
     * @param firstVector
     * @param secondVector
     * @return
     */
    @Override
    public float[][] subtract(float[][] firstVector, float[][] secondVector) {
        float[][] subtract = new float[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                subtract[i][j] = firstVector[i][j] - secondVector[i][j];
            }
        }
        return subtract;
    }

    /**
     * @param vector
     * @param scalar
     * @return
     */
    @Override
    public float[][] multiByScalar(float[][] vector, float scalar) {
        float[][] multiByScalar = new float[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                multiByScalar[i][j] = vector[i][j] - scalar;
            }
        }
        return multiByScalar;
    }

    //Вычисления длины
    public float vectorLength(float[][] vector){
        float sum = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                sum += vector[i][j] * vector[i][j];
            }
        }
        return (float)Math.sqrt(sum);
    }

    //нормализация
    public float[][] normalization(float[][] vector){
        float[][] normalizationVector = new float[row][col];
        float vectorLength = vectorLength(vector);

        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                normalizationVector[i][j] = vector[i][j] / vectorLength;
            }
        }
        return normalizationVector;

    }

    //скалярное произведение
    public float scalarMultiplication(float[][] firstVector, float[][] secondVector){
        float scalarMultiplication = 0;
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                scalarMultiplication += firstVector[i][j] * secondVector[i][j];
            }
        }
        return scalarMultiplication;
    }
}
