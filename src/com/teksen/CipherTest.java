package com.teksen;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * <h1> Encrypts and Decrypt the Text File </h1>
 * The CipherTest program implements that
 * takes the user's choice to encrypt/decrypt the txt file
 * which is provided by user and takes the key to shift
 * the order of alphabet.
 *
 * @author Unat Teksen
 * Computer Engineering
 * @version 1.0
 * @since 19-12-2020
 */

public class CipherTest {
    /**
     * This is the main method which makes use of CipherTest method.
     * Gets input from user in String and input form , creates object of Cipher class
     * and read-convert the txt file to the String. Call the related functions to
     * manipulate text in the txt file.
     *
     * @param args
     * return nothing
     */
    public static void main(String[] args) throws IOException {
        // create a Scanner to obtain input from command window.
        Scanner input = new Scanner(System.in);

        System.out.println("""
                Greetings, what would you like to do?
                1 - Encrypt the file
                2 - Decrypt the file"""); // prompt
        int answer = input.nextInt(); // choice of user to determine encrypt/decrypt

        System.out.println("Please provide the file name."); // prompt
        String fileName = input.next(); // name of txt file

        String oldText = ""; // blank String which will be text in file
        // create a Scanner to obtain the txt file
        Scanner inputPath = new Scanner(Paths.get(fileName));
        while (inputPath.hasNext()) { //  read the file if there is a character
            oldText = oldText + (inputPath.next()+" "); // add these characters to create full String text
        }

        if (answer == 1){ // encryption
            System.out.println("What will be your key?"); // prompt
            int key = input.nextInt(); // number of shift

            Cipher.encrypt(oldText, key); // call encryption function which belong to Cipher class
            Cipher.writer(fileName); // call writing function which belong to Cipher class
            System.out.print("Done! Input encrypted and saved! "); // prompt
        }

        if (answer == 2){
            System.out.println("What was the key you used to encrypt this text?"); // prompt
            int key = input.nextInt(); // number of shift

            Cipher.decrypt(oldText, key); // call decryption function which belong to Cipher class
            Cipher.writer(fileName); // call writing function which belong to Cipher class
            System.out.print("Done! Input decrypted and saved! "); // prompt
        }
    }
}
