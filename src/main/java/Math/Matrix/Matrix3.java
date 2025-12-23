package Math.Matrix;

public class Matrix3 {
    private final float value00, value01, value02;
    private final float value10, value11, value12;
    private final float value20, value21, value22;

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
        return new float[][]{
                {value00,value01,value02},
                {value10, value11, value12},
                {value20, value21, value22}
        };
    }

    //сложение
    public static Matrix3 add(Matrix3 firstMatrix, Matrix3 secondMatrix) {
        checkArguments(firstMatrix);
        checkArguments(secondMatrix);

        float[][] res = Matrix.add(firstMatrix.getMatrix(),secondMatrix.getMatrix());
        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    //разность
    public static Matrix3 subtract(Matrix3 firstMatrix, Matrix3 secondMatrix) {
        checkArguments(firstMatrix);
        checkArguments(secondMatrix);

        float[][] res = Matrix.subtract(firstMatrix.getMatrix(),secondMatrix.getMatrix());
        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    //умножение на скаляр
    public static Matrix3 multiByScalar(Matrix3 matrix, float scalar) {
        checkArguments(matrix);
        float[][] res = Matrix.multiByScalar(matrix.getMatrix(),scalar);

        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    //деление на скаляр
    public static Matrix3 divByScalar(Matrix3 matrix, float scalar) {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на ноль невозможно");
        }
        checkArguments(matrix);
        float[][] res = Matrix.divByScalar(matrix.getMatrix(),scalar);

        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    //транспонирование
    public static Matrix3 transposition(Matrix3 matrix) {
        checkArguments(matrix);
        float[][] res = Matrix.transposition(matrix.getMatrix());

        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    //единичная матрица
    public static Matrix3 identityMatrix() {
        return new Matrix3(
                1, 1, 1,
                1, 1, 1,
                1, 1, 1
        );
    }

    //нулевая матрица
    public static Matrix3 zeroMatrix() {
        return new Matrix3(
                0, 0, 0,
                0, 0, 0,
                0, 0, 0
        );
    }

    //исключения на проверку входных данных
    private static void checkArguments(Matrix3 matrix){
        if (matrix == null) {
            throw new IllegalArgumentException("аргумент не может быть null");
        }
    }
}
