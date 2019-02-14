package com.andreiruse.serialize4j.custom;

public interface SerializableType {
  public boolean isType(Object object);
  public StringBuilder serialize(Object object);
}
