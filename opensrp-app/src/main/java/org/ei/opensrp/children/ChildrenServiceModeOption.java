package org.ei.opensrp.children;

import android.view.View;

import org.ei.opensrp.R;
import org.ei.opensrp.provider.SmartRegisterClientsProvider;
import org.ei.opensrp.view.contract.ANCSmartRegisterClient;
import org.ei.opensrp.view.contract.ChildSmartRegisterClient;
import org.ei.opensrp.view.contract.FPSmartRegisterClient;
import org.ei.opensrp.view.contract.pnc.PNCSmartRegisterClient;
import org.ei.opensrp.view.dialog.ServiceModeOption;
import org.ei.opensrp.view.viewHolder.NativeANCSmartRegisterViewHolder;
import org.ei.opensrp.view.viewHolder.NativeChildSmartRegisterViewHolder;
import org.ei.opensrp.view.viewHolder.NativeFPSmartRegisterViewHolder;
import org.ei.opensrp.view.viewHolder.NativePNCSmartRegisterViewHolder;

import static org.ei.opensrp.view.activity.SecuredNativeSmartRegisterActivity.ClientsHeaderProvider;

public class ChildrenServiceModeOption extends ServiceModeOption {

    public ChildrenServiceModeOption(SmartRegisterClientsProvider provider) {
        super(provider);
    }

    @Override
    public String name() {
        return "All Children Details";
    }

    @Override
    public ClientsHeaderProvider getHeaderProvider() {
        return new ClientsHeaderProvider() {
            @Override
            public int count() {
                return 3;
            }

            @Override
            public int weightSum() {
                return 7;
            }

            @Override
            public int[] weights() {
                return new int[]{3,3,1};
            }

            @Override
            public int[] headerTextResourceIds() {
                return new int[]{
                       R.string.ChildHeader, R.string.childage,
                       R.string.space};
            }
        };
    }

    @Override
    public void setupListView(ChildSmartRegisterClient client,
                              NativeChildSmartRegisterViewHolder viewHolder,
                              View.OnClickListener clientSectionClickListener) {

    }

    @Override
    public void setupListView(ANCSmartRegisterClient client, NativeANCSmartRegisterViewHolder viewHolder, View.OnClickListener clientSectionClickListener) {

    }

    @Override
    public void setupListView(FPSmartRegisterClient client, NativeFPSmartRegisterViewHolder viewHolder, View.OnClickListener clientSectionClickListener) {

    }

    @Override
    public void setupListView(PNCSmartRegisterClient client, NativePNCSmartRegisterViewHolder viewHolder, View.OnClickListener clientSectionClickListener) {

    }


}