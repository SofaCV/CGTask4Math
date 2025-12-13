package Math.Matrix;

public class Matrix3 extends Matrix {
    private float value00, value01, value02;
    private float value10, value11, value12;
    private float value20, value21, value22;

    private float[][] matrix = {
            {value00,value01,value02},
            {value10, value11, value12},
            {value20, value21, value22}
    };

    public Matrix3(float value00, float value01, float value02,
                   float value10, float value11, float value12,
                   float value20, float value21, float value22
                   ){
        this.value00 = value00;
        this.value01 = value01;
        this.value02 = value02;
        this.value10 = value10;
        this.value11 = value11;
        this.value12 = value12;
        this.value20 = value20;
        this.value21 = value21;
        this.value22 = value22;
    }

    public float[][] getMatrix() {
        return matrix;
    }
}
