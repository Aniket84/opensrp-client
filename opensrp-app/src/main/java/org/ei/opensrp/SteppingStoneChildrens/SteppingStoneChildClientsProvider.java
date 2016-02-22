package org.ei.opensrp.SteppingStoneChildrens;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import org.ei.opensrp.R;
import org.ei.opensrp.provider.SmartRegisterClientsProvider;
import org.ei.opensrp.view.contract.SmartRegisterClient;
import org.ei.opensrp.view.contract.SmartRegisterClients;
import org.ei.opensrp.view.dialog.FilterOption;
import org.ei.opensrp.view.dialog.ServiceModeOption;
import org.ei.opensrp.view.dialog.SortOption;
import org.ei.opensrp.view.viewHolder.OnClickFormLauncher;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.widget.TextView;

public class SteppingStoneChildClientsProvider implements SmartRegisterClientsProvider {

    private final LayoutInflater inflater;
    private final Context context;
    private final View.OnClickListener onClickListener;

    private final int txtColorBlack;
    private final AbsListView.LayoutParams clientViewLayoutParams;

    protected SteppingStoneChildSmartRegisterController controller;

    private Drawable iconPencilDrawable;

    public SteppingStoneChildClientsProvider(Context context,
                                             View.OnClickListener onClickListener,
                                             SteppingStoneChildSmartRegisterController controller) {
        this.onClickListener = onClickListener;
        this.controller = controller;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        clientViewLayoutParams = new AbsListView.LayoutParams(MATCH_PARENT,
                (int) context.getResources().getDimension(R.dimen.list_item_height));
        txtColorBlack = context.getResources().getColor(R.color.text_black);
    }

    @Override
    public View getView(SmartRegisterClient smartRegisterClient, View convertView, ViewGroup viewGroup) {
        ViewGroup itemView;

        itemView = (ViewGroup) inflater().inflate(R.layout.smart_register_ss_child_client, null);
        TextView id = (TextView)itemView.findViewById(R.id.id);
        TextView name = (TextView)itemView.findViewById(R.id.name);
        TextView age = (TextView)itemView.findViewById(R.id.age);
        TextView uid = (TextView)itemView.findViewById(R.id.uid);
        TextView dob = (TextView)itemView.findViewById(R.id.dob);

        SteppingStoneChildClient client = (SteppingStoneChildClient) smartRegisterClient;
        id.setText(client.caseid());
        name.setText(client.details("Name")!=null?client.details("Name"):"");
        age.setText(client.details("Age")!=null?client.details("Age"):"");
        uid.setText(client.details("UID")!=null?client.details("UID"):"");
        dob.setText(client.details("DOB")!=null?client.details("DOB"):"");

        itemView.setLayoutParams(clientViewLayoutParams);
        return itemView;
    }



    @Override
    public SmartRegisterClients getClients() {
        return controller.getClients();
    }
    @Override
    public SmartRegisterClients updateClients(FilterOption villageFilter, ServiceModeOption serviceModeOption,
                                              FilterOption searchFilter, SortOption sortOption) {
        return getClients().applyFilter(villageFilter, serviceModeOption, searchFilter, sortOption);
    }

    @Override
    public void onServiceModeSelected(ServiceModeOption serviceModeOption) {
        // do nothing.
    }

    @Override
    public OnClickFormLauncher newFormLauncher(String formName, String entityId, String metaData) {
        return null;
    }

    public LayoutInflater inflater() {
        return inflater;
    }
}
