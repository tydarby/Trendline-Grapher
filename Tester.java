import javax.swing.*;
import java.io.*;
import java.util.*;

public class Tester { //Data arrays will be entered here

    public static List<Integer> xTestArray;
    public static List<Integer> yTestArray;
    public static boolean carryOn = true;
    public static void main(String []args){
        while(carryOn){ //will keep the program looping until user chooses to stop it
            runProgram();
        }
        
    }

    public static void runProgram(){
        yearValues();
        userPrompt();
        newData();

        Trendline trend = new Trendline(xTestArray,yTestArray);
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

    public static void frameInit(){ //Creates the Frame
        JFrame screen = new JFrame("Trendline");
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graph graph = new Graph();
        screen.add(graph);
        screen.setSize(900,900); //must be greater than 800 x 800
        //screen.setUndecorated(true); to get rid of bar on the top
        screen.setVisible(true);
    }

    public static void userPrompt(){ 
        Scanner kbReader = new Scanner(System.in);
        System.out.println("Which data set would you like to view?");
        System.out.println("1. White Tailed Deer (pop)");
        System.out.println("2. Human (pop)");
        System.out.println("3. Dog(pop)");
        System.out.println("4. Land in hybrid Cottonwood (acres)");
        System.out.println("5. Land in cattle (dairy and beef)");
        System.out.println("6. Land in other farm");
        System.out.println("7. Land in housing");
        System.out.println("8. Hunting weapons registered(#)");
        System.out.println("9. Housing starts (#), county-wide 5)");
        System.out.println("10. Employed in county, nonfarm");
        System.out.println("11. Employed in county, farm");
        System.out.println("12. Vehicles registered on Puget Island");
        System.out.println("13. Ferry Traffic across Puget Island##");
        System.out.println("14. WHD killed by auto collision, PI only");
        System.out.println("");
        int choice = kbReader.nextInt();
        yTestArray = new ArrayList<Integer>();
        switch(choice){ //switch statement that will change the data set
            case 1: //deer population values

            yTestArray.add(275);
            yTestArray.add(310);
            yTestArray.add(370);
            yTestArray.add(245);
            yTestArray.add(255);
            yTestArray.add(290);
            break;
            case 2://human population values

            yTestArray.add(820);
            yTestArray.add(830);
            yTestArray.add(830);
            yTestArray.add(840);
            yTestArray.add(840);
            yTestArray.add(820);
            break;
            case 3://dog pop
            yTestArray.addAll(Arrays.asList(150,150,150,160,160,150));
            break;
            case 4://land in hybrid cottonwood
            yTestArray.addAll(Arrays.asList(0, 30, 300, 600, 800, 800));
            break;
            case 5://land in cattle
            yTestArray.addAll(Arrays.asList(2500, 2500,2100, 2000, 1700, 1600));
            break;
            case 6://land in other farm
            yTestArray.addAll(Arrays.asList(1500, 1500, 1500, 1700, 1800, 1900));
            break;
            case 7:
            yTestArray.addAll(Arrays.asList(50, 50, 50, 55, 55, 55));
            break;
            case 8:
            yTestArray.addAll(Arrays.asList(350, 350, 350, 350, 350, 350));
            break;
            case 9:
            yTestArray.addAll(Arrays.asList(5, 5, 10, 5, 5));
            System.out.println("What is the value for 2011? ");
            yTestArray.add(kbReader.nextInt());
            break;
            case 10:
            yTestArray.addAll(Arrays.asList(550, 560, 570, 570, 570, 560));
            break;
            case 11:
            yTestArray.addAll(Arrays.asList(1100, 1120, 1130, 1100, 1120, 1140));
            break;
            case 12:
            yTestArray.addAll(Arrays.asList(230, 230, 220, 230, 240, 240));
            break;
            case 13:
            yTestArray.addAll(Arrays.asList(27, 27, 29, 27, 29, 27));
            break;
            case 14:
            yTestArray.addAll(Arrays.asList(43, 31, 37, 33, 36, 38));
            break;

        }

    }

    public static void yearValues(){ //stores all year values
        xTestArray = new ArrayList<Integer>();
        xTestArray.add(1986);
        xTestArray.add(1991);
        xTestArray.add(1996);
        xTestArray.add(2001);
        xTestArray.add(2006);
        xTestArray.add(2011);
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

    //todo make a method that reruns the program

}
