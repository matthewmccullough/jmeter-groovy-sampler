package com.ambientideas.jmeter;

import org.apache.jmeter.testbeans.BeanInfoSupport;

import java.beans.PropertyDescriptor;

/**
 * This class defines the bean properties that will be visually exposed for this JMeter plugin.
 * <p/>
 * User: Matthew McCullough
 * Date: Nov 10, 2008
 */
public class GroovyScriptSamplerBeanInfo extends BeanInfoSupport {
    public GroovyScriptSamplerBeanInfo() {
        super(GroovyScriptSampler.class);

        createPropertyGroup("groovy_script", new String[]{"filename"});
        PropertyDescriptor p = property("filename");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "yourscriptnamegoeshere.groovy");
        p.setValue(NOT_EXPRESSION, Boolean.TRUE);
    }
}
