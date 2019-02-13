import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Serializer {

  public static String serialize(Object o, int levels) throws IllegalAccessException {
    return serialize(o, levels, 0).toString();
  }

  public static StringBuilder serialize(Object o, int levels, int indentation) throws IllegalAccessException {
    StringBuilder stringBuilder = new StringBuilder();
    for (Field field : o.getClass().getDeclaredFields()) {
      if (Modifier.isStatic(field.getModifiers())) {
        continue;
      }
      field.setAccessible(true);
      Object o2 = field.get(o);
      stringBuilder.append(System.lineSeparator());
      stringBuilder
          .append(prefix(indentation))
          .append(field.getName())
          .append("=");
      if (levels > 0 && o2 != null && !field.getType().isPrimitive() && o2.getClass().getDeclaredFields().length > 0) {
        stringBuilder.append(serialize(o2, levels - 1, indentation + 1));
      } else if (o2 == null) {
        stringBuilder.append("null");
      } else { //If primitive, if we don't want to go deeper, or if it doesn't have any fields
        stringBuilder.append(o2.toString());
      }
    }
    return stringBuilder;
  }

  private static String prefix(int indentationLevel) {
    return IntStream.range(0, indentationLevel).mapToObj(x -> "-").collect(Collectors.joining());
  }
}
