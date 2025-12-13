package Math.Matrix;

public class Matrix4 extends Matrix {
    private float value00, value01, value02, value03;
    private float value10, value11, value12, value13;
    private float value20, value21, value22, value23;
    private float value30, value31, value32, value33;

    private float[][] matrix = {
            {value00,value01,value02},
            {value10, value11, value12},
            {value20, value21, value22}
    };

    public Matrix4(float value00, float value01, float value02, float value03,
                   float value10, float value11, float value12, float value13,
                   float value20, float value21, float value22, float value23,
                   float value30, float value31, float value32, float value33
    ){
        this.value00 = value00;
        this.value01 = value01;
        this.value02 = value02;
        this.value03 = value03;
        this.value10 = value10;
        this.value11 = value11;
        this.value12 = value12;
        this.value13 = value13;
        this.value20 = value20;
        this.value21 = value21;
        this.value22 = value22;
        this.value23 = value23;
        this.value30 = value30;
        this.value31 = value31;
        this.value32 = value32;
        this.value33 = value33;
    }
}
