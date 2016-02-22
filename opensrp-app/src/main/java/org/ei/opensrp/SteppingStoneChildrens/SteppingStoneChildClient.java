package org.ei.opensrp.SteppingStoneChildrens;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.ei.opensrp.util.DateUtil.formatDate;

public class SteppingStoneChildClient implements SteppingStoneChildSmartRegisterClient {


    private String caseid;

    private Map<String, String> details = new HashMap<String, String>();

    public SteppingStoneChildClient(String caseid,  Map<String, String> details) {
        this.caseid = caseid;
        this.details = details;

    }

    public String caseid() {
        return caseid;
    }


    public String details(String name) {
        return details.get(name);
    }




    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }


    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String entityId() {
        return null;
    }
}
