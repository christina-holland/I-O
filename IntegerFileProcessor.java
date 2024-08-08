import java.io.*;
import java.util.*;

public class IntegerFileProcessor {

    public static void main(String[] args) {
        //Creating the lists to store the integers read from each file
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        //Creating the set to store the integers that are common in both files
        Set<Integer> commonIntegers = new HashSet<>();

        //Reading the integers from the first file
        try (BufferedReader br = new BufferedReader(new FileReader("input1.txt"))) {
            String line;
            //Reading each line from the file
            while ((line = br.readLine()) != null) {
                try {
                    //Parsing the line to an integer and adding it to list1
                    list1.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    //Handling the case where the line is not a valid integer
                    System.err.println("Invalid integer format in input1.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            //Handling the case where the file is not found
            System.err.println("input1.txt not found.");
        } catch (IOException e) {
            //Handling I/O errors
            System.err.println("Error reading input1.txt: " + e.getMessage());
        }

        //Reading the integers from the second file
        try (BufferedReader br = new BufferedReader(new FileReader("input2.txt"))) {
            String line;
            //Reading each line from the file
            while ((line = br.readLine()) != null) {
                try {
                    //Parsing the line to an integer and adding it to list2
                    list2.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    //Handling the case where the line is not a valid integer
                    System.err.println("Invalid integer format in input2.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            //Handling the case where the file is not found
            System.err.println("input2.txt not found.");
        } catch (IOException e) {
            //Handling I/O errors
            System.err.println("Error reading input2.txt: " + e.getMessage());
        }

        //Writing the merged contents to merged.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("merged.txt"))) {
            //Writing all integers from list1 to the file
            for (Integer num : list1) {
                bw.write(num + System.lineSeparator());
            }
            //Writing all integers from list2 to the file
            for (Integer num : list2) {
                bw.write(num + System.lineSeparator());
            }
        } catch (IOException e) {
            //Handling I/O errors when writing to merged.txt
            System.err.println("Error writing merged.txt: " + e.getMessage());
        }

        //Finding common integers between the two lists
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        //Iterating through set1 and adding common integers to the commonIntegers set
        for (Integer num : set1) {
            if (set2.contains(num)) {
                commonIntegers.add(num);
            }
        }

        //Writing the common integers to common.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("common.txt"))) {
            //Writing each of the common integers to the file
            for (Integer num : commonIntegers) {
                bw.write(num + System.lineSeparator());
            }
        } catch (IOException e) {
            //Handling I/O errors when writing to common.txt
            System.err.println("Error writing common.txt: " + e.getMessage());
        }
    }
}
