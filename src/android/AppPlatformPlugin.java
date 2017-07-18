package inspur.chinamobile.sd.cordova.plugin;

import org.apache.cordova.*;
import org.json.*;
import java.util.*;
import android.content.*;
import android.util.*;

import droid.app.hp.api.platform.Platform;
import droid.app.hp.api.platform.Platform.PlatformCallback;

public class AppPlatformPlugin extends CordovaPlugin {
	private String packageName = "";
	private Platform platform;
	private CallbackContext cb;
  private String type = "connect";

	PlatformCallback callback = new PlatformCallback() {
		@Override
		public void onSuccess(String response) {
      if ("connect".equals(type)) {
        // getInstance callback do Nothing
      }
      else{
        cb.success(response);
      }
		}
		@Override
		public void onFailure(String response) {
			cb.error(response);
		}
		@Override
		public void onServiceConnected() {
      type = "userInfo";
			platform.getUserInfo(packageName);
		}
	};

	public boolean execute(String action, JSONArray args, final CallbackContext cb) throws JSONException {

		if("setPackageName".equals(action)){
			this.cb = cb;
			this.packageName = args.getString(0);
            this.type = "connect";
			platform = Platform.getInstance(this.cordova.getActivity().getApplicationContext(), callback);
			platform.bindService();
			return true;
		} else if("getTel".equals(action)) {
			String brobandTel = this.cordova.getActivity().getIntent().getStringExtra("brobandTel");
			cb.success(brobandTel);
			return true;
		}

		return false;
	}
}
