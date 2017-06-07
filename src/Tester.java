import javax.swing.*;
import java.io.*;
import java.util.*;

public class Tester { //Data arrays will be entered here

    public static List<Integer> xTestArray;
    public static List<Integer> yTestArray;
    private static boolean carryOn = true;
    public static Trendline trend = null;
    public static String dataTitle = "";
    public static void main(String []args){
        while(carryOn){ //will keep the program looping until user chooses to stop it
            runProgram();
        }

    }

    public static void runProgram(){
        yearValues();
        userPrompt();
        newData();

        trend = new Trendline(xTestArray,yTestArray);
        System.out.println("sumX is " + trend.sumX); //These are all the data values that the Trendline class calculates
        System.out.println("sumY is " + trend.sumY);
        System.out.println("sumXY is " + trend.sumXY);
        System.out.println("SumXSquared is " + trend.sumXSquared);
        System.out.println("size is " + trend.size);
        System.out.println("Y-Intercept is " + trend.intercept);
        System.out.println("Slope is " + Trendline.slope);
        System.out.println("y = "+trend.slope+"x + " + trend.intercept);
        System.out.println("y min = " + trend.yMin + " y max = " + trend.yMax);
        System.out.println("");
        frameInit();

        Scanner kbReader = new Scanner(System.in);
        System.out.println("Run again?");
        String response = kbReader.next();
        if(response.toLowerCase().equals("yes") || response.toLowerCase().equals("y")){
            carryOn=true;
        }
        else{
            carryOn=false;
        }
    }

    private static void frameInit(){ //Creates the Frame
        JFrame screen = new JFrame(dataTitle);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graph graph = new Graph(trend);
        screen.add(graph);
        screen.setSize(900,900); //must be greater than 800 x 800
        //screen.setUndecorated(true); to get rid of bar on the top
        screen.setVisible(true);
    }

    public static void userPrompt(){
        Scanner kbReader = new Scanner(System.in);
        System.out.println("Which data set would you like to view?");
        System.out.println("1. Days Very Unhealthy");
        System.out.println("2. Days Clean");
        System.out.println("");
        int choice = kbReader.nextInt();
        yTestArray = new ArrayList<Integer>();
        switch(choice){ //switch statement that will change the data set
            case 1: // days of very unhealthy
                yTestArray.addAll(Arrays.asList(159, 160, 129, 135, 137, 139, 140, 129, 145, 113,
                        89, 85, 89, 72, 82, 60, 32, 13, 24, 1,
                        10, 11, 22, 30, 4, 12, 11, 6, 8, 4,
                        0, 3, 2, 0, 2, 1, 3));
                dataTitle = "Days of Very Unhealthy AQI";
                break;
            case 2://days of good
                yTestArray.addAll(Arrays.asList(6, 4, 8, 11, 5, 10, 7, 6, 9, 10,
                        17, 16, 22, 29, 22, 43, 42, 33, 54, 17,
                        27, 20, 34, 41, 29, 57, 64, 45, 31, 34,
                        32, 17, 33, 22, 23, 26, 32));
                dataTitle = "Days of Healthy AQI";
                break;

        }

    }

    public static void yearValues(){ //stores all year values
        xTestArray = new ArrayList<Integer>();

        for(int i = 1980; i<=2016; i++){
            xTestArray.add(i);
        }


        //         xTestArray.add(275);
        //         xTestArray.add(310);
        //         xTestArray.add(370);
        //         xTestArray.add(245);
        //         xTestArray.add(255);
        //         xTestArray.add(290);

    }

    public static void newData() { //method for entering new data
        Scanner kbReader = new Scanner(System.in);
        System.out.println("Would you like to add data? (yes/no)");
        String userResponse = kbReader.next();
        if (userResponse.toLowerCase().equals("yes") || userResponse.toLowerCase().equals("y")) {
            System.out.println("Year: ");
            xTestArray.add(kbReader.nextInt());
            System.out.println("Data Value: ");
            yTestArray.add(kbReader.nextInt());

        }
        else{
            System.out.println();
        }

    }

}
