package com.iab.gpp.encoder.datatype.encoder;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.iab.gpp.encoder.error.DecodingException;

class FixedIntegerRangeEncoderTest {

  @Test
  void testEncode1() {
    Assertions.assertEquals("000000000000", FixedIntegerRangeEncoder.encode(new ArrayList<>()));
  }
  
  @Test
  void testEncode2() {
    Assertions.assertEquals("00000000000100000000000000010", FixedIntegerRangeEncoder.encode(Arrays.asList(2)));
  }

  @Test
  void testEncode3() {
    Assertions.assertEquals("000000000001100000000000000100000000000000110", FixedIntegerRangeEncoder.encode(Arrays.asList(2,3,4,5,6)));
  }
  
  @Test
  void testEncode4() {
    Assertions.assertEquals("00000000001000000000000000010100000000000001010000000000000111", FixedIntegerRangeEncoder.encode(Arrays.asList(2, 5, 6, 7)));
  }
  
  @Test
  void testEncode5() {
    Assertions.assertEquals("00000000001000000000000000010100000000000001010000000000000111", FixedIntegerRangeEncoder.encode(Arrays.asList(5,2,7,6)));
  }
  
  @Test
  void testEncode6() {
    Assertions.assertEquals("00000000001000000000000000011100000000000001010000000000001000", FixedIntegerRangeEncoder.encode(Arrays.asList(3,5,6,7,8)));
  }
  
  @Test
  void testDecode1() throws DecodingException {
    Assertions.assertEquals(new ArrayList<>(), FixedIntegerRangeEncoder.decode("000000000000"));
  }
  
  @Test
  void testDecode2() throws DecodingException {
    Assertions.assertEquals(Arrays.asList(2), FixedIntegerRangeEncoder.decode("00000000000100000000000000010"));
  }
  
  @Test
  void testDecode3() throws DecodingException {
    Assertions.assertEquals(Arrays.asList(2,3,4,5,6), FixedIntegerRangeEncoder.decode("000000000001100000000000000100000000000000110"));
  }
  
  @Test
  void testDecode4() throws DecodingException {
    Assertions.assertEquals(Arrays.asList(2,5,6,7), FixedIntegerRangeEncoder.decode("00000000001000000000000000010100000000000001010000000000000111"));
  }
  
  @Test
  void testDecode5() throws DecodingException {
    Assertions.assertEquals(Arrays.asList(3,5,6,7,8), FixedIntegerRangeEncoder.decode("00000000001000000000000000011100000000000001010000000000001000"));
  }
  
  @Test
  void testDecode6() {
    try {
      FixedIntegerRangeEncoder.decode("0011");
      Assertions.fail("DecodingException expected");
    } catch (DecodingException e) {

    }
  }
  
  @Test
  void testDecode7() {
    try {
      FixedIntegerRangeEncoder.decode("000000000002");
      Assertions.fail("DecodingException expected");
    } catch (DecodingException e) {

    }
  }
}