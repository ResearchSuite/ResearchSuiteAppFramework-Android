package edu.cornell.tech.foundry.researchsuiteresultprocessor;

import java.util.Date;
import java.util.UUID;

/**
 * Created by jameskizer on 2/2/17.
 */
public class RSRPIntermediateResult {

    private String type;
    private UUID uuid;
    private Date startDate;
    private Date endDate;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public RSRPIntermediateResult(String type) {
        this.type = type;
        this.uuid = UUID.randomUUID();
        this.startDate = new Date();
        this.endDate = new Date();

    }

    public String getType() {
        return type;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
