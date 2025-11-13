import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WriteToFileAndReadFromFile {
    public static void main(String[] args){
        try {
            FileWriter writer = new FileWriter("example.txt"); //This is opening and naming of the file
            writer.write("Hello World!\n"); //First line of 'example.txt'
            writer.write("This is a file writing example\n"); //Second line of 'example.txt'
            writer.write("I hope you enjoy reading this file!"); //Third line
            writer.close(); //Closing the writer which was writing the lines to 'example.txt'
            System.out.println("Successfully wrote to the file."); //Confirmation message in console
        }
        catch (IOException e){
            System.out.println("error!"); //Error message
            e.printStackTrace(); //Will print the error and stack of instructions from where the error occured
        }

        try {
            File file = new File("example.txt"); //This is ope
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("An error!");
            e.printStackTrace();
        }
    }
}
