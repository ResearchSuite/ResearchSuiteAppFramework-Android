package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBStepGeneratorServiceProvider.spi;

import com.google.gson.JsonObject;

import org.researchstack.backbone.step.Step;

import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 12/6/16.
 */
public interface RSTBStepGenerator {
    Step generateStep(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);
    boolean supportsType(String type);
    List<String> supportedStepTypes();
}
