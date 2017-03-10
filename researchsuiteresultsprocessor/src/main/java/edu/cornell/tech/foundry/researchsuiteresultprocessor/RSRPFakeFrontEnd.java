package edu.cornell.tech.foundry.researchsuiteresultprocessor;

import org.researchstack.backbone.result.StepResult;

import java.util.Map;

import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.spi.RSRPFrontEnd;

/**
 * Created by jameskizer on 2/4/17.
 */
public class RSRPFakeFrontEnd implements RSRPFrontEnd {


    @Override
    public RSRPIntermediateResult transform(Map<String, StepResult> parameters) {
        return null;
    }

    @Override
    public boolean supportsType(String type) {
        return false;
    }
}
