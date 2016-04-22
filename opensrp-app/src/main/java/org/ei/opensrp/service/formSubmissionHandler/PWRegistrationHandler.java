package org.ei.opensrp.service.formSubmissionHandler;

import org.ei.opensrp.domain.form.FormSubmission;
import org.ei.opensrp.service.PWService;

public class PWRegistrationHandler implements FormSubmissionHandler {
    private PWService pwService;
    public PWRegistrationHandler(PWService pwService) {

         this.pwService = pwService;
    }

    @Override
    public void handle(FormSubmission submission) {
        pwService.register(submission);
        }
    }