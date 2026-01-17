package com.cgvsu.Math.Matrix;

import com.cgvsu.Math.Vector.Vector;
import com.cgvsu.Math.Vector.Vector4;

public class Matrix4 extends Matrix<Matrix4>{

    public Matrix4(float value00, float value01, float value02, float value03,
                   float value10, float value11, float value12, float value13,
                   float value20, float value21, float value22, float value23,
                   float value30, float value31, float value32, float value33
    ){
       super(new float[][]{
               {value00, value01, value02, value03},
               {value10, value11, value12, value13},
               {value20, value21, value22, value23},
               {value30, value31, value32, value33}
       });
    }

    /**
     * @param res
     * @return возвращаем объект Matrix4
     */
    @Override
    public Matrix4 createNewMatrix(float[][] res) {
        if (res.length != 4 || res[0].length != 4){
            throw new IllegalArgumentException("Ошибка в количестве аргументов. Четырехмерная матрица содержит 16 элементов");
        }
        return new Matrix4(
                res[0][0], res[0][1], res[0][2], res[0][3],
                res[1][0], res[1][1], res[1][2], res[1][3],
                res[2][0], res[2][1], res[2][2], res[2][3],
                res[3][0], res[3][1], res[3][2], res[3][3]
        );
    }

    /**
     * @param vector
     * @return создаю и возвращаю объект Vector4
     */
    @Override
    public <V extends Vector<V>> V createVector(float[] vector) {
        if (vector.length != 4){
            throw new IllegalArgumentException("Ошибка в количестве координат. Четырехмерный вектор имеет 4 координаты");
        }
        return (V)new Vector4(vector[0], vector[1], vector[2], vector[3]);
    }

    public static Matrix4 identityMatrix() {

        return new Matrix4(
                1,1,1,1,
                1,1,1,1,
                1,1,1,1,
                1,1,1,1
        );
    }

    public static Matrix4 zeroMatrix() {

        return new Matrix4(
                0,0,0,0,
                0,0,0,0,
                0,0,0,0,
                0,0,0,0
        );
    }
}
