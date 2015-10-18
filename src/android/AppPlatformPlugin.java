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
	private boolean isSuccess = false;
	private String msg = "";
	
	PlatformCallback callback = new PlatformCallback() {
		@Override
		public void onSuccess(String response) {
			isSuccess = true;
			msg = response;
		}
		@Override
		public void onFailure(String response) {
			isSuccess = false;
			msg = response;
		}
		@Override
		public void onServiceConnected() {
			platform.getUserInfo(packageName);
		}
	};
	
	public boolean execute(String action, JSONArray args, final CallbackContext cb) throws JSONException {
		
		if(action.equals("setPackageName")){
			this.packageName = args.getString(0);
			cb.success("[ "  + this.packageName + " ]");
			return true;
		}
		
		if(action.equals("init")){
			platform = Platform.getInstance(this.cordova.getActivity().getApplicationContext(), callback);
			platform.bindService();
			cb.success("Seems good! " + platform.toString());
			return true;
		}
		
		if(action.equals("getInfo")){
			if(isSuccess){
				cb.success(msg);
			}
			else{
				cb.error(msg);
			}
			return true;
		}
		
		return false;
	}	
}
