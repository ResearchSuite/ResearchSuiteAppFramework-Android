package edu.cornell.tech.foundry.researchsuitetaskbuilder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.researchstack.backbone.ResourcePathManager;
import org.researchstack.skin.ResourceManager;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import edu.cornell.tech.foundry.researchsuitetaskbuilder.DefaultStepGenerators.descriptors.RSTBCustomStepDescriptor;

/**
 * Created by jameskizer on 12/8/16.
 */
public class RSTBTaskBuilderHelper {

    private Context context;
    private ResourceManager resourceManager;
    private Gson gson;
    private JsonParser jsonParser;
    private RSTBStateHelper stateHelper;

    RSTBTaskBuilderHelper(Context context, ResourceManager resourceManager, RSTBStateHelper stateHelper) {
        super();
        this.context = context;
        this.resourceManager = resourceManager;
        this.gson = new Gson();
        this.jsonParser = new JsonParser();
        this.stateHelper = stateHelper;
    }

    public Context getContext() {
        return this.context;
    }

    public ResourceManager getResourceManager() {
        return this.resourceManager;
    }

    public Gson getGson() {
        return this.gson;
    }

    //utilities
    @Nullable
    public JsonElement getJsonElementForFilename(String filename) {
        String jsonPath = this.resourceManager.generatePath(ResourcePathManager.Resource.TYPE_JSON, filename);
        InputStream stream = this.resourceManager.getResouceAsInputStream(this.context, jsonPath);
        Reader reader = null;
        try
        {
            reader = new InputStreamReader(stream, "UTF-8");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }

        JsonElement element = null;
        try {
            element = this.jsonParser.parse(reader);
        }
        catch(Exception e) {
            Log.w(this.getClass().getSimpleName(), "could not parse json element", e);
            return null;
        }
        return element;
    }

    @Nullable
    public RSTBCustomStepDescriptor getCustomStepDescriptor(JsonObject jsonObject) {
        RSTBCustomStepDescriptor stepDescriptor = this.getGson().fromJson(jsonObject, RSTBCustomStepDescriptor.class);
        if (stepDescriptor.parameters == null &&
                stepDescriptor.parameterFileName != null &&
                !stepDescriptor.parameterFileName.isEmpty()) {
            JsonElement element = this.getJsonElementForFilename(stepDescriptor.parameterFileName);
            if (element.isJsonObject()) {
                stepDescriptor.parameters = element.getAsJsonObject();
            }
        }
        return stepDescriptor;
    }

    public RSTBStateHelper getStateHelper() {
        return this.stateHelper;
    }

}
