package com.smu.mscda;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public final class Main {
  // Private constructor to prevent instantiation (utility class)
  private Main() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static void main(String[] args) {
    // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("================================");
    System.out.println("Hello and welcome!");
    System.out.println(
        "This program will take a string input from the user, capitalize the first letter of the string.\n"
            + "Then hash the capitalized string using MD5 and SHA-256 algorithms.");

    // get user input from the terminal and store it in a variable
    String word = null;
    try (Scanner scanner = new Scanner(System.in)) {
      // instantiate a scanner object to read user input from the terminal
      System.out.print("\nEnter a string: ");
      word = scanner.nextLine();
    } catch (Exception ex) {
      System.err.printf("An error occurred while reading input: %s\n", ex.getMessage());
      return;
    } finally {
      System.out.println("================================\n");
    }

    // manual methods using the class I wrote
    // CapitalizeString class to capitalize the first letter of the string
    System.out.println("Using the class written by me:=");
    CapitalizeString cs = new CapitalizeString();
    String capitalizedWord = cs.getCapitalizedString(word);
    System.out.printf("Capitalized string: %s\n", capitalizedWord);

    // EncryptString class to hash the string using MD5 algorithm
    EncryptString md5Hash = new EncryptString("MD5");
    String hashedWord = md5Hash.getHash(capitalizedWord);
    System.out.printf("MD5 hash of the string '%s': %s\n", capitalizedWord, hashedWord);

    // EncryptString class to hash the string using SHA-256 algorithm
    EncryptString sha256Hash = new EncryptString("SHA-256");
    hashedWord = sha256Hash.getHash(capitalizedWord);
    System.out.printf("SHA-256 hash of the string '%s': %s\n", capitalizedWord, hashedWord);

    System.out.println("================================\n");

    // using the external libraries
    System.out.println("Using the external libraries:=");
    capitalizedWord = StringUtils.capitalize(word);
    System.out.printf("Capitalized string: %s\n", capitalizedWord);

    // md5 hash
    hashedWord = DigestUtils.md5Hex(capitalizedWord);
    System.out.printf("MD5 hash of the string '%s': %s\n", capitalizedWord, hashedWord);

    // sha256 hash
    hashedWord = DigestUtils.sha256Hex(capitalizedWord);
    System.out.printf("SHA-256 hash of the string '%s': %s\n", capitalizedWord, hashedWord);
    System.out.println("================================\n");
  }
}
