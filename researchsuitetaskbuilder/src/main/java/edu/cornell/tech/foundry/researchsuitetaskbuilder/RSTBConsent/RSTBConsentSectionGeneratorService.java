package edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent;

import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import org.researchstack.backbone.model.ConsentSection;

import java.util.Iterator;
import java.util.List;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBConsent.spi.RSTBConsentSectionGenerator;
import edu.cornell.tech.foundry.researchsuitetaskbuilder.RSTBTaskBuilderHelper;

/**
 * Created by jameskizer on 8/28/17.
 */

public class RSTBConsentSectionGeneratorService {

    private List<RSTBConsentSectionGenerator> generators;

    public RSTBConsentSectionGeneratorService(List<RSTBConsentSectionGenerator> generators) {
        this.generators = generators;
    }

    @Nullable
    public ConsentSection generate(RSTBTaskBuilderHelper helper, String type, JsonObject jsonObject) {
        Iterator<RSTBConsentSectionGenerator> i = this.generators.iterator();
        while (i.hasNext()) {
            RSTBConsentSectionGenerator generator = i.next();
            if (generator.supportsType(type)) {

                ConsentSection section = generator.generate(helper, type, jsonObject);
                if (section != null) {
                    return section;
                }
            }
        }
        return null;
    }

}
