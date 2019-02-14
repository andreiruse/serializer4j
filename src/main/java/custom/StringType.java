package custom;

public class StringType implements SerializableType {
  public static final Class MATCHING_TYPE = String.class;

  @Override
  public boolean isType(Object object) {
    return MATCHING_TYPE.isInstance(object);
  }

  @Override
  public StringBuilder serialize(Object object) {
    return new StringBuilder().append(MATCHING_TYPE.cast(object).toString());
  }
}
