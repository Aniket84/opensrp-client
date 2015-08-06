package org.ei.opensrp.service;

import com.google.gson.Gson;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.ei.opensrp.domain.form.FormSubmission;
import org.ei.opensrp.repository.AllSettings;
import org.ei.opensrp.repository.FormDataRepository;

import java.util.List;

import static java.text.MessageFormat.format;
import static org.ei.opensrp.AllConstants.*;
import static org.ei.opensrp.domain.SyncStatus.SYNCED;
import static org.ei.opensrp.util.EasyMap.create;
import static org.ei.opensrp.util.Log.logError;

public class FormSubmissionService {
    private ZiggyService ziggyService;
    private FormDataRepository formDataRepository;
    private AllSettings allSettings;

    public FormSubmissionService(ZiggyService ziggyService, FormDataRepository formDataRepository, AllSettings allSettings) {
        this.ziggyService = ziggyService;
        this.formDataRepository = formDataRepository;
        this.allSettings = allSettings;
    }

    public void processSubmissions(List<FormSubmission> formSubmissions) {
        for (FormSubmission submission : formSubmissions) {
            processSubmissions(submission);
        }
    }

    public void processSubmissions(FormSubmission formSubmission) {
        if (!formDataRepository.submissionExists(formSubmission.instanceId())) {
            try {
                ziggyService.saveForm(getParams(formSubmission), formSubmission.instance());
            } catch (Exception e) {
                logError(format("Form submission processing failed, with instanceId: {0}. Exception: {1}, StackTrace: {2}",
                        formSubmission.instanceId(), e.getMessage(), ExceptionUtils.getStackTrace(e)));
            }
        }
        formDataRepository.updateServerVersion(formSubmission.instanceId(), formSubmission.serverVersion());
        allSettings.savePreviousFormSyncIndex(formSubmission.serverVersion());
    }

    private String getParams(FormSubmission submission) {
        return new Gson().toJson(
                create(INSTANCE_ID_PARAM, submission.instanceId())
                        .put(ENTITY_ID_PARAM, submission.entityId())
                        .put(FORM_NAME_PARAM, submission.formName())
                        .put(VERSION_PARAM, submission.version())
                        .put(SYNC_STATUS, SYNCED.value())
                        .map());
    }
}
