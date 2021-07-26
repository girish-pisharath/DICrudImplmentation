import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrimAndWrapTypes {
    static final Map<Class<?>, Object> DEFAULT_TYPE_VALUES;

    static {
        Map<Class<?>, Object> values = new HashMap<>();
        values.put(boolean.class, false);
        values.put(byte.class, (byte) 0);
        values.put(short.class, (short) 0);
        values.put(int.class, 0);
        values.put(float.class, (float) 0.0);
        values.put(double.class, (double) 0.0);
        values.put(long.class, (long) 0);
        values.put(java.lang.Boolean.class, false);
        values.put(java.lang.Byte.class, (byte) 0);
        values.put(java.lang.Short.class, (short) 0);
        values.put(java.lang.Integer.class, 0);
        values.put(java.lang.Long.class, (long) 0);
        values.put(java.lang.Float.class, (float) 0.0);
        values.put(java.lang.Double.class, (double) 0);
        values.put(java.lang.String.class, "");
        DEFAULT_TYPE_VALUES = Collections.unmodifiableMap(values);
    }
}
