package task1;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class ArcCosFunction {
    public static double arcCos(double x){
        if (Math.abs(x) > 1){
            return Double.NaN;
        }

        int step = 1;
        double curElem = 1;
        double seriesSum = 0;

        while (curElem > 0.00001){
            curElem = Math.pow(x, step) / calculateFactorial(step);
            seriesSum += curElem;
            step += 2;
        }
        return Math.PI / 2 - seriesSum;
    }

    static int calculateFactorial(int n){
        if(n < 0){
            return 0;
        }

        int result = 1;
        for (int i = 1; i <= n; i ++){
            result = result * i;
        }

        return result;
    }
}
