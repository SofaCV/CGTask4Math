package com.cgvsu.render_engine;
import com.cgvsu.Math.Matrix.Matrix4;
import com.cgvsu.Math.Vector.Vector3;

public class GraphicConveyor {

    public static Matrix4 rotateScaleTranslate() {
        float[] matrix = new float[]{
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1};
        return new Matrix4(matrix);
    }

    public static Matrix4 lookAt(Vector3 eye, Vector3 target) {
        return lookAt(eye, target, new Vector3(0F, 1.0F, 0F));
    }

    //мировая система координат -> система координат камеры
    public static Matrix4 lookAt(Vector3 eye, Vector3 target, Vector3 up) {

        //получаем оси системы координат камеры и сразу их нормализуем
        Vector3 resultZ = (target.subtract(eye)).normalization();
        Vector3 resultX = (up.vectorMult(resultZ)).normalization();
        Vector3 resultY = (resultX.vectorMult(resultZ)).normalization();

        float[] X = resultX.getVector();
        float[] Y = resultY.getVector();
        float[] Z = resultZ.getVector();
        float[] e = eye.getVector();

        //видовая матрица (view matrix)
        return new Matrix4(
                X[0], X[1], X[2], -e[0] * X[0] - e[1] * X[1] - e[2] * X[2],
                Y[0], Y[1], Y[2], -e[0] * Y[0] - e[1] * Y[1] - e[2] * Y[2],
                Z[0], Z[1], Z[2], -e[0] * Z[0] - e[1] * Z[1] - e[2] * Z[2],
                0, 0, 0, 1
        );
    }

    //система координат камеры -> плоскость проецирования
    public static Matrix4 perspective(
            final float fov,
            final float aspectRatio,
            final float nearPlane,
            final float farPlane) {
        Matrix4 result = new Matrix4();
        float tangentMinusOnDegree = (float) (1.0F / (Math.tan(fov * 0.5F)));
        result.m00 = tangentMinusOnDegree / aspectRatio;
        result.m11 = tangentMinusOnDegree;
        result.m22 = (farPlane + nearPlane) / (farPlane - nearPlane);
        result.m23 = 1.0F;
        result.m32 = 2 * (nearPlane * farPlane) / (nearPlane - farPlane);
        return result;
    }

    public static Vector3 multiplyMatrix4ByVector3(final Matrix4 matrix, final Vector3 vertex) {
        final float x = (vertex.x * matrix.m00) + (vertex.y * matrix.m10) + (vertex.z * matrix.m20) + matrix.m30;
        final float y = (vertex.x * matrix.m01) + (vertex.y * matrix.m11) + (vertex.z * matrix.m21) + matrix.m31;
        final float z = (vertex.x * matrix.m02) + (vertex.y * matrix.m12) + (vertex.z * matrix.m22) + matrix.m32;
        final float w = (vertex.x * matrix.m03) + (vertex.y * matrix.m13) + (vertex.z * matrix.m23) + matrix.m33;
        return new Vector3(x / w, y / w, z / w);
    }

    public static Point2f vertexToPoint(final Vector3 vertex, final int width, final int height) {
        return new Point2f(vertex.x * width + width / 2.0F, -vertex.y * height + height / 2.0F);
    }


}
