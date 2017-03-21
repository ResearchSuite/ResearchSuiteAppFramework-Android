package edu.cornell.tech.foundry.researchsuiteresultprocessor;

/**
 * Created by jameskizer on 2/2/17.
 */
public class RSRPResultTransformInputMapping {

    private Object constant;
    private String stepIdentifier;
    private String parameter;

    public RSRPResultTransformInputMapping() {

    }

    public String getParameter() {
        return parameter;
    }

    public Object getConstant() {
        return constant;
    }

    public String getStepIdentifier() {
        return stepIdentifier;
    }
}
