package edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.spi;

import android.support.annotation.Nullable;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.result.TaskResult;

import java.util.Map;

import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPIntermediateResult;

/**
 * Created by jameskizer on 2/2/17.
 */
public interface RSRPFrontEnd {

    @Nullable
    public RSRPIntermediateResult transform(Map<String,StepResult> parameters);
    public boolean supportsType(String type);

}
