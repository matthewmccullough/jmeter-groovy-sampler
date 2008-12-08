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

        createPropertyGroup("groovy_script", new String[]{"utilityScriptFilename", "setupScriptFilename", "primaryScriptFilename"});

		PropertyDescriptor usf = property("utilityScriptFilename");
        usf.setValue(NOT_UNDEFINED, Boolean.TRUE);
        usf.setValue(DEFAULT, "yourutilityscriptnamegoeshere.groovy");
        usf.setValue(NOT_EXPRESSION, Boolean.TRUE);

        PropertyDescriptor ssf = property("setupScriptFilename");
        ssf.setValue(NOT_UNDEFINED, Boolean.TRUE);
        ssf.setValue(DEFAULT, "youroptionalsetupscriptnamegoeshere.groovy");
        ssf.setValue(NOT_EXPRESSION, Boolean.TRUE);

		PropertyDescriptor psf = property("primaryScriptFilename");
        psf.setValue(NOT_UNDEFINED, Boolean.TRUE);
        psf.setValue(DEFAULT, "yourprimaryscriptnamegoeshere.groovy");
        psf.setValue(NOT_EXPRESSION, Boolean.TRUE);
    }
}
