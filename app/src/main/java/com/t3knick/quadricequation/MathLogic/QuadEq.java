package com.t3knick.quadricequation.MathLogic;

public class QuadEq {

    private double a = 0;
    private double b = 0;
    private double c = 0;

    private double dis = 0; // Дискриминант

    private double x1 = 0; // Корень 1
    private double x2 = 0; // Корень 2



    public QuadEq(double a, double b, double c){ // Конструктор
        this.a = a;
        this.b = b;
        this.c = c;
        solve();
    }

    public void solve(){
        this.dis = (b*b) - 4 * a * c; //Считаем дискриминант

        if (dis == 0){
            x1 = (-b/(2*a));

        }else if (dis > 0){
            x1 = ((-b + Math.sqrt(dis)) / (2 * a));
            x2 = ((-b - Math.sqrt(dis)) / (2 * a));

        }
    }



    //Getters area Below
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDis() {
        return dis;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

}
