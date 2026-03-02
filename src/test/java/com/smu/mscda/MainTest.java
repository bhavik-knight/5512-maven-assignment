package com.smu.mscda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {
  CapitalizeString cs = new CapitalizeString();
  EncryptString md5Hash = new EncryptString("MD5");
  EncryptString sha256Hash = new EncryptString("SHA-256");

  @Test
  void capitalizeSmu() {
    assertEquals("Smu", cs.getCapitalizedString("smu"));
  }

  @Test
  void md5Smu() {
    assertEquals("6850c0ee0db4626bbdda5660167f0d4c", md5Hash.getHash("Smu"));
  }

  @Test
  void sha256Smu() {
    assertEquals(
        "605d75b039b579cdd7b74c14c398f785a321e15a322cb01f199254e03dfe36ef",
        sha256Hash.getHash("Smu"));
  }

  @Test
  void capitalizeEmptyString() {
    assertThrows(RuntimeException.class, () -> cs.getCapitalizedString(""));
  }

  @Test
  void md5EmptyString() {
    assertThrows(RuntimeException.class, () -> md5Hash.getHash(""));
  }

  @Test
  void sha256EmptyString() {
    assertThrows(RuntimeException.class, () -> sha256Hash.getHash(""));
  }

  @Test
  void capitalizeSingleCharacter() {
    assertEquals("A", cs.getCapitalizedString("a"));
  }

  @Test
  void md5SingleCharacter() {
    assertEquals("7fc56270e7a70fa81a5935b72eacbe29", md5Hash.getHash("A"));
  }

  @Test
  void sha256SingleCharacter() {
    assertEquals(
        "559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd",
        sha256Hash.getHash("A"));
  }

  @Test
  void alreadyCapitalized() {
    assertEquals("Smu", cs.getCapitalizedString("Smu"));
  }

  @Test
  void md5HashAlreadyCapitalized() {
    assertEquals("6850c0ee0db4626bbdda5660167f0d4c", md5Hash.getHash("Smu"));
  }

  @Test
  void sha256HashAlreadyCapitalized() {
    assertEquals(
        "605d75b039b579cdd7b74c14c398f785a321e15a322cb01f199254e03dfe36ef",
        sha256Hash.getHash("Smu"));
  }
}
