package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent;

import android.support.annotation.NonNull;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.researchstack.backbone.model.ConsentDocument;
import org.researchstack.backbone.model.ConsentSection;
import org.researchstack.backbone.model.ConsentSignature;
import org.researchstack.backbone.step.ConsentVisualStep;
import org.researchstack.backbone.step.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBConsentReviewStepDescriptor;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent.spi.RSTBConsentSignatureGenerator;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 8/28/17.
 */

public class RSTBInvestigatorConsentSignatureGenerator implements RSTBConsentSignatureGenerator {

    private List<String> supportedTypes;
    public RSTBInvestigatorConsentSignatureGenerator()
    {
        super();
        this.supportedTypes = Arrays.asList(
                "investigatorConsentSignature"
        );
    }

    public boolean supportsType(String type) {
        return this.supportedTypes.contains(type);
    }

    @Override
    public ConsentSignature generate(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {

        RSTBConsentSignatureDescriptor descriptor = helper.getGson().fromJson(jsonObject, RSTBConsentSignatureDescriptor.class);

        if (descriptor == null) {
            return null;
        }

        //TODO: need to load image and convert to base64
        String signatureImage = "";

        ConsentSignature signature = new ConsentSignature(
                descriptor.identifier,
                descriptor.title,
                descriptor.dateFormatString,
                descriptor.givenName + " " + descriptor.familyName,
                signatureImage,
                descriptor.signatureDateString
        );

        return signature;
    }

}
