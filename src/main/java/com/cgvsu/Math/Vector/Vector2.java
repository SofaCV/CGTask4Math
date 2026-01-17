package com.cgvsu.Math.Vector;

public class Vector2 extends Vector<Vector2>{

    public Vector2(float x, float y){
        super(new float[]{x, y});
    }

    public float getX() {
        return super.getVector()[0];
    }

    public float getY(){
        return super.getVector()[1];
    };

    /**
     * @param result
     * @return создаю и возвращаю объект Vector2
     */
    @Override
    public Vector2 createNewVector(float[] result) {
        if (result.length != 2){
            throw new IllegalArgumentException("Ошибка в количестве координат. Двумерный вектор имеет 2 координаты");
        }
        return new Vector2(result[0], result[1]);
    }
}
