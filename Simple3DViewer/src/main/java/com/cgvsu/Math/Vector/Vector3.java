package Math.Vector;

public class Vector3 extends Vector<Vector3>{

    public Vector3(float x, float y, float z){
        super(new float[]{x, y, z});
    }

    /**
     * @param result
     * @return создаю и возвращаю объект Vector3
     */
    @Override
    public Vector3 createNewVector(float[] result) {
        if (result.length != 3){
            throw new IllegalArgumentException("Ошибка в количестве координат. Трехмерный вектор имеет 3 координаты");
        }
        return new Vector3(result[0], result[1], result[2]);
    }

    //векторное произведение
    public Vector3 vectorMult(Vector3 argument) {
        float[] vector1 = this.getVector();
        float[] vector2 = argument.getVector();

        float[] result = new float[3];
        result[0] = vector1[1] * vector2[2] - vector1[2] * vector2[1]; // x-компонента
        result[1] = vector1[2] * vector2[0] - vector1[0] * vector2[2]; // y-компонента
        result[2] = vector1[0] * vector2[1] - vector1[1] * vector2[0]; // z-компонента

        return createNewVector(result);
    }
}
