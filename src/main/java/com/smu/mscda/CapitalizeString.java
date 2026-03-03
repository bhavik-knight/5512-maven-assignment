package com.smu.mscda;

import java.util.Locale;

public class CapitalizeString {

  /**
   * public method to get capitalized version of the given string
   *
   * @param word the string to be capitalized
   * @return capitalized version of the given string
   */
  public String getCapitalizedString(String word) {
    if (word == null || word.isEmpty()) {
      throw new RuntimeException("Input string cannot be null or empty.");
    }
    return this.capitalize(word);
  }

  /**
   * private method to capitalize the first letter of the given string
   *
   * @param word the string to be capitalized
   * @return capitalized version of the given string
   */
  private String capitalize(String word) {
    // capitalize the first letter of the string and return the result
    String capitalizedWord = String.valueOf(word.charAt(0)).toUpperCase(Locale.ROOT);
    capitalizedWord += word.substring(1);

    return capitalizedWord;
  }
}
