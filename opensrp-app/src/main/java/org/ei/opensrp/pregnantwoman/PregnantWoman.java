package org.ei.opensrp.pregnantwoman;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.ei.opensrp.AllConstants.BOOLEAN_TRUE;
import static org.ei.opensrp.AllConstants.ECRegistrationFields.*;
import static org.ei.opensrp.AllConstants.SPACE;
/**
 * Created by YCCE on 18/04/16.
 */
public class PregnantWoman {
    private String caseId;
    private Map<String, String> details;
    private boolean isClosed;

    public PregnantWoman(String caseId, Map<String, String> details, String isclosed
    ) {
        this.caseId = caseId;
        this.details = details;
        this.isClosed = new Boolean(isclosed);
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCaseId() {

        return caseId;
    }


    public boolean isHighPriority() {
        return parseDetailFieldValueToBoolean(IS_HIGH_PRIORITY);
    }

    public String highPriorityReason() {
        String highRiskReason = details.get(HIGH_PRIORITY_REASON) == null ? "" :
                details.get(HIGH_PRIORITY_REASON);
        return StringUtils.join(new HashSet<String>(Arrays.asList(highRiskReason.split(SPACE))).toArray(), SPACE);
    }


    public boolean isYoungestChildUnderTwo() {
        return parseDetailFieldValueToBoolean("isYoungestChildUnderTwo");
    }

    private boolean parseDetailFieldValueToBoolean(String fieldName) {
        String isHighPriority = details.get(fieldName);
        return "1".equals(isHighPriority) || BOOLEAN_TRUE.equals(isHighPriority);
    }

    public Map<String, String> details() {
        return details;
    }

    public boolean isClosed() {
        return isClosed;
    }


    public PregnantWoman setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
        return this;
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