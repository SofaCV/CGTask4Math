package com.cgvsu.render_engine;

import com.cgvsu.Math.Matrix.Matrix4;
import com.cgvsu.Math.Vector.Vector3;
import com.cgvsu.Math.Vector.Vector4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphicConveyorTest {

    @Test
    void rotateScaleTranslate() {
        Vector3 scale = new Vector3(2,1,-5);
        Vector3 target = new Vector3(2, 0, -6);
        Vector3 rotation = new Vector3(0,0,0);

        Vector3 scaleIdenty = new Vector3(1,1,1);
        Vector3 targetNull = new Vector3(0,0,0);

        Vector4 vector = new Vector4(1,0,-5,1);

        Matrix4 matrix1 = GraphicConveyor.rotateScaleTranslate(scale,rotation,targetNull);
        Matrix4 matrix2 = GraphicConveyor.rotateScaleTranslate(scaleIdenty,rotation,target);

        Vector4 check1 = matrix1.multiplyByVector(vector);
        Vector4 check2 = matrix2.multiplyByVector(vector);

        //ситуация, когда модель только перемещается
        assertEquals(check2.getX(), 3, 10e-8);
        assertEquals(check2.getY(), 0, 10e-8);
        assertEquals(check2.getZ(), -11, 10e-8);

        //ситуация, когда модель только масштабируется
        assertEquals(check1.getX(), 2, 10e-8);
        assertEquals(check1.getY(), 0, 10e-8);
        assertEquals(check1.getZ(), 25, 10e-8);

        //проверка исключения
        Vector3 vector1 = null;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.rotateScaleTranslate(vector1,vector1,vector1)
        );
        assertEquals("аргумент не может быть null", exception.getMessage());

    }

    @Test
    void lookAt() {
        //проверка исключения
        Vector3 vector = null;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.lookAt(vector, vector)
        );
        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void testLookAt() {
        //проверка исключения
        Vector3 eye = new Vector3(1,2,3);
        Vector3 target = new Vector3(1,2,3);
        Vector3 vector = null;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.lookAt(eye,target,vector)
        );
        assertEquals("аргумент не может быть null", exception.getMessage());
    }

    @Test
    void translationMatrix(){
        Vector3 translation = new Vector3(2,4,5);
        float[][] scaleMatrix = (GraphicConveyor.translationMatrix(translation)).getMatrix();

        assertEquals(scaleMatrix[0][0], 1, 10e-8);
        assertEquals(scaleMatrix[0][1], 0, 10e-8);
        assertEquals(scaleMatrix[0][2], 0, 10e-8);
        assertEquals(scaleMatrix[0][3], 2, 10e-8);
        assertEquals(scaleMatrix[1][0], 0, 10e-8);
        assertEquals(scaleMatrix[1][1], 1, 10e-8);
        assertEquals(scaleMatrix[1][2], 0, 10e-8);
        assertEquals(scaleMatrix[1][3], 4, 10e-8);
        assertEquals(scaleMatrix[2][0], 0, 10e-8);
        assertEquals(scaleMatrix[2][1], 0, 10e-8);
        assertEquals(scaleMatrix[2][2], 1, 10e-8);
        assertEquals(scaleMatrix[2][3], 5, 10e-8);
        assertEquals(scaleMatrix[3][0], 0, 10e-8);
        assertEquals(scaleMatrix[3][1], 0, 10e-8);
        assertEquals(scaleMatrix[3][2], 0, 10e-8);
        assertEquals(scaleMatrix[3][3], 1, 10e-8);
    }
     @Test
     void rotationMatrix(){
        //когда углы поворота 0, то и модель не поворачивается, значит, матрица поворота должна быть единичной
         Vector3 translation = new Vector3(0,0,0);
         float[][] scaleMatrix = (GraphicConveyor.translationMatrix(translation)).getMatrix();

         assertEquals(scaleMatrix[0][0], 1, 10e-8);
         assertEquals(scaleMatrix[0][1], 0, 10e-8);
         assertEquals(scaleMatrix[0][2], 0, 10e-8);
         assertEquals(scaleMatrix[0][3], 0, 10e-8);
         assertEquals(scaleMatrix[1][0], 0, 10e-8);
         assertEquals(scaleMatrix[1][1], 1, 10e-8);
         assertEquals(scaleMatrix[1][2], 0, 10e-8);
         assertEquals(scaleMatrix[1][3], 0, 10e-8);
         assertEquals(scaleMatrix[2][0], 0, 10e-8);
         assertEquals(scaleMatrix[2][1], 0, 10e-8);
         assertEquals(scaleMatrix[2][2], 1, 10e-8);
         assertEquals(scaleMatrix[2][3], 0, 10e-8);
         assertEquals(scaleMatrix[3][0], 0, 10e-8);
         assertEquals(scaleMatrix[3][1], 0, 10e-8);
         assertEquals(scaleMatrix[3][2], 0, 10e-8);
         assertEquals(scaleMatrix[3][3], 1, 10e-8);
     }

    @Test
    void scaleMatrix(){
        Vector3 scale = new Vector3(2,4,5);
        float[][] scaleMatrix = (GraphicConveyor.scaleMatrix(scale)).getMatrix();

        assertEquals(scaleMatrix[0][0], 2, 10e-8);
        assertEquals(scaleMatrix[0][1], 0, 10e-8);
        assertEquals(scaleMatrix[0][2], 0, 10e-8);
        assertEquals(scaleMatrix[0][3], 0, 10e-8);
        assertEquals(scaleMatrix[1][0], 0, 10e-8);
        assertEquals(scaleMatrix[1][1], 4, 10e-8);
        assertEquals(scaleMatrix[1][2], 0, 10e-8);
        assertEquals(scaleMatrix[1][3], 0, 10e-8);
        assertEquals(scaleMatrix[2][0], 0, 10e-8);
        assertEquals(scaleMatrix[2][1], 0, 10e-8);
        assertEquals(scaleMatrix[2][2], 5, 10e-8);
        assertEquals(scaleMatrix[2][3], 0, 10e-8);
        assertEquals(scaleMatrix[3][0], 0, 10e-8);
        assertEquals(scaleMatrix[3][1], 0, 10e-8);
        assertEquals(scaleMatrix[3][2], 0, 10e-8);
        assertEquals(scaleMatrix[3][3], 1, 10e-8);

        //проверка исключения
        Vector3 vector1 = new Vector3(0,1,1);
        Vector3 vector2 = new Vector3(1,0,1);
        Vector3 vector3 = new Vector3(1,1,0);
        IllegalArgumentException exception1 = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.scaleMatrix(vector1)
        );
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.scaleMatrix(vector2)
        );
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> GraphicConveyor.scaleMatrix(vector3)
        );
        assertEquals("коэффициент масштабирования не может быть 0", exception1.getMessage());
        assertEquals("коэффициент масштабирования не может быть 0", exception2.getMessage());
        assertEquals("коэффициент масштабирования не может быть 0", exception3.getMessage());


    }
}