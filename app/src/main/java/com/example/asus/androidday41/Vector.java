package com.example.asus.androidday41;



/**
 * Vector
 *
 * @author: ASUS
 * @time: 2016/1/22 14:17
 */
public class Vector {
    public float x;
    public float y;

    public Vector() {

    }

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //向量加法
    public Vector add(Vector vector) {
        x += vector.x;
        y += vector.y;
        return this;
    }

    public static Vector add(Vector v1,Vector v2){
        return new Vector(v1.x+v2.x,v1.y+v2.y);
    }


    public Vector jian(Vector vector) {
        x -= vector.x;
        y -= vector.y;
        return this;
    }

    public  static  Vector jian(Vector v1,Vector v2){
        return new Vector(v1.x-v2.x,v1.y-v2.y);
    }

    public Vector mutiply(float t) {
        x *= t;
        y *= t;
        return this;
    }

    public Vector chu(float t) {
        if (t != 0) {
            x /= t;
            y /= t;

        }
        return this;
    }

    public void normalize(){
        chu(qiumo());
    }

    public float qiumo(){
        return (float)Math.sqrt(x*x+y*y);
    }

    public void limit(float max){
        if((max*max)<(qiumo()*qiumo())){
            normalize();
            mutiply(max);
        }
    }

}
