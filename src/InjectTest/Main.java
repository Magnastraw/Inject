package InjectTest;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        SomeBean sb= (SomeBean)(new Inject()).inject(new SomeBean());
        sb.foo();
    }
}
