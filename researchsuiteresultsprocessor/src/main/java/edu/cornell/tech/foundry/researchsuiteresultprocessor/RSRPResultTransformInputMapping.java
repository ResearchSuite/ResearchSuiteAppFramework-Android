package edu.cornell.tech.foundry.researchsuiteresultprocessor;

/**
 * Created by jameskizer on 2/2/17.
 */
public class RSRPResultTransformInputMapping {

    private String stepIdentifier;
    private String parameter;

    public RSRPResultTransformInputMapping(String stepIdentifier, String parameter) {
        this.stepIdentifier = stepIdentifier;
        this.parameter = parameter;
    }

    public String getStepIdentifier() {
        return stepIdentifier;
    }

    public String getParameter() {
        return parameter;
    }
}
