package org.ei.opensrp.SteppingStoneChildrens;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

public class SteppingStoneChildren {
    private String caseId;

    private Map<String, String> details;




    public SteppingStoneChildren(String caseId, Map<String, String> details) {
        this.caseId = caseId;

        this.details = details;



    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public Map<String, String> details() {
        return details;
    }



    public String getDetail(String name) {
        return details.get(name);
    }







    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
