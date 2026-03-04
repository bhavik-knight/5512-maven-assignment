package com.smu.mscda;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class that uses external libraries for string capitalization and hashing. This test suite
 * provides alternative implementations using: - Apache Commons Lang3: StringUtils.capitalize() for
 * string capitalization - Apache Commons Codec: DigestUtils for MD5 and SHA-256 hashing
 *
 * <p>These tests are identical to MainTest but use external libraries instead of manually written
 * classes, allowing us to verify that both approaches produce the same results.
 */
class ExternalLibrariesTest {

  @Test
  void capitalizeSmuUsingExternalLib() {
    assertEquals("Smu", StringUtils.capitalize("smu"));
  }

  @Test
  void md5SmuUsingExternalLib() {
    assertEquals("6850c0ee0db4626bbdda5660167f0d4c", DigestUtils.md5Hex("Smu"));
  }

  @Test
  void sha256SmuUsingExternalLib() {
    assertEquals(
        "605d75b039b579cdd7b74c14c398f785a321e15a322cb01f199254e03dfe36ef",
        DigestUtils.sha256Hex("Smu"));
  }

  @Test
  void capitalizeSingleCharacterUsingExternalLib() {
    assertEquals("A", StringUtils.capitalize("a"));
  }

  @Test
  void md5SingleCharacterUsingExternalLib() {
    assertEquals("7fc56270e7a70fa81a5935b72eacbe29", DigestUtils.md5Hex("A"));
  }

  @Test
  void sha256SingleCharacterUsingExternalLib() {
    assertEquals(
        "559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd",
        DigestUtils.sha256Hex("A"));
  }

  @Test
  void alreadyCapitalizedUsingExternalLib() {
    assertEquals("Smu", StringUtils.capitalize("Smu"));
  }

  @Test
  void md5HashAlreadyCapitalizedUsingExternalLib() {
    assertEquals("6850c0ee0db4626bbdda5660167f0d4c", DigestUtils.md5Hex("Smu"));
  }

  @Test
  void sha256HashAlreadyCapitalizedUsingExternalLib() {
    assertEquals(
        "605d75b039b579cdd7b74c14c398f785a321e15a322cb01f199254e03dfe36ef",
        DigestUtils.sha256Hex("Smu"));
  }
}
