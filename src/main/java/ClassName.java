import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class ClassName extends ClassLoader {
    Integer i;
    String s;
    boolean b;
    int j;
    DIClass diClass;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(ClassName.returnObject("ClassName"));
    }

    static Object returnObject(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends Object> a = Class.forName(className, true, ClassName.getSystemClassLoader());
        Object c = null;
        if (!a.isInterface()) {
            Constructor<? extends Object> b = a.getConstructors().length > 0 ? a.getConstructors()[0] : a.getConstructor();
            List<Object> args = new ArrayList<>();
            Parameter[] p = b.getParameters();
            for (int i = 0; i < b.getParameters().length; i++) {
                if (PrimAndWrapTypes.DEFAULT_TYPE_VALUES.containsKey(p[i].getDeclaringExecutable().getDeclaringClass())) {
                    args.add(PrimAndWrapTypes.DEFAULT_TYPE_VALUES.get(p[i].getDeclaringExecutable().getDeclaringClass()).toString());
                } else {
                    args.add(null);
                }
            }
            c = b.newInstance(args.toArray());
            for (Field f : a.getDeclaredFields()
            ) {
                if (!f.getType().isPrimitive() && !f.getDeclaringClass().isInterface() &&
                        !PrimAndWrapTypes.DEFAULT_TYPE_VALUES.containsKey(f.getType())) {
                    f.set(c,returnObject(f.getType().getTypeName()));
                }else{
                    if(!f.canAccess(c)){
                     f.setAccessible(true);
                    }
                    f.set(c,PrimAndWrapTypes.DEFAULT_TYPE_VALUES.get(f.getType()));
                }
            }

        }
        return c;
    }

    @Override
    public String toString() {
        return "ClassName{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", b=" + b +
                ", j=" + j +
                ", diClass=" + diClass +
                '}';
    }

}
