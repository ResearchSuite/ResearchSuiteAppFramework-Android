package edu.cornell.tech.foundry.researchsuitetaskbuilder.Elements;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Arrays;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.Elements.descriptors.RSTBElementFileDescriptor;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.Elements.RSTBBaseElementGenerator;

/**
 * Created by jameskizer on 12/22/16.
 */
public class RSTBElementFileGenerator  extends RSTBBaseElementGenerator {

    public RSTBElementFileGenerator()
    {
        super();
        this.supportedTypes = Arrays.asList(
                "elementFile"
        );
    }

    @Override
    public JsonArray generateElements(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {

        RSTBElementFileDescriptor elementFileDescriptor = helper.getGson().fromJson(jsonObject, RSTBElementFileDescriptor.class);

        JsonElement element = helper.getJsonElementForFilename(elementFileDescriptor.elementFileName);

        if (element.isJsonArray()) {
            return element.getAsJsonArray();
        }
        else if (element.isJsonObject()) {
            JsonArray elements = new JsonArray();
            elements.add(element);
            return elements;
        }
        else {
            return null;
        }

    }
}

