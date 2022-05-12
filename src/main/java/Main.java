import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        TestAnnotation testAnnotation = new TestAnnotation();
        Class<?> annotationClass = Class.forName("TestAnnotation");
        start(annotationClass, testAnnotation);
    }

    private static void start(Class<?> annotationClass, TestAnnotation testAnnotation) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = annotationClass.getDeclaredMethods();
        List<Method> methodsList = new ArrayList<>();
        int beforeSuiteCounter = 0;
        int afterSuiteCounter = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                methodsList.add(method);
            }
        }

        Collections.sort(methodsList, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
            }
        });

        for (Method method : methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)){
                beforeSuiteCounter++;
                if(beforeSuiteCounter == 2){
                    throw new RuntimeException();
                }
                methodsList.add(0, method);
            }else if(method.isAnnotationPresent(AfterSuite.class)){
                afterSuiteCounter++;
                if(afterSuiteCounter == 2){
                    throw new RuntimeException();
                }
                methodsList.add(method);
            }
        }

        for (Method method : methodsList) {
            if(method.isAnnotationPresent(BeforeSuite.class)){
                System.out.println("Method name: " + method.getName());
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                System.out.println("Method name: " + method.getName());
            } else if (method.isAnnotationPresent(Test.class)) {

                System.out.println("Method name: " + method.getName() + ", priority: " + method.getAnnotation(Test.class).priority());
            }
        }

    }

}
