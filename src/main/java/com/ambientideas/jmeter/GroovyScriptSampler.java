package com.ambientideas.jmeter;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;

/**
 * Document me.
 * <br>
 * User: Matthew McCullough, matthewm@ambientideas.com
 * Date: Nov 10, 2008
 */
public class GroovyScriptSampler extends AbstractSampler implements TestBean {

    private static final String FILENAME = "GroovyScriptSampler.filename"; //$NON-NLS-1$

    public String getFilename() {
        return getPropertyAsString(FILENAME);
    }

    public void setFilename(String newFilename) {
        this.setProperty(FILENAME, newFilename);
    }

    public SampleResult sample(Entry e) {
        final String label = getName();
        final String fileName = getFilename();

        SampleResult result = new SampleResult();
        result.setSampleLabel(label);

        result.setResponseCode("200"); // $NON-NLS-1$
        result.setResponseMessage("OK"); // $NON-NLS-1$
        result.setSuccessful(true);
        result.setDataType(SampleResult.TEXT);

        result.sampleStart();
        //Run the groovy script
        try {
            //Get the classloader of JMeter, where we have put all the Groovy JARs
            ClassLoader parent = getClass().getClassLoader();
            GroovyClassLoader loader = new GroovyClassLoader(parent);
            System.out.println("Sampler loading groovy file: " + fileName);
            Class<?> groovyClass = loader.parseClass(new File(fileName));

            // let's call some method on an instance
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            Object[] args = {};
            groovyObject.invokeMethod("run", args);
        }
        catch (Exception ex) {
			String stackTrace = buildStackTraceString(ex);
			System.out.println("Groovy exception: " + stackTrace);
            //Problem encountered, so set the error statuses into the result
            result.setSuccessful(false);
            result.setResponseCode("500"); // $NON-NLS-1$
            result.setResponseMessage(stackTrace);
        }
        finally {
            result.sampleEnd();
        }

        return result;
    }

    public static String buildStackTraceString(Throwable t)
    {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
