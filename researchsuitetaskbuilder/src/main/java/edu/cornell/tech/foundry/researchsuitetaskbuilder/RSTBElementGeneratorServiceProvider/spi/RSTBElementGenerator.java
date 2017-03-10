package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBElementGeneratorServiceProvider.spi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 12/22/16.
 */
public interface RSTBElementGenerator {
    JsonArray generateElements(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);
    boolean supportsType(String type);
    List<String> supportedStepTypes();
}
