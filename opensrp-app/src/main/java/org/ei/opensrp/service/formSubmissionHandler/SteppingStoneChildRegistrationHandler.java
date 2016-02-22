package org.ei.opensrp.service.formSubmissionHandler;

import org.ei.opensrp.domain.form.FormSubmission;
import org.ei.opensrp.service.EligibleCoupleService;
import org.ei.opensrp.service.formSubmissionHandler.FormSubmissionHandler;
import org.ei.opensrp.service.SteppingStoneChildService;

public class SteppingStoneChildRegistrationHandler implements FormSubmissionHandler {
    private SteppingStoneChildService ssChildService;

    public SteppingStoneChildRegistrationHandler(SteppingStoneChildService ssChildService) {
        this.ssChildService = ssChildService;
    }

    @Override
    public void handle(FormSubmission submission) {
        ssChildService.register(submission);
    }
}
