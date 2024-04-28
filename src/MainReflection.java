import model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume r = new Resume("");
        Method[] methods = r.getClass().getMethods();
        for (Method method: methods) {
            if(method.getName().equals("toString")){
                System.out.println(method.invoke(r));
            }
        }
        System.out.println("===============================================");
        Method method = r.getClass().getMethod("toString");
        System.out.println(method.invoke(r));

    }
}
