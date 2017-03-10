package edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators;

import com.google.gson.JsonObject;

import org.researchstack.backbone.step.Step;

import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBStepGeneratorServiceProvider.spi.RSTBStepGenerator;

/**
 * Created by jameskizer on 12/6/16.
 */
public abstract class RSTBBaseStepGenerator implements RSTBStepGenerator {
    protected List<String> supportedTypes;

    public boolean supportsType(String type) {
        return this.supportedTypes.contains(type);
    }

    public List<String> supportedStepTypes() {
        return this.supportedTypes;
    }

    public abstract Step generateStep(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);
}
