/*
The whole purpose of this class is to transform a notations on runtime, so that the retry analyzer would be applied to each test on the runtime
This will implement IAnnotation transformer
 */
package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)
    {
        //TestNG will apply this retry analyzer for all the failed test cases
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
