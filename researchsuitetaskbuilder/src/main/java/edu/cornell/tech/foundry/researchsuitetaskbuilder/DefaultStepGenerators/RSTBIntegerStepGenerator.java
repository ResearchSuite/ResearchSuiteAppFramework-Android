package edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators;

import com.google.gson.JsonObject;

import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.answerformat.IntegerAnswerFormat;

import java.util.Arrays;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBIntegerStepDescriptor;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 12/7/16.
 */
public class RSTBIntegerStepGenerator extends RSTBQuestionStepGenerator {


    public RSTBIntegerStepGenerator()
    {
        super();
        this.supportedTypes = Arrays.asList(
                "numericInteger"
        );
    }

    public AnswerFormat generateAnswerFormat(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {

        RSTBIntegerStepDescriptor integerStepDescriptor = helper.getGson().fromJson(jsonObject, RSTBIntegerStepDescriptor.class);

        IntegerAnswerFormat answerFormat = new IntegerAnswerFormat(integerStepDescriptor.range.min, integerStepDescriptor.range.max);

        return answerFormat;

    }

}
