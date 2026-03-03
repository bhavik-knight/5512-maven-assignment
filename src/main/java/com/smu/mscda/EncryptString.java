package com.smu.mscda;

import lombok.Getter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
public class EncryptString {
    /**
     * -- GETTER --
     *  public method to get the hashing algorithm being used
     *
     */
    private String algorithm = null;

  /** default constructor to set the default hashing algorithm to MD5 */
  public EncryptString() {
    this.algorithm = "MD5";
  }

  /**
   * constructor to set the hashing algorithm to the one specified by the user
   *
   * @param algorithm the hashing algorithm to be used for hashing the string
   */
  public EncryptString(String algorithm) {
    this.setAlgorithm(algorithm);
  }

    /**
   * public method to set the hashing algorithm to be used for hashing the string
   *
   * @param algorithm the hashing algorithm to be used for hashing the string
   */
  public void setAlgorithm(String algorithm) {
    if (algorithm == null || algorithm.isEmpty()) {
      throw new RuntimeException("Algorithm cannot be null or empty.");
    }
    this.algorithm = algorithm;
  }

  /**
   * public method to get the hash of the given string using the specified hashing algorithm
   *
   * @param word the string to be hashed
   * @return the hash of the given string using the specified hashing algorithm
   */
  public String getHash(String word) {
    if (word == null || word.isEmpty()) {
      throw new RuntimeException("Input string cannot be null or empty.");
    }
    return this.createHash(word);
  }

  /**
   * private method to create hash of the given string using the specified hashing algorithm
   *
   * @param word the string to be hashed
   * @return the hash of the given string using the specified hashing algorithm
   */
  private String createHash(String word) {
    try {
      // instantiate a MessageDigest object for the specified hashing algorithm
      MessageDigest md = MessageDigest.getInstance(this.algorithm);

      // convert string to bytes and compute hash
      byte[] messageDigestBytes = md.digest(word.getBytes());

      // convert byte array to hex string
      StringBuilder hexString = new StringBuilder();
      for (byte b : messageDigestBytes) {
        String hex = Integer.toHexString(0xff & b);

        if (hex.length() == 1) {
          hexString.append('0');
        }

        hexString.append(hex);
      }
      return hexString.toString();

    } catch (NoSuchAlgorithmException ex) {
      throw new RuntimeException(ex);
    }
  }
}
