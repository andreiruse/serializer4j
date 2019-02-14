package com.andreiruse.serialize4j;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Tests {@link Serializer}
 */
public class SerializerTest {

  @Test
  public void testSerialize() throws IllegalAccessException {
    String test = "sample text";
    String serialized = Serializer.serialize(test, 2);
    assertEquals(serialized, "sample text");
  }

  @Test
  public void testSerializeWith0Indentation() throws IllegalAccessException {
    String test = "sample text";
    String serialized = Serializer.serialize(test, 2, 0).toString();
    assertEquals(serialized, "sample text");
  }

  @Test
  public void testSerializeWithExtraIndentation() throws IllegalAccessException {
    String test = "sample text";
    String serialized = Serializer.serialize(test, 2, 3).toString();
    assertEquals(serialized, "sample text");
  }
}