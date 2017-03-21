package edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.spi;

import android.support.annotation.Nullable;

import java.util.Map;
import java.util.UUID;

import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPIntermediateResult;

/**
 * Created by jameskizer on 2/2/17.
 */
public interface RSRPFrontEnd {

    @Nullable
    public RSRPIntermediateResult transform(
            String taskIdentifier,
            UUID taskRunUUID,
            Map<String,Object> parameters);

    public boolean supportsType(String type);

}
