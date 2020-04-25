package com.company;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {



        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();


        Path filePath = Paths.get("C://Users//szymamag//Desktop//data.txt");

        File file = new File(String.valueOf(filePath));
        Scanner sc = new Scanner(file);

        int countRow = 0;

        StringBuffer input = new StringBuffer(50);
        while (sc.hasNextLine()) {
            countRow++;
            String line = sc.nextLine();
            input.append(line + "\n");
            try {
                String numbers[] = line.split(",");
                x.add(Integer.valueOf(numbers[0].trim()));
                y.add(Integer.valueOf(numbers[1].trim()));
            } catch (Exception e) {
                System.err.println("Niepoprawny format pliku");
                throw e;
            }

        }

        double xva = averageValue(x);
        double xvy = averageValue(y);
        String header1 = "Liczba wierszy = " + countRow + "\n";
        String header2 = "Wartość średnia kolumny x= " + xva + "\n";
        String header3 = "Wartość średnia kolumny y= " + xvy + "\n";
        String header4 = "x | y " + "\n";

        StringBuffer output = new StringBuffer(50);
        output.append(header1).append(header2).append(header3).append(header4).append(input);
        //System.out.println(output);

        try{
            Files.writeString(Paths.get("C://Users//szymamag//Desktop//new_data.txt"), output, StandardOpenOption.CREATE);

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    static double averageValue(ArrayList<Integer> list) {

        return  list.stream().mapToInt(Integer::intValue).average().orElse(0.0);

    }
}
