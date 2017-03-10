package edu.cornell.tech.foundry.researchsuitetaskbuilder.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBElementGeneratorServiceProvider.spi.RSTBElementGenerator;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 12/22/16.
 */
public abstract class RSTBBaseElementGenerator implements RSTBElementGenerator {

    protected List<String> supportedTypes;

    public boolean supportsType(String type) {
        return this.supportedTypes.contains(type);
    }

    public List<String> supportedStepTypes() {
        return this.supportedTypes;
    }

    public abstract JsonArray generateElements(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);

}
