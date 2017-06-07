import java.util.*;
public class Trendline { //this class will generate the equation for the trendline for use in the graph class
    public static List<Integer> xValues;
    public static List<Integer> yValues;
    public double sumX;
    public double sumY;
    public double sumXY;
    public double sumXSquared;
    public static double intercept;
    public double size;
    public static double slope;
    public static int yMax;
    public static int yMin;
    public static int xMax;
    public static int xMin;

    public Trendline(List<Integer> yearValues, List<Integer> dataValues){
        this.xValues = yearValues;
        this.yValues = dataValues;
        this.size = xValues.size();
        this.yMax = Collections.max(dataValues);
        this.yMin = Collections.min(dataValues);
        this.xMax = Collections.max(yearValues);
        this.xMin = Collections.min(yearValues);
        calcSumX();
        calcSumY();
        calcSumXY();
        calcSumXSquared();
        calcIntercept();
        calcSlope();
    }
    public void calcSumX(){

        for(int i : xValues){
            sumX+=i;
            //System.out.println(xValues.get(0));
        }
    }

    public void calcSumY(){

        for(int i : yValues){
            sumY+=i;
        }
    }

    public void calcSumXY(){
        for(int i = 0; i<xValues.size(); i++){
            int xVal = xValues.get(i).intValue();
            int yVal = yValues.get(i).intValue();

            //sumXY+=(xValues.get(i)* yValues.get(i));
            sumXY += (xVal * yVal);
        }
    }

    public void calcSumXSquared(){
        for(int i : xValues) {
            sumXSquared += (i * i);
        }
    }

    public void calcIntercept(){
        intercept = (((double)sumY * (double)sumXSquared) - ((double)sumX*(double)sumXY)) /
                ((double)size*((double)sumXSquared) - ((double)sumX*(double)sumX));

    }

    public void calcSlope(){
        slope = ((size*sumXY) - (sumX * sumY)) /
                ((size*sumXSquared) - (sumX * sumX));
    }
}
