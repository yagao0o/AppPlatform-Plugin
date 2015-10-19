package inspur.chinamobile.sd.cordova.plugin;

import org.apache.cordova.*;
import org.json.*;
import java.util.*;
import android.content.*;
import android.util.*;

import com.inspur.zsyw.platform.Platform;
import com.inspur.zsyw.platform.Platform.PlatformCallback;

public class AppPlatformPlugin extends CordovaPlugin {
	private String packageName = "";
	private Platform platform;
	private CallbackContext cb;
	
	PlatformCallback callback = new PlatformCallback() {
		@Override
		public void onSuccess(String response) {
			cb.success(response);
		}
		@Override
		public void onFailure(String response) {
			cb.error(response);
		}
		@Override
		public void onServiceConnected() {
			platform.getUserInfo(packageName);
		}
	};
	
	public boolean execute(String action, JSONArray args, final CallbackContext cb) throws JSONException {
		
		if(action.equals("setPackageName")){
			this.cb = cb;
			this.packageName = args.getString(0);
			platform = Platform.getInstance(this.cordova.getActivity().getApplicationContext(), callback);
			platform.bindService();
			return true;
		}
		
		return false;
	}	
}
