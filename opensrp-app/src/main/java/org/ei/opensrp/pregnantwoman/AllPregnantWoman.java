package org.ei.opensrp.pregnantwoman;

/**
 * Created by YCCE on 18/04/16.
 */
import org.ei.opensrp.pregnantwoman.PregnantWoman;
import org.ei.opensrp.repository.*;
import java.util.List;
import java.util.Map;

public class AllPregnantWoman {
    private Pregnant_woman_repository pregnant_woman_repository;
    private final TimelineEventRepository timelineEventRepository;
    private final AlertRepository alertRepository;

    public AllPregnantWoman(Pregnant_woman_repository pregnant_woman_repository,
                            AlertRepository alertRepository, TimelineEventRepository timelineEventRepository) {
        this.pregnant_woman_repository = pregnant_woman_repository;
        this.timelineEventRepository = timelineEventRepository;
        this.alertRepository = alertRepository;
    }

    public List<PregnantWoman> all() {
        return pregnant_woman_repository.allPregnantWoman();
        }

    public PregnantWoman findByCaseID(String caseId) {
        return pregnant_woman_repository.findByCaseID(caseId);
        }

    public long count() {
        return pregnant_woman_repository.count();
        }

    public List<PregnantWoman> findByCaseIDs(List<String> caseIds) {
        return pregnant_woman_repository.findByCaseIDs(caseIds.toArray(new String[caseIds.size()]));
        }


    public void close(String entityId) {
        alertRepository.deleteAllAlertsForEntity(entityId);
        timelineEventRepository.deleteAllTimelineEventsForEntity(entityId);
        pregnant_woman_repository.close(entityId);
        }

    public void mergeDetails(String entityId, Map<String, String> details) {
        pregnant_woman_repository.mergeDetails(entityId, details);
    }
}