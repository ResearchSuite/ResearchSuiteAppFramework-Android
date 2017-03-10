package edu.cornell.tech.foundry.researchsuiteresultprocessor;

import java.util.List;

/**
 * Created by jameskizer on 2/2/17.
 */
public class RSRPResultTransform {

    private String transform;
    private List<RSRPResultTransformInputMapping> inputMapping;

    public RSRPResultTransform() {

    }

    public String getTransform() {
        return transform;
    }

    public List<RSRPResultTransformInputMapping> getInputMapping() {
        return inputMapping;
    }
}
