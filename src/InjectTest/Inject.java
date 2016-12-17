package InjectTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Properties;


public class Inject<T> {
    private Properties property;
    private FileInputStream fileStream;
    private Class c;
    Field[] fields;

    public T inject(T o) throws IOException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        property = new Properties();
        fileStream = new FileInputStream("src/config.properties");
        property.load(fileStream);
        c = o.getClass();
        fields = c.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String className = property.getProperty(field.getType().getCanonicalName());
                Class setToClass =  Class.forName(className);
                Object object = setToClass.newInstance();
                field.set(o, object);
            }
        }
        return o;
    }
}
