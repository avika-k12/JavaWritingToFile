import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class UsernameFileHandler {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Scanner to scan for input - hence (System.in)

        //Ask for username
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        //Append username to file
        try {
            FileWriter writer = new FileWriter("username.txt", true);
            writer.write(username + "\n"); //Remember \n in between new lines
            writer.close();
            System.out.println("Username successfully appended to the file.");
            //adds username inputted by user into the file
        }
        catch (IOException e){
            System.out.println("An error occured while writing to the file.");
            e.printStackTrace();
        }

        try {
            File file = new File("username.txt");
            Scanner reader = new Scanner(file);
            boolean found = false; //boolean to change into true when the username is found
            while (reader.hasNextLine()) {
                String readUsername = reader.nextLine();
                System.out.println(readUsername);
                if (username.equals(readUsername)) { //username has been found in a line in the file
                    found = true;
                    break;
                }
            }
            reader.close();
            if (found) {
                System.out.println("Username is found");
            }
            else {
                System.out.println("Username wasn't found");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("error!!!");
            e.printStackTrace();
        }
    }
}
