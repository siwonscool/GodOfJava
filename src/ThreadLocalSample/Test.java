package ThreadLocalSample;

public class Test {
    public static void main(String[] args) {
        UserServiceA a = new UserServiceA();
        UserServiceC c = new UserServiceC();

        c.logicC();
        a.logicA();
    }
}
