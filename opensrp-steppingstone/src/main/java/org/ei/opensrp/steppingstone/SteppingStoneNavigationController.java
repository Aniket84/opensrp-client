package org.ei.opensrp.steppingstone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;


import org.ei.opensrp.view.controller.ANMController;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class SteppingStoneNavigationController extends org.ei.opensrp.view.controller.NavigationController {
    private Activity activity;
    private ANMController anmController;

    public SteppingStoneNavigationController(Activity activity, ANMController anmController) {
        super(activity,anmController);
        this.activity = activity;
        this.anmController = anmController;
    }
    @Override
    public void startECSmartRegistry() {

       // activity.startActivity(new Intent(activity, HouseHoldSmartRegisterActivity.class));
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this.activity);


    }
    @Override
    public void startFPSmartRegistry() {
       // activity.startActivity(new Intent(activity, ElcoSmartRegisterActivity.class));
    }
    @Override
    public void startANCSmartRegistry() {
       // activity.startActivity(new Intent(activity, mCareANCSmartRegisterActivity.class));
    }

}
