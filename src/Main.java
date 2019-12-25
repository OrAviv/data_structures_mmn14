import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Scanner int_scanner = new Scanner(System.in);
        System.out.println("Hello! please enter your -d- size:");
        int d = int_scanner.nextInt();
        Scanner string_scanner = new Scanner(System.in);
        System.out.println("Please enter your array FULL filepath:");
        String arrayString = string_scanner.nextLine();
        Scanner myFile = new Scanner(new File(arrayString)).useDelimiter(",\\s*");
        List<Float> temps = new ArrayList<Float>();
        while (myFile.hasNext())
        {
            float item = myFile.nextFloat();
            temps.add(item);
        }
        myFile.close();
        Float[] tempsArray = temps.toArray(new Float[0]);
        double[] myArray = new double[temps.size()];
        for (int i = 0; i < temps.size(); i++)
            myArray[i] = tempsArray[i];

        for (int i = 0; i < myArray.length; i++)
        {
            System.out.print(myArray[i]+" ");
            System.out.println();
        }
        Stack myStack = new Stack(myArray ,d);
//        myStack.extract_max(myArray, d);
//        myStack.insert(myArray, d, 10);
        myStack.print_array(myArray, d);
    }
}
