package Math.Vector;

public class Vector2 extends Vector<Vector2>{

    public Vector2(float x, float y){
        super(new float[]{x, y});
    }

    /**
     * @param result
     * @return
     */
    @Override
    public Vector2 createNewVector(float[] result) {
        return new Vector2(result[0], result[1]);
    }
}
