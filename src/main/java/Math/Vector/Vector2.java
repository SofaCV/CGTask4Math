package Math.Vector;

public class Vector2 extends Vector {
    private float x;
    private float y;
    private float[][] vector = {{x}, {y}};

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[][] getVector() {
        return vector;
    }
}
