package com.smu.mscda;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@UtilityClass
public class Main {
  static void main(String[] args) {
    // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    System.out.println("================================");
    System.out.println("Hello and welcome!");

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
      System.out.println("================================");
    }

    CapitalizeString cs = new CapitalizeString();
    String capitalizedWord = cs.getCapitalizedString(word);
    System.out.printf("Capitalized string: %s", capitalizedWord);

    // hash the string using MD5 algorithm
    EncryptString md5Hash = new EncryptString("MD5");
    String hashedWord = md5Hash.getHash(capitalizedWord);
    System.out.printf("\nMD5 hash of the string '%s': %s", capitalizedWord, hashedWord);

    // hash the string using SHA-256 algorithm
    EncryptString sha256Hash = new EncryptString("SHA-256");
    hashedWord = sha256Hash.getHash(capitalizedWord);
    System.out.printf("\nSHA-256 hash of the string '%s': %s", capitalizedWord, hashedWord);

    System.out.println("\n================================");
  }
}
