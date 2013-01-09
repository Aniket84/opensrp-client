package org.ei.drishti.domain;

import org.ei.drishti.Context;
import org.ei.drishti.view.contract.Beneficiary;

import java.util.List;

import static org.ei.drishti.view.controller.ProfileNavigationController.*;

public enum ReportIndicator {
    IUD("IUD", "IUD Adoption") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigateToECProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchECCaseList(caseIds);
        }
    },
    CONDOM("CONDOM", "Condom Usage") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigateToECProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchECCaseList(caseIds);
        }
    },
    OCP("OCP", "Oral Pills") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigateToECProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchECCaseList(caseIds);
        }
    },
    MALE_STERILIZATION("MALE_STERILIZATION", "Male Sterilization") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigateToECProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchECCaseList(caseIds);
        }
    },
    FEMALE_STERILIZATION("FEMALE_STERILIZATION", "Female Sterilization") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigateToECProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchECCaseList(caseIds);
        }
    },
    DPT1("DPT_1", "DPT 1") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    DPT2("DPT_2", "DPT 2") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    DPT3("DPT_3", "DPT 3") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    DPT3_OR_OPV3("DPT3_OPV3", "DPT 3 / OPV 3") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    DPT_BOOSTER_OR_OPV_BOOSTER("DPTB_OPVB", "DPT Booster / OPV Booster") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    DPT_BOOSTER2("DPT_BOOSTER_2", "DPT Booster 2") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    HEP("HEP", "HEP") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    OPV("OPV", "OPV") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }


        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    MEASLES("MEASLES", "MEASLES") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    VIT_A_1("VIT_A_1", "First Dose of Vitamin A") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    VIT_A_2("VIT_A_1", "Second Dose of Vitamin A") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    WEIGHED_AT_BIRTH("WEIGHED_AT_BIRTH", "Number of infants weighed at birth") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    BF_POST_BIRTH("BF_POST_BIRTH", "Exclusively BF within 1 hr of birth") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    BCG("BCG", "BCG") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    EARLY_ANC_REGISTRATIONS("ANC<12", "Early ANC Registration") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    ANC_REGISTRATIONS("ANC", "Late ANC Registration") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    ANC4("ANC4", "Minimum 4 ANC Visits") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    SUB_TT("SUB_TT", "TT2 and TT Booster (Pregnant Women)") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    TT1("TT1", "TT1") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    TT2("TT2", "TT2") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    TTB("TTB", "TT Booster") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    INFANT_MORTALITY("IM", "Infant Mortality") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    ENM("ENM", "Early Neonatal mortality") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    NM("NM", "Neonatal mortality") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    LNM("LNM", "29 days to 1 year of birth") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    CHILD_MORTALITY("UFM", "Under 5 mortality") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    LIVE_BIRTH("LIVE_BIRTH", "Live Birth") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    STILL_BIRTH("STILL_BIRTH", "Still Birth") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    LBW("LBW", "Low Birth Weight") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToChildProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchChildCaseList(caseIds);
        }
    },
    EARLY_ABORTIONS("MTP<12", "Abortions before 12 weeks") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    LATE_ABORTIONS("MTP>12", "Abortions after 12 weeks") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    SPONTANEOUS_ABORTION("SPONTANEOUS_ABORTION", "Spontaneous abortions") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToANCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    DELIVERY("DELIVERY", "Total Deliveries") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    MMA("MMA", "Mother mortality (during ANC)") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    MMD("MMD", "Mother mortality (during Delivery)") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    MMP("MMP", "Mother mortality (during PNC)") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    MM("MM", "Total Mother Mortality ") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    INSTITUTIONAL_DELIVERY("INSTITUTIONAL_DELIVERY", "Institutional Deliveries") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    PNC3("PNC3", "No. of PNC women who received 3 visits") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_HOM("D_HOM", "Number of deliveries conducted at Home") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_SC("D_SC", "Number of deliveries conducted at Sub Center") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_PHC("D_PHC", "Number of deliveries conducted at Public Health Center") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_CHC("D_CHC", "Number of deliveries conducted at Community Health Center") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_SDH("D_SDH", "Number of deliveries conducted at Sub District Hospital") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_DH("D_DH", "Number of deliveries conducted at District Hospital") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    },
    D_PRI("D_PRI", "Number of deliveries conducted at Private facility") {
        @Override
        public void startCaseDetailActivity(android.content.Context context, String caseId) {
            navigationToPNCProfile(context, caseId);
        }

        @Override
        public List<Beneficiary> fetchCaseList(List<String> caseIds) {
            return fetchMotherCaseList(caseIds);
        }
    };

    private String value;

    private String description;

    ReportIndicator(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String description() {
        return description;
    }

    public String value() {
        return value;
    }

    public abstract List<Beneficiary> fetchCaseList(List<String> caseIds);

    public abstract void startCaseDetailActivity(android.content.Context context, String caseId);

    private static List<Beneficiary> fetchECCaseList(List<String> caseIds) {
        return Context.getInstance().beneficiaryService().fetchFromEcCaseIds(caseIds);
    }

    private static List<Beneficiary> fetchMotherCaseList(List<String> caseIds) {
        return Context.getInstance().beneficiaryService().fetchFromMotherCaseIds(caseIds);
    }

    private static List<Beneficiary> fetchChildCaseList(List<String> caseIds) {
        return Context.getInstance().beneficiaryService().fetchFromChildCaseIds(caseIds);
    }

    public static ReportIndicator parseToReportIndicator(String indicator) {
        for (ReportIndicator reportIndicator : values()) {
            if (reportIndicator.value().equalsIgnoreCase(indicator))
                return reportIndicator;
        }
        throw new IllegalArgumentException("Could not find ReportIndicator for value: " + indicator);
    }
}
