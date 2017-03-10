package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBStepGeneratorServiceProvider;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import org.researchstack.backbone.step.Step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBStepGeneratorServiceProvider.spi.RSTBStepGenerator;

/**
 * Created by jameskizer on 12/6/16.
 */

public class RSTBStepGeneratorService {

    private static RSTBStepGeneratorService service;
    private ServiceLoader<RSTBStepGenerator> loader;

    private RSTBStepGeneratorService() {
        this.loader = ServiceLoader.load(RSTBStepGenerator.class);
    }

    public static synchronized RSTBStepGeneratorService getInstance() {
        if (service == null) {
            service = new RSTBStepGeneratorService();
        }
        return service;
    }

    @Nullable
    public
    Step generateStep(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {
        Step step = null;

        try {
            Iterator<RSTBStepGenerator> stepGenerators = loader.iterator();
            while (step == null && stepGenerators.hasNext()) {
                RSTBStepGenerator stepGenerator = stepGenerators.next();
                if (stepGenerator.supportsType(type)) {
                    step = stepGenerator.generateStep(helper, type, jsonObject);
                }
            }
        } catch (ServiceConfigurationError serviceError) {
            step = null;
            serviceError.printStackTrace();
        }

        return step;
    }


    public
    List<String> supportedStepTypes() {
        List<String> supportedTypes = new ArrayList<>();

        try {
            Iterator<RSTBStepGenerator> stepGenerators = loader.iterator();
            while (stepGenerators.hasNext()) {
                RSTBStepGenerator stepGenerator = stepGenerators.next();
                supportedTypes.addAll(stepGenerator.supportedStepTypes());
            }

        } catch (ServiceConfigurationError serviceError) {
            supportedTypes = new ArrayList<>();;
            serviceError.printStackTrace();
        }

        return supportedTypes;
    }

}
