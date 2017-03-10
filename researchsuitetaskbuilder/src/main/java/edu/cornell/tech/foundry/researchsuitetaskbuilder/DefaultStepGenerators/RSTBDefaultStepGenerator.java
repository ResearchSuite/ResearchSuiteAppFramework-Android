package edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators;

import android.util.Log;

import com.google.gson.JsonObject;

import org.researchstack.backbone.step.InstructionStep;
import org.researchstack.backbone.step.Step;

import java.util.Arrays;
import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBStepGeneratorServiceProvider.spi.RSTBStepGenerator;

/**
 * Created by jameskizer on 12/6/16.
 */
public class RSTBDefaultStepGenerator implements RSTBStepGenerator {

    private static final String TAG = "RSTBDefaultGen";

    private List<String> supportedTypes;

    public RSTBDefaultStepGenerator()
    {
        this.supportedTypes = Arrays.asList(
        );
    }

    public Step generateStep(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {
        try {
            String identifier = jsonObject.get("identifier").getAsString();

            InstructionStep instructionStep;
            instructionStep = new InstructionStep(identifier, identifier, type);
            return instructionStep;
        }
        catch(Exception e) {
            Log.w(this.TAG, "malformed element: " + jsonObject.getAsString(), e);
            return null;
        }
    }

    public boolean supportsType(String type) {
        return this.supportedTypes.contains(type);
    }


    public List<String> supportedStepTypes() {
        return this.supportedTypes;
    }
}

