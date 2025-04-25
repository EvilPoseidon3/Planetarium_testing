package utils;
import java.time.*;
import java.io.File;
import java.io.*;


public class DataParser {


    public static void main(String[] args) {
        int i = 0;
        while (i < 1) {
            File file = new File("src/test/resources/Test Data/US4_PlanetData.csv");
            csvParserOrdered(file);
            i++;
        }

    }

    public static void csvParser(File csvFile){

        try {
            if (csvFile.canRead() && csvFile.exists()) {
                BufferedReader reader = new BufferedReader(
                        new FileReader(csvFile));

                String line;

                while((line = reader.readLine()) != null){
                    String[] values = line.split(",");
                    String newData = "";
                    for(int i = 0; i < values.length ;i++){
                        if (i == 0){
                            newData += ("|" + values[i] + "|");
                        } else {newData += (values[i] + "|");}
                    }
                    System.out.println(newData);
                }

            }
        } catch(Exception fnf){
            System.out.println("Caught an exception: " + fnf.getMessage());
        }
    }

    public static void csvParserOrdered(File csvFile){

        try {
            if (csvFile.canRead() && csvFile.exists()) {
                BufferedReader reader = new BufferedReader(
                        new FileReader(csvFile));

                String line;

                StringBuilder totalString = new StringBuilder();

                while((line = reader.readLine()) != null){
                    String[] values = line.split(",");
                    String newData = "";
                    for(int i = 0; i < values.length ;i++){
                        if (i == 0){
                            newData += ("|" + values[i] + "|");
                        } else {newData += (values[i] + "|");}
                    }

                    if (newData.contains("Invalid")){
                        totalString.append(newData + "\n");
                    } else {totalString.insert(0,(newData) + "\n");}

                }
                System.out.println(totalString);
            }
        } catch(Exception fnf){
            System.out.println("Caught an exception: " + fnf.getMessage());
        }
    }


}
