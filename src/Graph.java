import java.awt.*;
import javax.swing.*;

//todo modifyable graph size

public class Graph extends JPanel{
    int WIDTH = 950;
    int HEIGHT = 950;

    private Font pointFont= new Font("SansSerif",Font.PLAIN, 18);
    private Font dataFont = new Font("Verdana", Font.PLAIN, 25);

    public Trendline trend = null;
    public double k = HEIGHT / ((double)Trendline.yMax-(double)Trendline.yMin); //this is a value that will scale y values to the 800 pixel y-axis
    public double kx = (WIDTH / ((double)Trendline.xMax-(double)Trendline.xMin));//this is a value that will scale x values to the 800 pixel y-axis

    public Graph(Trendline tl){
        trend = tl;
    }

    public void paintComponent(Graphics graphics){ //temporary screen design

        super.paintComponent(graphics);
        this.setBackground(Color.black);
        graphics.setColor(Color.red);

        //Draws a line using the calculated slope and intercept
        for(double x=Trendline.xMin;x<=Trendline.xMax;x+=0.01) {
            double n = (x * Trendline.slope) + Trendline.intercept; //y = mx + b
            //System.out.println("y = " + n);
            int i = (int) (k * (n - Trendline.yMin)); //scales y to 800 pixels
            //System.out.println("constant = "+ k);
            int ix = (int) (kx * (x - Trendline.xMin));//scales x to 800 pixels
            //System.out.println(ix +" " + i);
            graphics.fillRect(ix+3,HEIGHT-i-3,2,2);
        }

        //Draws the border lines at side and bottom of the screen
        graphics.setColor(Color.white);
        for(int i = 0; i <= WIDTH; i++){
            graphics.fillRect(3,i-3,3,3);
            graphics.fillRect(i+3,HEIGHT-3,3,3);

        }

        //Prints the calculated data to the right of the graph
        graphics.setFont(dataFont);
        graphics.drawString(Tester.dataTitle, WIDTH + 60, 250);
        graphics.drawString(("y = "+Trendline.slope+"x + " + Trendline.intercept), WIDTH + 60, 300);
        graphics.drawString(("Data sample size: " + (int)trend.size), WIDTH + 60, 350);
        graphics.drawString(("Minimum Value: " + trend.yMin), WIDTH + 60, 400);
        graphics.drawString(("Maximum Value: " + trend.yMax), WIDTH + 60, 450);
        graphics.drawString(("First Year: " + trend.xMin), WIDTH + 60, 500);
        graphics.drawString(("Last Year: " + trend.xMax), WIDTH + 60, 550);


        //Draws data points to the screen
        for(int i =0; i < Trendline.xValues.size(); i++) {

            double xx = (((double)(Trendline.xValues.get(i)-Trendline.xMin)  * kx));
            int x = (int)xx; //pixel locations must be integers


            double yy = k*(Trendline.yValues.get(i)-Trendline.yMin);
            int y = (int)yy;
            if(Trendline.slope < 0) {
                if (i == 0 || Trendline.yValues.get(i) < Trendline.yValues.get(i - 1)) {
                    graphics.setColor(Color.green);
                } else {
                    graphics.setColor(Color.orange);
                }
            }
            else if(Trendline.slope > 0){
                if (i == 0 || Trendline.yValues.get(i) > Trendline.yValues.get(i - 1)) {
                    graphics.setColor(Color.green);
                } else {
                    graphics.setColor(Color.orange);
                }
            }

            graphics.fillRect(x+3,HEIGHT-y-3,3,3);
            String year = Trendline.xValues.get(i).toString();
            String value = Trendline.yValues.get(i).toString();

            graphics.setFont(pointFont);
            //label for the data points
            graphics.drawString(("("+year+","+value+")"),x, HEIGHT-y+15);
        }



    }
}
