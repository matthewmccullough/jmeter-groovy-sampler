package com.ambientideas.jmeter;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.FileEditor;
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

		PropertyDescriptor p = property("utilityScriptFilename");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "yourutilityscriptnamegoeshere.groovy");
        p.setValue(NOT_EXPRESSION, Boolean.TRUE);
        p.setPropertyEditorClass(FileEditor.class);

        p = property("setupScriptFilename");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "youroptionalsetupscriptnamegoeshere.groovy");
        p.setValue(NOT_EXPRESSION, Boolean.TRUE);
        p.setPropertyEditorClass(FileEditor.class);

        p = property("primaryScriptFilename");
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "yourprimaryscriptnamegoeshere.groovy");
        p.setValue(NOT_EXPRESSION, Boolean.TRUE);
        p.setPropertyEditorClass(FileEditor.class);
    }
}
