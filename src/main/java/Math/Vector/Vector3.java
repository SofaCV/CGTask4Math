package Math.Vector;

public class Vector3 extends Vector {
    private float x;
    private float y;
    private float z;
    private float[][] vector = {{x}, {y}, {z}};

    public Vector3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float[][] getVector() {
        return vector;
    }

    //векторное произведение
    public float[][] vectorMultiplication(){
        float[][] vectorMultiplication = new float[3][1];

        return vectorMultiplication;
    }
}
