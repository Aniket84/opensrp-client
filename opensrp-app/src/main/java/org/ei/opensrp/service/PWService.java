package org.ei.opensrp.service;

/**
 * Created by YCCE on 18/04/16.
 */
import org.ei.opensrp.AllConstants;
import org.ei.opensrp.pregnantwoman.PregnantWoman;
import org.ei.opensrp.pregnantwoman.*;
import org.ei.opensrp.domain.*;
import org.ei.opensrp.domain.ServiceProvided;
import org.ei.opensrp.domain.form.FormSubmission;
import org.ei.opensrp.domain.form.SubForm;
import org.ei.opensrp.repository.*;
import org.ei.opensrp.util.EasyMap;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.ei.opensrp.AllConstants.ChildIllnessFields.*;
import static org.ei.opensrp.AllConstants.ChildRegistrationECFields.*;
import static org.ei.opensrp.AllConstants.ChildRegistrationOAFields.CHILD_ID;
import static org.ei.opensrp.AllConstants.ChildRegistrationOAFields.THAYI_CARD_NUMBER;
import static org.ei.opensrp.AllConstants.ENTITY_ID_FIELD_NAME;
import static org.ei.opensrp.AllConstants.Immunizations.*;
import static org.ei.opensrp.AllConstants.SPACE;
import static org.ei.opensrp.domain.TimelineEvent.*;



public class PWService {
    private final AllPregnantWoman allPregnantWoman;
    private final AllTimelineEvents allTimelineEvents;
    private final AllBeneficiaries allBeneficiaries;


    public PWService(AllPregnantWoman allPregnantWoman, AllTimelineEvents
            allTimelineEvents, AllBeneficiaries allBeneficiaries) {
        this.allPregnantWoman = allPregnantWoman;
        this.allTimelineEvents = allTimelineEvents;
        this.allBeneficiaries = allBeneficiaries;
    }

    public void register(FormSubmission submission) {
      //  if (isNotBlank(submission.getFieldValue(AllConstants.CommonFormFields.SUBMISSION_DATE))) {
            allTimelineEvents.add(TimelineEvent.forECRegistered(submission.entityId(), submission.getFieldValue(AllConstants.CommonFormFields.SUBMISSION_DATE)));
       // }
    }

    public void closePregnantwoman(FormSubmission submission) {
        allPregnantWoman.close(submission.entityId());
        allBeneficiaries.closeAllMothersForEC(submission.entityId());
    }
}