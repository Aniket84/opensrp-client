package org.ei.opensrp.SteppingStoneChildrens;


import org.ei.opensrp.SteppingStoneChildrens.SteppingStoneChildren;
import org.ei.opensrp.repository.AlertRepository;
import org.ei.opensrp.repository.TimelineEventRepository;

import java.util.List;
import java.util.Map;

public class AllSteppingStoneChildren {
    private SteppingStoneChildRepository ss_child_repository;
    private final TimelineEventRepository timelineEventRepository ;
    private final AlertRepository alertRepository ;


    public   AllSteppingStoneChildren (SteppingStoneChildRepository ss_child_repository, AlertRepository
            alertRepository, TimelineEventRepository timelineEventRepository)
    {
        this.ss_child_repository=ss_child_repository;
        this.timelineEventRepository = timelineEventRepository;
        this.alertRepository = alertRepository;
    }

    public List<SteppingStoneChildren> all() {
        return ss_child_repository.allSteppingStoneChildren();
    }

    public SteppingStoneChildren findByCaseID(String caseId) {
        return ss_child_repository.findByCaseID(caseId);
    }
    public long count() {
        return ss_child_repository.count();
    }

    public List<SteppingStoneChildren> findByCaseIDs(List<String> caseIds) {
        return ss_child_repository.findByCaseIDs(caseIds.toArray(new String[caseIds.size()]));
    }
    public void close(String entityId) {
        alertRepository.deleteAllAlertsForEntity(entityId);
        timelineEventRepository.deleteAllTimelineEventsForEntity(entityId);
        ss_child_repository.close(entityId);
    }

    public void mergeDetails(String entityId, Map<String, String> details) {
        ss_child_repository.mergeDetails(entityId, details);
    }
}