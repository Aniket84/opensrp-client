package org.ei.opensrp.SteppingStoneChildrens;

import com.google.gson.Gson;

import org.ei.opensrp.SteppingStoneChildrens.SteppingStoneChildren;
import org.ei.opensrp.repository.AllBeneficiaries;
import org.ei.opensrp.SteppingStoneChildrens.AllSteppingStoneChildren;
import org.ei.opensrp.util.Cache;
import org.ei.opensrp.util.CacheableData;
import org.ei.opensrp.view.contract.SmartRegisterClient;
import org.ei.opensrp.SteppingStoneChildrens.SteppingStoneChildClient;
import org.ei.opensrp.SteppingStoneChildrens.SteppingStoneChildClients;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class SteppingStoneChildSmartRegisterController {

    private static final String EC_CLIENTS_LIST = "ECClientsList";

    private final AllSteppingStoneChildren allEligibleCouples;
    private final AllBeneficiaries allBeneficiaries;
    private final Cache<String> cache;
    private final Cache<SteppingStoneChildClients> ecClientsCache;

    public SteppingStoneChildSmartRegisterController(AllSteppingStoneChildren allEligibleCouples,
                                                     AllBeneficiaries allBeneficiaries, Cache<String> cache,
                                                     Cache<SteppingStoneChildClients> ecClientsCache) {
        this.allEligibleCouples = allEligibleCouples;
        this.allBeneficiaries = allBeneficiaries;
        this.cache = cache;
        this.ecClientsCache = ecClientsCache;
    }

    public String get() {
        return cache.get(EC_CLIENTS_LIST, new CacheableData<String>() {
            @Override
            public String fetch() {
                List<SteppingStoneChildren> ecs = allEligibleCouples.all();
                List<SteppingStoneChildClient> ecClients = new ArrayList<SteppingStoneChildClient>();

                for (SteppingStoneChildren ec : ecs) {

                    SteppingStoneChildClient ecClient = new SteppingStoneChildClient(ec.getCaseId(), ec.details() );

                    updateStatusInformation(ec, ecClient);
               //     updateChildrenInformation(ecClient);
                    ecClients.add(ecClient);
                }
              //  sortByName(ecClients);
                return new Gson().toJson(ecClients);
            }
        });
    }

    //#TODO: Remove duplication
    public SteppingStoneChildClients getClients() {
        return ecClientsCache.get(EC_CLIENTS_LIST, new CacheableData<SteppingStoneChildClients>() {
            @Override
            public SteppingStoneChildClients fetch() {
                List<SteppingStoneChildren> ecs = allEligibleCouples.all();
                SteppingStoneChildClients ecClients = new SteppingStoneChildClients();

                for (SteppingStoneChildren ec : ecs) {

                    SteppingStoneChildClient ecClient = new SteppingStoneChildClient(ec.getCaseId(), ec.details());

                    updateStatusInformation(ec, ecClient);
                   // updateChildrenInformation(ecClient);
                    ecClients.add((SmartRegisterClient) ecClient);
                }
                sortByName(ecClients);
                return ecClients;
            }
        });
    }




    private void sortByName(List<? extends SmartRegisterClient> ecClients) {
        sort(ecClients, new Comparator<SmartRegisterClient>() {
            @Override
            public int compare(SmartRegisterClient oneECClient, SmartRegisterClient anotherECClient) {
                return oneECClient.wifeName().compareToIgnoreCase(anotherECClient.wifeName());
            }
        });
    }

    //#TODO: Needs refactoring
    private void updateStatusInformation(SteppingStoneChildren eligibleCouple, SteppingStoneChildClient ecClient) {
       /* Mother mother = allBeneficiaries.findMotherWithOpenStatusByECId(eligibleCouple.caseId());

        if (mother == null && !eligibleCouple.hasFPMethod()) {
            ecClient.withStatus(EasyMap.create(STATUS_TYPE_FIELD, EC_STATUS)
                    .put(STATUS_DATE_FIELD, eligibleCouple.getDetail(REGISTRATION_DATE)).map());
            return;
        }

        if (mother == null && eligibleCouple.hasFPMethod()) {
            ecClient.withStatus(EasyMap.create(STATUS_TYPE_FIELD, FP_STATUS)
                    .put(STATUS_DATE_FIELD, eligibleCouple.getDetail(FAMILY_PLANNING_METHOD_CHANGE_DATE)).map());
            return;
        }

        if (mother != null && mother.isANC()) {
            ecClient.withStatus(EasyMap.create(STATUS_TYPE_FIELD, ANC_STATUS)
                    .put(STATUS_DATE_FIELD, mother.referenceDate())
                    .put(STATUS_EDD_FIELD, LocalDate.parse(mother.getDetail(EDD), DateTimeFormat.forPattern(AllConstants.FORM_DATE_TIME_FORMAT)).toString()).map());
            return;
        }

        if (mother != null && mother.isPNC() && !eligibleCouple.hasFPMethod()) {
            ecClient.withStatus(EasyMap.create(STATUS_TYPE_FIELD, PNC_STATUS)
                    .put(STATUS_DATE_FIELD, mother.referenceDate()).map());
            return;
        }

        if (mother != null && mother.isPNC() && eligibleCouple.hasFPMethod()) {
            ecClient.withStatus(EasyMap.create(STATUS_TYPE_FIELD, PNC_FP_STATUS)
                    .put(STATUS_DATE_FIELD, mother.referenceDate())
                    .put(FP_METHOD_DATE_FIELD, eligibleCouple.getDetail(FAMILY_PLANNING_METHOD_CHANGE_DATE)).map());
        }*/
    }
}
