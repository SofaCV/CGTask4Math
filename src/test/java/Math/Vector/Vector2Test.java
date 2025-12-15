package Math.Vector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {

    @Test
    void getVector() {
        Vector2 vector2 = new Vector2(2.5F,5.6F);
        float[][] vector = {{2.5F}, {5.6F}};

        assertEquals(vector[0][0], vector2.getVector()[0][0], 10e-8);
        assertEquals(vector[1][0], vector2.getVector()[1][0], 10e-8);
    }

    @Test
    void add() {
        Vector2 vector1 = new Vector2(2.5F,5.6F);
        Vector2 vector2 = new Vector2(2.5F,5.6F);
        float[][] vector = {{5}, {11.2F}};
        Vector2 check = Vector2.add(vector1,vector2);

        assertEquals(check.getVector()[0][0], vector[0][0],10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0], 10e-8);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.add(vector3,vector2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

    }

    @Test
    void subtract() {
        Vector2 vector1 = new Vector2(5,11.2F);
        Vector2 vector2 = new Vector2(2.5F,5.6F);
        float[][] vector = {{2.5F}, {5.6F}};
        Vector2 check = Vector2.subtract(vector1,vector2);

        assertEquals(check.getVector()[0][0], vector[0][0],10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0],10e-8);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.subtract(vector3,vector2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void multiByScalar() {
        Vector2 vector1 = new Vector2(2,3);
        float[][] vector = {{4}, {6}};
        Vector2 check = Vector2.multiByScalar(vector1,2);

        assertEquals(vector[0][0], check.getVector()[0][0], 10e-8);
        assertEquals(vector[1][0], check.getVector()[1][0], 10e-8);

        Vector2 check1 = Vector2.multiByScalar(vector1,0);
        float[][] vector2 = {{0}, {0}};
        assertEquals(check1.getVector()[0][0], vector2[0][0], 10e-8);
        assertEquals(check1.getVector()[1][0], vector2[1][0], 10e-8);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.multiByScalar(vector3,2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

    }

    @Test
    void divByScalar() {
        Vector2 vector1 = new Vector2(4.2F,8.8F);
        float[][] vector = {{2.1F}, {4.4F}};
        Vector2 check = Vector2.divByScalar(vector1,2);

        assertEquals(check.getVector()[0][0], vector[0][0], 10e-8);
        assertEquals(check.getVector()[1][0], vector[1][0], 10e-8);

        //проверка исключений
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.divByScalar(vector3,2)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());

        ArithmeticException exception1 = assertThrows(
                ArithmeticException.class,
                () -> Vector2.divByScalar(vector1,0)
        );

        assertEquals("Деление на ноль невозможно", exception1.getMessage());
    }

    @Test
    void vectorLength() {
        Vector2 vector1 = new Vector2(2.5F,3.8F);
        float length = 4.54863F;

        assertEquals(Vector2.vectorLength(vector1), length, 0.00001);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.vectorLength(vector3)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void normalization() {
        Vector2 vector1 = new Vector2(3,4);
        float[][] normalization = {{0.6f}, {0.8f}};

        Vector2 check = Vector2.normalization(vector1);

        assertEquals(check.getVector()[0][0], normalization[0][0], 0.00001);
        assertEquals(check.getVector()[1][0], normalization[1][0], 0.00001);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.normalization(vector3)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void scalarMultiplication() {
        Vector2 vector1 = new Vector2(2,3);
        Vector2 vector2 = new Vector2(3,2);

        float vector = 12;

        float check = Vector2.scalarMultiplication(vector1,vector2);

        assertEquals(check, vector, 10e-8);

        //проверка исключения
        Vector2 vector3 = null;

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Vector2.scalarMultiplication(vector3,vector1)
        );

        assertEquals("аргумент не может быть null", exception.getMessage());
    }
}