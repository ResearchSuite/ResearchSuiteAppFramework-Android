package edu.cornell.tech.foundry.researchsuiteresultprocessor;

import android.content.Context;
import android.util.Log;

import org.researchstack.backbone.ResourcePathManager;
import org.researchstack.backbone.result.TaskResult;

import java.util.List;

import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.RSRPFrontEndService;
import edu.cornell.tech.foundry.researchsuiteresultprocessor.RSRPFrontEndServiceProvider.spi.RSRPFrontEnd;

/**
 * Created by jameskizer on 2/3/17.
 */
public class RSRPResultsProcessor {

    private static final String TAG = "RSRPResultsProcessor";
    private Context context;
    private RSRPBackEnd backEnd;

    public RSRPResultsProcessor(RSRPBackEnd backEnd) {
        this.backEnd = backEnd;
    }

    public void processResult(Context context, TaskResult taskResult, List<RSRPResultTransform> resultTransforms) {
        List<RSRPIntermediateResult> intermediateResults = RSRPFrontEndService.getInstance().processResult(taskResult, resultTransforms);
        for (RSRPIntermediateResult intermediateResult : intermediateResults) {
            this.backEnd.add(context, intermediateResult);
        }

        Log.d(TAG, "Processed results");

    }

}
