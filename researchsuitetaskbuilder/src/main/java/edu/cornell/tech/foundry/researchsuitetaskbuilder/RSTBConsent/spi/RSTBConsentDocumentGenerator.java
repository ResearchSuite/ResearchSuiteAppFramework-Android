package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent.spi;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import org.researchstack.backbone.model.ConsentDocument;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 8/23/17.
 */

public interface RSTBConsentDocumentGenerator {

    @Nullable
    ConsentDocument generate(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject);
    boolean supportsType(String type);

}
