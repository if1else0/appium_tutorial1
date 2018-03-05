package appium.listeners;

import appium.common.Retry;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RerunListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        IRetryAnalyzer iRetryAnalyzer = iTestAnnotation.getRetryAnalyzer();
        if(iRetryAnalyzer == null){
            //设置重试的类为Retry
            iTestAnnotation.setRetryAnalyzer(Retry.class);
        }
    }
}
