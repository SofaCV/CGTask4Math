package Math.Matrix;

import Math.Vector.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3Test {

    @Test
    void getMatrix() {
        Matrix3 matrix = new Matrix3 (
                6,6,6,
                6,6,6,
                6,6,6
        );

        float[][] check = {{6,6,6}, {6,6,6}, {6,6,6}};

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
        Matrix3 matrix1 = new Matrix3 (
                2,2,2,
                2,2,2,
                2,2,2
        );

        Matrix3 matrix2 = new Matrix3 (
                2.5F,2.5F,2.51F,
                2,0,2,
                2,2,0.5F
        );

        float[][] check = {{4.5F,4.5F,4.51F}, {4,2,4}, {4,4,2.5F}};
        Matrix3 res = Matrix3.add(matrix1,matrix2);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);

        //проверка исключения
        Matrix3 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix3.add(matrix3,matrix1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void subtract() {
        Matrix3 matrix1 = new Matrix3 (
                2,2,2,
                2,2,2,
                2,2,2
        );

        Matrix3 matrix2 = new Matrix3 (
                2.5F,2.5F,2F,
                -3.5F,0,2,
                2,2,0.5F
        );

        float[][] check = {{-0.5F,-0.5F,0}, {5.5F,2,0}, {0,0,1.5F}};
        Matrix3 res = Matrix3.subtract(matrix1,matrix2);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);

        //проверка исключения
        Matrix3 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix3.add(matrix3,matrix1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void multiByScalar() {
        Matrix3 matrix = new Matrix3 (
                2,2,2,
                2,2,2,
                2,2,2
        );
        float scalar = 0.5F;
        float[][] check = {{1,1,1}, {1,1,1}, {1,1,1}};
        Matrix3 res = Matrix3.multiByScalar(matrix,scalar);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);

        //проверка исключения
        Matrix3 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix3.multiByScalar(matrix3,5)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void divByScalar() {
        Matrix3 matrix = new Matrix3 (
                2,2,2,
                2,2,2,
                2,2,2
        );
        float scalar = 0.5F;
        float[][] check = {{4,4,4}, {4,4,4}, {4,4,4}};
        Matrix3 res = Matrix3.divByScalar(matrix,scalar);

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);

        //проверка исключения
        Matrix3 matrix3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Matrix3.multiByScalar(matrix3,5)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

        ArithmeticException exception2 = assertThrows(
                ArithmeticException.class,
                () -> Matrix3.divByScalar(matrix,0)
        );

        assertEquals("Деление на ноль невозможно", exception2.getMessage());


    }

    @Test
    void transposition() {
        Matrix3 matrix = new Matrix3(
                1,2,3,
                4,5,6,
                7,8,9
        );

        float[][] check = {{1,4,7}, {2,5,8}, {3,6,9}};

        Matrix3 res = Matrix3.transposition(matrix);
        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);

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
        float[][] check = {{1,1,1}, {1,1,1}, {1,1,1}};
        Matrix3 res = Matrix3.identityMatrix();

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
    }

    @Test
    void zeroMatrix() {
        float[][] check = {{0,0,0}, {0,0,0}, {0,0,0}};
        Matrix3 res = Matrix3.zeroMatrix();

        assertEquals(res.getMatrix()[0][0], check[0][0], 10e-8);
        assertEquals(res.getMatrix()[0][1], check[0][1], 10e-8);
        assertEquals(res.getMatrix()[0][2], check[0][2], 10e-8);

        assertEquals(res.getMatrix()[1][0], check[1][0], 10e-8);
        assertEquals(res.getMatrix()[1][1], check[1][1], 10e-8);
        assertEquals(res.getMatrix()[1][2], check[1][2], 10e-8);

        assertEquals(res.getMatrix()[2][0], check[2][0], 10e-8);
        assertEquals(res.getMatrix()[2][1], check[2][1], 10e-8);
        assertEquals(res.getMatrix()[2][2], check[2][2], 10e-8);
    }
}