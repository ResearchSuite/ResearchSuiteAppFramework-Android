package edu.cornell.tech.foundry.researchsuitetaskbuilder.Elements.descriptors;

import com.google.gson.JsonArray;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBElementDescriptor;

/**
 * Created by jameskizer on 12/22/16.
 */
public class RSTBElementListDescriptor extends RSTBElementDescriptor {


    public JsonArray elements;
    public boolean shuffleElements;
    RSTBElementListDescriptor() {

    }

}
