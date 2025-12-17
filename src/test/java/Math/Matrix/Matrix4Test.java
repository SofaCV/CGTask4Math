package Math.Matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix4Test {

    @Test
    void getMatrix() {
        Matrix4 matrix = new Matrix4 (
                6,6,6, 6,
                6,6,6, 6,
                6,6,6, 6,
                6, 6, 6, 6
        );

        float[][] check = {{6,6,6,6}, {6,6,6,6}, {6,6,6,6}, {6,6,6,6}};

        assertEquals(matrix.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(matrix.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(matrix.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(matrix.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(matrix.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(matrix.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(matrix.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(matrix.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(matrix.getMatrix()[2][2], check[2][2], 10e-8);
    }

    @Test
    void add() {
        Matrix4 matrix1 = new Matrix4 (
                2,2,2, 2,
                2,2,2, 2,
                2,2,2, 2,
                2, 2, 2, 2
        );

        Matrix4 matrix2 = new Matrix4 (
                2.5F,2.5F,2.51F, 1.472F,
                2,0,2, 6,
                2,-2,0.5F,6.00006F,
                2,1,1,1.5F
        );

        float[][] check = {{4.5F,4.5F,4.51F, 3.472F}, {4,2,4,8}, {4,0,2.5F, 8.00006F}, {4,3,3,3.5F}};
        Matrix4 res = Matrix4.add(matrix1,matrix2);

        assertEquals(res.getMatrix()[0][0], check[0][0], 0.0001);
        assertEquals(res.getMatrix()[0][1], check[0][1], 0.0001);
        assertEquals(res.getMatrix()[0][2], check[0][2], 0.0001);
        assertEquals(res.getMatrix()[0][3], check[0][3], 0.0001);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);


        //проверка исключения
        Matrix4 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix4.add(matrix3,matrix1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void subtract() {
        Matrix4 matrix1 = new Matrix4 (
                2,2,2, 2,
                2,2,2, 2,
                2,2,2, 2,
                2, 2, 2, 2
        );

        Matrix4 matrix2 = new Matrix4 (
                2.5F,2.5F,2, 1.472F,
                2,0,2, 6,
                2,-2,0.5F,6.00006F,
                2,1,1,1.5F
        );

        float[][] check = {{-0.5F,-0.5F,0, 0.528F}, {0,2,0,-4}, {0,4,1.5F, -4.00006F}, {0,1,1,0.5F}};
        Matrix4 res = Matrix4.subtract(matrix1,matrix2);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);

        //проверка исключения
        Matrix4 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix4.add(matrix3,matrix1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void multiByScalar() {
        Matrix4 matrix = new Matrix4 (
                2,2,2,2,
                2,2,2,2,
                2,2,2,2,
                2,2,2,2
        );
        float scalar = 0.5F;
        float[][] check = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        Matrix4 res = Matrix4.multiByScalar(matrix,scalar);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);

        //проверка исключения
        Matrix4 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix4.multiByScalar(matrix3,5)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void divByScalar() {
        Matrix4 matrix = new Matrix4 (
                2,2,2, 2,
                2,2,2, 2,
                2,2,2, 2,
                2,2,2,2
        );
        float scalar = 0.5F;
        float[][] check = {{4,4,4,4}, {4,4,4,4}, {4,4,4,4}, {4,4,4,4}};
        Matrix4 res = Matrix4.divByScalar(matrix,scalar);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);

        //проверка исключения
        Matrix4 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix4.multiByScalar(matrix3,5)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

        ArithmeticException exception2 = assertThrows(
                ArithmeticException.class,
                () -> Matrix4.divByScalar(matrix,0)
        );

        assertEquals("Деление на ноль невозможно", exception2.getMessage());


    }

    @Test
    void transposition() {
        Matrix4 matrix = new Matrix4(
                1,2,3, 6,
                4,5,6, 9,
                7,8,9,12,
                3,5,7,8
        );

        float[][] check = {{1,4,7,3}, {2,5,8,5},{3,6,9,7}, {6,9,12,8}};

        Matrix4 res = Matrix4.transposition(matrix);
        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);

        //проверка исключения
        Matrix3 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix3.transposition(matrix3)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void identityMatrix() {
        float[][] check = {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        Matrix4 res = Matrix4.identityMatrix();

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);
    }

    @Test
    void zeroMatrix() {
        float[][] check = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
        Matrix4 res = Matrix4.zeroMatrix();

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);
        assertEquals(res.getMatrix()[0][3], check[0][3], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);
        assertEquals(res.getMatrix()[1][3], check[1][3], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
        assertEquals(res.getMatrix()[2][3], check[2][3], 10e-8);

        assertEquals(res.getMatrix()[3][0], check[3][0], 10e-8);
        assertEquals(res.getMatrix()[3][1], check[3][1], 10e-8);
        assertEquals(res.getMatrix()[3][2], check[3][2], 10e-8);
        assertEquals(res.getMatrix()[3][3], check[3][3], 10e-8);
    }
}