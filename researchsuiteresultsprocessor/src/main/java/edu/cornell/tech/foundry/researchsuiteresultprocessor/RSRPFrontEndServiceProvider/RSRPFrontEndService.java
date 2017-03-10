package edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.result.TaskResult;
import org.researchstack.backbone.step.Step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.spi.RSRPFrontEnd;
import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPIntermediateResult;
import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPResultTransform;
import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPResultTransformInputMapping;

/**
 * Created by jameskizer on 2/2/17.
 */
public class RSRPFrontEndService {

    private static RSRPFrontEndService service;
    private ServiceLoader<RSRPFrontEnd> loader;

    private RSRPFrontEndService() {
        this.loader = ServiceLoader.load(RSRPFrontEnd.class);
    }

    public static synchronized RSRPFrontEndService getInstance() {
        if (service == null) {
            service = new RSRPFrontEndService();
        }
        return service;
    }

    public List<RSRPIntermediateResult> processResult(TaskResult taskResult, List<RSRPResultTransform> resultTransforms) {

        List<RSRPIntermediateResult> intermediateResults = new ArrayList<>();

        for (RSRPResultTransform transform : resultTransforms) {

            Map<String, StepResult> selectedResults = new HashMap<String, StepResult>();

            for (RSRPResultTransformInputMapping inputMapping : transform.getInputMapping()) {

                StepResult result = taskResult.getStepResult(inputMapping.getStepIdentifier());
                if (result != null) {
                    selectedResults.put(inputMapping.getParameter(), result);
                }

            }

            RSRPIntermediateResult intermediateResult = this.transform(transform.getTransform(), selectedResults);
            if (intermediateResult != null) {
                intermediateResults.add(intermediateResult);
            }

        }

        return intermediateResults;

    }

    @Nullable
    private RSRPIntermediateResult transform(String type, Map<String,StepResult> parameters) {

        try {
            Iterator<RSRPFrontEnd> frontEnds = this.loader.iterator();

            boolean hasNext = frontEnds.hasNext();

            while (parameters != null && frontEnds.hasNext()) {
                RSRPFrontEnd frontEnd = frontEnds.next();
                if (frontEnd.supportsType(type)) {
                    RSRPIntermediateResult intermediateResult = frontEnd.transform(parameters);
                    if (intermediateResult != null) {
                        return intermediateResult;
                    }
                }
            }
        } catch (ServiceConfigurationError serviceError) {
            serviceError.printStackTrace();
            return null;
        }

        return null;

    }
}
