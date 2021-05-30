package com.teksen;
import java.io.*;
/**
 * <h1> Encrypts and Decrypt the Text File </h1>
 * The Cipher program implements that
 *
 *
 * @author Unat Teksen
 * @version 1.0
 * @since 19-12-2020
 */
public class Cipher {
    private static String newText= ""; //

    /**
     * This method shift the characters in old text if they are
     * characters of alphabet. Checks the character is upper or lower case
     * and change it with one of the next characters according to the
     * given key.
     *
     * @param oldText is the text of the txt file
     * @param key ist he number of shift
     * return nothing
     */
    public static void encrypt(String oldText, int key){
        // manipulate all characters in the text of txt file
        for(int i=0; i < oldText.length();i++) {
            char character = oldText.charAt(i); // character in txt file's text in index i

            if(character >= 'a' && character <= 'z') { // if character is part of lower case alphabet
                character = (char) (character + key); // assign the character with shifted the character with given key

                if(character > 'z') { // if character is not part of alphabet
                    character = (char) (character+'a'-'z'-1); // assign character to the existed character
                }
                newText = newText + character; // add changed character to the new text
            }

            else if(character >= 'A' && character <= 'Z') { // if character is part of upper case alphabet
                character = (char) (character + key); // assign the character with shifted the character with given key

                if(character > 'Z') { // if character is not part of alphabet
                    character = (char) (character+'A'-'Z'-1); // assign character to the existed character
                }
                newText = newText + character; // add changed character to the new text
            } else {
                newText = newText + character; // add changed character to the new text
            }
        }
    }
    /**
     * This method shift the characters in old text if they are
     * characters of alphabet. Checks the character is upper or lower case
     * and change it with one of the previous characters according to the
     * given key.
     *
     * @param oldText is the text of the txt file
     * @param key ist he number of shift
     * return nothing
     */
    public static void decrypt(String oldText, int key) {
        // manipulate all characters in the text of txt file
        for(int i=0; i < oldText.length();i++) {
            char oldCharacter = oldText.charAt(i); // character in txt file's text in index i

            if(oldCharacter >= 'a' && oldCharacter <= 'z') { // if character is part of lower case alphabet
                oldCharacter = (char) (oldCharacter - key); // assign the character with shifted the character with given key

                if(oldCharacter < 'a') { // if character is not part of alphabet
                    oldCharacter = (char) (oldCharacter-'a'+'z'+1); // assign character to the existed character
                }
                newText = newText + oldCharacter; // add changed character to the new text
            }

            else if(oldCharacter >= 'A' && oldCharacter <= 'Z') { // if character is part of upper case alphabet
                oldCharacter = (char) (oldCharacter - key); // assign the character with shifted the character with given key

                if (oldCharacter < 'A') { // if character is not part of alphabet
                    oldCharacter = (char) (oldCharacter-'A'+'Z'+1); // assign character to the existed character
                }
                newText = newText + oldCharacter; // add changed character to the new text
            } else {
                newText = newText + oldCharacter; // add changed character to the new text
            }
        }

    }

    /**
     * This method writes the newText which is created by
     * encrypt/decrypt functions on the given txt.
     * @param fileName is the name of the file which the writer function writes new text on
     * @throws IOException
     * return nothing
     */
    public static void writer(String fileName) throws IOException {
        FileWriter myWriter = new FileWriter(fileName); // create an object with the txt file to write on it
        myWriter.write(newText); // write new text on txt file
        myWriter.close(); // close the txt file
    }
}
