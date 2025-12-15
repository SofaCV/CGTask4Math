package Math.Vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector4Test {
    @Test
    void getVector() {
        Vector4 vector2 = new Vector4(2.5F,5.6F, 6.9F, 1);
        float[][] vector = {{2.5F}, {5.6F}, {6.9F}, {1}};

        assertEquals(vector2.getVector()[0][0], vector[0][0], 10e-8);
        assertEquals(vector2.getVector()[1][0], vector[1][0],10e-8);
        assertEquals(vector2.getVector()[2][0], vector[2][0], 10e-8);
        assertEquals(vector2.getVector()[3][0], vector[3][0], 10e-8);
    }

    @Test
    void add() {
        Vector4 vector1 = new Vector4(2.5F,5.6F, 2, 0.5F);
        Vector4 vector2 = new Vector4(2.5F,5.6F, 2, 0.5F);
        float[][] vector = {{5}, {11.2F}, {4}, {1}};
        Vector4 check = Vector4.add(vector1,vector2);

        assertEquals(check.getVector()[0][0], vector[0][0],10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0], 10e-8);
        assertEquals(check.getVector()[2][0], vector[2][0], 10e-8);
        assertEquals(check.getVector()[3][0], vector[3][0], 10e-8);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.add(vector3,vector2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

    }

    @Test
    void subtract() {
        Vector4 vector1 = new Vector4(5,11.2F, 4, 1);
        Vector4 vector2 = new Vector4(2.5F,5.6F, 2,1);
        float[][] vector = {{2.5F}, {5.6F}, {2}, {0}};
        Vector4 check = Vector4.subtract(vector1,vector2);

        assertEquals(check.getVector()[0][0], vector[0][0],10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0],10e-8);
        assertEquals(check.getVector()[2][0], vector[2][0], 10e-8);
        assertEquals(check.getVector()[3][0], vector[3][0], 10e-8);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.subtract(vector3,vector2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void multiByScalar() {
        Vector4 vector1 = new Vector4(2,3, 4, 1);
        float[][] vector = {{4}, {6}, {8}, {2}};
        Vector4 check = Vector4.multiByScalar(vector1,2);

        assertEquals(check.getVector()[0][0], vector[0][0], 10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0], 10e-8);
        assertEquals(check.getVector()[2][0], vector[2][0], 10e-8);
        assertEquals(check.getVector()[3][0], vector[3][0], 10e-8);

        Vector4 check1 = Vector4.multiByScalar(vector1,0);
        float[][] vector2 = {{0}, {0}, {0}, {0}};

        assertEquals(check1.getVector()[0][0], vector2[0][0], 10e-8);
        assertEquals(check1.getVector()[1][0], vector2[1][0], 10e-8);
        assertEquals(check1.getVector()[2][0], vector2[2][0], 10e-8);
        assertEquals(check1.getVector()[3][0], vector2[3][0], 10e-8);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.multiByScalar(vector3,2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

    }

    @Test
    void divByScalar() {
        Vector4 vector1 = new Vector4(4.2F,8.8F, 12.6F, 16.4F);
        float[][] vector = {{2.1F}, {4.4F}, {6.3F}, {8.2F}};
        Vector4 check = Vector4.divByScalar(vector1,2);

        assertEquals(check.getVector()[0][0], vector[0][0], 10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0], 10e-8);
        assertEquals(check.getVector()[2][0], vector[2][0], 10e-8);
        assertEquals(check.getVector()[3][0], vector[3][0], 10e-8);

        //проверка исключений
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.divByScalar(vector3,2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

        ArithmeticException exception1 = assertThrows(
                ArithmeticException.class,
                () -> Vector4.divByScalar(vector1,0)
        );

        assertEquals("Деление на ноль невозможно", exception1.getMessage());
    }

    @Test
    void vectorLength() {
        Vector4 vector1 = new Vector4(2.5F,3.8F, 2.4F, 6);
        float length = 7.90253F;

        assertEquals(Vector4.vectorLength(vector1), length, 0.00001);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.vectorLength(vector3)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void normalization() {
        Vector4 vector1 = new Vector4(3,4, 1, 4.5F);
        float[][] normalization = {{0.44112f}, {0.58817f}, {0.14704F}, {0.66169F}};

        Vector4 check = Vector4.normalization(vector1);

        assertEquals(check.getVector()[0][0], normalization[0][0], 0.00001);
        assertEquals(check.getVector()[1][0], normalization[1][0], 0.00001);
        assertEquals(check.getVector()[2][0], normalization[2][0], 0.00001);
        assertEquals(check.getVector()[3][0], normalization[3][0], 0.00001);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.normalization(vector3)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void scalarMultiplication() {
        Vector4 vector1 = new Vector4(2,3,1, 7.5F);
        Vector4 vector2 = new Vector4(3,2,1, 2);

        float vector = 28;

        float check = Vector4.scalarMultiplication(vector1,vector2);

        assertEquals(check, vector, 10e-8);

        //проверка исключения
        Vector4 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector4.scalarMultiplication(vector3,vector1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }
}