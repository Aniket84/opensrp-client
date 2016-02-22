package org.ei.opensrp.service;

/**
 * Created by Asus on 19-02-2016.
 */
import org.ei.opensrp.AllConstants;
import org.ei.opensrp.domain.TimelineEvent;
import org.ei.opensrp.domain.form.FormSubmission;
import org.ei.opensrp.repository.AllBeneficiaries;
import org.ei.opensrp.SteppingStoneChildrens.AllSteppingStoneChildren;
import org.ei.opensrp.repository.AllTimelineEvents;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class SteppingStoneChildService {

    private final AllSteppingStoneChildren allSteppingStoneChildren;
    private final AllTimelineEvents allTimelineEvents;
    private final AllBeneficiaries allBeneficiaries;

    public SteppingStoneChildService(AllSteppingStoneChildren allSteppingStoneChildren, AllTimelineEvents allTimelineEvents,
                                     AllBeneficiaries allBeneficiaries) {
        this.allSteppingStoneChildren = allSteppingStoneChildren;
        this.allTimelineEvents = allTimelineEvents;
        this.allBeneficiaries = allBeneficiaries;
    }

    public void register(FormSubmission submission) {
        if (isNotBlank(submission.getFieldValue(AllConstants.CommonFormFields.SUBMISSION_DATE))) {
            allTimelineEvents.add(TimelineEvent.forECRegistered(submission.entityId(), submission.getFieldValue(AllConstants.CommonFormFields.SUBMISSION_DATE)));
        }
    }

    public void closePregnantwoman(FormSubmission submission) {
        allSteppingStoneChildren.close(submission.entityId());
        //allBeneficiaries.closeAllMothersForEC(submission.entityId());
    }
}
