import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//todo modifyable graph size

public class Graph extends JPanel{

    
    public double k = 800 / ((double)Trendline.yMax-(double)Trendline.yMin); //this is a value that will scale y values to the 800 pixel y-axis
    public double kx = (800 / ((double)Trendline.xMax-(double)Trendline.xMin));//this is a value that will scale x values to the 800 pixel y-axis

    public void paintComponent(Graphics graphics){ //temporary screen design
        
        super.paintComponent(graphics);
        this.setBackground(Color.BLACK);
        graphics.setColor(Color.white);


        for(double x=Trendline.xMin;x<=Trendline.xMax;x+=0.01) { //Draws a line using the calculated slope and intercept
            double n = (x * Trendline.slope) + Trendline.intercept; //y = mx + b
            //System.out.println("y = " + n);
            int i = (int) (k * (n - Trendline.yMin)); //scales y to 800 pixels
            //System.out.println("constant = "+ k);
            int ix = (int) (kx * (x - Trendline.xMin));//scales x to 800 pixels
            //System.out.println(ix +" " + i);
            graphics.fillRect(ix,800-i,3,3);
        }

        graphics.drawString(("y = "+Trendline.slope+"x + " + Trendline.intercept),350,850);

        for(int i =0; i < Trendline.xValues.size(); i++) {


            double xx = (((double)(Trendline.xValues.get(i)-Trendline.xMin)  * kx));
            int x = (int)xx; //pixel locations must be integers


            double yy = k*(Trendline.yValues.get(i)-Trendline.yMin);
            int y = (int)yy;

            graphics.setColor(Color.red);
            graphics.fillRect(x,800-y,5,5);
            String year = Trendline.xValues.get(i).toString(); 
            String value = Trendline.yValues.get(i).toString();
            graphics.drawString(("("+year+","+value+")"),x, 800-y+15); //label for the data points
        }



    }
}
