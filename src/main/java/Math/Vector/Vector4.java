package Math.Vector;

public class Vector4 extends Vector {
    private float x;
    private float y;
    private float z;
    private float w;
    private float[][] vector = {{x}, {y}, {z}, {w}};


    public Vector4(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public float[][] getVector() {
        return vector;
    }
}
