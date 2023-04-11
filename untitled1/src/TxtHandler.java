import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtHandler {
    public static ArrayList<String> createAllDataTable(String fileName2){
        ArrayList<String> listOfData = new ArrayList<>();
        try  {
            String current = "";
            String line = "";
            Scanner in = null;
            in = new Scanner(new BufferedReader(
                    new FileReader(fileName2)));
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName2));
            int row = 0;
            while ((current = br.readLine()) != null) {
                line = current;
                listOfData.add(line);
                System.out.println(line);
            }
        }
        catch (Exception e)
        {System.out.println("We couldnt find the file, please type again!"); return null;}
        return listOfData;
    }
}
