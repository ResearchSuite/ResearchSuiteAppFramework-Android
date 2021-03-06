package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent.spi;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import org.researchstack.backbone.model.ConsentDocument;
import org.researchstack.backbone.model.ConsentSignature;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 8/28/17.
 */

public interface RSTBConsentSignatureGenerator {

    @Nullable
    ConsentSignature generate(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);
    boolean supportsType(String type);

}
