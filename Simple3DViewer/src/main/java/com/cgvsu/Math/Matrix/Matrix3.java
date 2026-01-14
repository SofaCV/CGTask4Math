package com.cgvsu.Math.Matrix;

import com.cgvsu.Math.Vector.Vector;
import com.cgvsu.Math.Vector.Vector3;

public class Matrix3 extends Matrix<Matrix3>{

    public Matrix3(float value00, float value01, float value02,
                   float value10, float value11, float value12,
                   float value20, float value21, float value22
                   ){
        super(new float[][]{
                {value00, value01, value02},
                {value10, value11, value12},
                {value20, value21, value22}
        });
    }

    /**
     * @param res
     * @return создаю и возвращаю объект Matrix3
     */
    @Override
    public Matrix3 createNewMatrix(float[][] res) {
        if (res.length != 3 || res[0].length != 3){
            throw new IllegalArgumentException("Ошибка в количестве аргументов. Трехмерная матрица содержит 9 элементов");
        }
        return new Matrix3(
                res[0][0], res[0][1], res[0][2],
                res[1][0], res[1][1], res[1][2],
                res[2][0], res[2][1], res[2][2]
        );
    }

    /**
     * @param vector
     * @return создаю и возвращаю объект Vector3
     */
    @Override
    public <V extends Vector<V>> V createVector(float[] vector) {
        if (vector.length != 3){
            throw new IllegalArgumentException("Ошибка в количестве координат. Трехмерный вектор имеет 3 координаты");
        }
        return (V) new Vector3(vector[0], vector[1], vector[2]);
    }

    public static Matrix3 identityMatrix() {

        return new Matrix3(
                1,1,1,
                1,1,1,
                1,1,1
        );
    }

    public static Matrix3 zeroMatrix() {

        return new Matrix3(
                0,0,0,
                0,0,0,
                0,0,0
        );
    }
}
