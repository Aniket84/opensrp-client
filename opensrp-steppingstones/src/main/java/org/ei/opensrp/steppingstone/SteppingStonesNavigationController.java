package org.ei.opensrp.steppingstone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import org.ei.opensrp.steppingstone.children.NativeChildrenSmartRegisterActivity;

import org.ei.opensrp.view.controller.ANMController;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class SteppingStonesNavigationController extends org.ei.opensrp.view.controller.NavigationController {
    private Activity activity;
    private ANMController anmController;

    public SteppingStonesNavigationController(Activity activity, ANMController anmController) {
        super(activity,anmController);
        this.activity = activity;
        this.anmController = anmController;
    }
    @Override
    public void startECSmartRegistry() {

       activity.startActivity(new Intent(activity, NativeChildrenSmartRegisterActivity.class));
      // SharedPreferences sharedPreferences = getDefaultSharedPreferences(this.activity);


    }
    @Override
    public void startFPSmartRegistry() {
        activity.startActivity(new Intent(activity, NativeChildrenSmartRegisterActivity.class));
    }
    @Override
    public void startANCSmartRegistry() {
      //  activity.startActivity(new Intent(activity, mCareANCSmartRegisterActivity.class));
    }

}
