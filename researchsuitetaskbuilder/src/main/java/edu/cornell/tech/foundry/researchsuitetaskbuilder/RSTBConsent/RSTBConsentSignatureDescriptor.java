package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent;

import android.support.annotation.Nullable;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBElementDescriptor;

/**
 * Created by jameskizer on 8/28/17.
 */

public class RSTBConsentSignatureDescriptor extends RSTBElementDescriptor {

    @Nullable
    public String title;

    @Nullable
    public String dateFormatString;

    @Nullable
    public String givenName;

    @Nullable
    public String familyName;

    @Nullable
    public String signatureImageTitle;

    @Nullable
    public String signatureDateString;

    public RSTBConsentSignatureDescriptor() {

    }


}
