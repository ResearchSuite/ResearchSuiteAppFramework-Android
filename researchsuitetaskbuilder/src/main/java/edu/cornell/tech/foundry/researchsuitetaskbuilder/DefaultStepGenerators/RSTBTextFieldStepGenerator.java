package edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators;

import com.google.gson.JsonObject;

import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.answerformat.TextAnswerFormat;

import java.util.Arrays;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBTextFieldStepDescriptor;

/**
 * Created by jameskizer on 12/7/16.
 */
public class RSTBTextFieldStepGenerator extends RSTBQuestionStepGenerator {

    public RSTBTextFieldStepGenerator()
    {
        super();
        this.supportedTypes = Arrays.asList(
                "textfield"
        );
    }

    public AnswerFormat generateAnswerFormat(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {

        RSTBTextFieldStepDescriptor textFieldStepDescriptor = helper.getGson().fromJson(jsonObject, RSTBTextFieldStepDescriptor.class);

        TextAnswerFormat answerFormat = new TextAnswerFormat(textFieldStepDescriptor.maximumLength);
        answerFormat.setIsMultipleLines(textFieldStepDescriptor.multipleLines);

        return answerFormat;

    }

}
