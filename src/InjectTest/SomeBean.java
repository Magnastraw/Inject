package InjectTest;

public class SomeBean {
    @AutoInjectable
    public SomeInterface field1;
    
    @AutoInjectable
    public SomeOtherInterface field2;
    
    public void foo(){
        field1.doSomething();
        field2.doSomething();
    }
}

interface SomeInterface{
    public void doSomething();
}

interface SomeOtherInterface{
    public void doSomething();
}

class SomeImpl implements SomeInterface {

    public void doSomething(){
        System.out.println("A");
    }
}

class OtherImpl implements SomeInterface{

    public void doSomething(){
        System.out.println("B");
    }
}

class SODoer implements SomeOtherInterface {
    public void doSomething(){
        System.out.println("C");
    }
}