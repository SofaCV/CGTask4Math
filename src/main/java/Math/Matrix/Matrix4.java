package Math.Matrix;

public class Matrix4 extends Matrix {
    private float value00, value01, value02, value03;
    private float value10, value11, value12, value13;
    private float value20, value21, value22, value23;
    private float value30, value31, value32, value33;

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

    public float[][] getMatrix() {
        return new float[][]{
                {value00,value01,value02, value03},
                {value10, value11, value12, value13},
                {value20, value21, value22, value23},
                {value30, value31, value32, value33}
        };
    }

    //сложение
    public static Matrix4 add(Matrix4 firstMatrix, Matrix4 secondMatrix) {
        checkArguments(firstMatrix);
        checkArguments(secondMatrix);

        float[][] res = Matrix4.add(firstMatrix.getMatrix(),secondMatrix.getMatrix());

        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    //разность
    public static Matrix4 subtract(Matrix4 firstMatrix, Matrix4 secondMatrix) {
        checkArguments(firstMatrix);
        checkArguments(secondMatrix);

        float[][] res = Matrix4.subtract(firstMatrix.getMatrix(),secondMatrix.getMatrix());

        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    //умножение на скаляр
    public static Matrix4 multiByScalar(Matrix4 matrix, float scalar) {
        checkArguments(matrix);

        float[][] res = Matrix4.divByScalar(matrix.getMatrix(),scalar);

        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    //деление на скаляр
    public static Matrix4 divByScalar(Matrix4 matrix, float scalar) {
        checkArguments(matrix);
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        float[][] res = Matrix4.divByScalar(matrix.getMatrix(),scalar);

        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    //транспонирование
    public static Matrix4 transposition(Matrix4 matrix) {
        checkArguments(matrix);
        float[][] res = Matrix4.transposition(matrix.getMatrix());

        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    //единичная матрица
    public static Matrix4 identityMatrix(int row, int col) {
        return new Matrix4(
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1,
                1, 1, 1, 1
        );
    }

    //нулевая матрица
    public static Matrix4 zeroMatrix(int row, int col) {
        return new Matrix4(
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0
        );
    }

    //исключения на проверку входных данных
    private static void checkArguments(Matrix4 matrix){
        if (matrix == null) {
            throw new IllegalArgumentException("аргумент не может быть null");
        }
    }
}
