package Math.Vector;

public class Vector4 extends Vector<Vector4>{

    public Vector4(float x, float y, float z, float w){
        super(new float[]{x, y, z, w});
    }

    /**
     * @param result
     * @return создаю и возвращаю объект Vector4
     */
    @Override
    public Vector4 createNewVector(float[] result) {
        if (result.length != 4){
            throw new IllegalArgumentException("Ошибка в количестве координат. Четырехмерный вектор имеет 4 координаты");
        }
        return new Vector4(result[0], result[1], result[2], result[3]);
    }
}
