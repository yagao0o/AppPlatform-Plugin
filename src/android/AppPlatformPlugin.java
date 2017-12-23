package inspur.chinamobile.sd.cordova.plugin;

import org.apache.cordova.*;
import org.json.*;
import java.util.*;
import android.content.*;
import android.util.*;
import android.os.Bundle;
import android.widget.Toast;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
		}
    else if("getToken".equals(action)) {
			String token = this.cordova.getActivity().getIntent().getStringExtra("token");
			cb.success(token);
			return true;
		}
    else if("startCamera".equals(action)) {
      //启动掌上拍照
			String formNo = args.getString(0);//工单编号
			String flowId = args.getString(1);//工单流水号
			String htName = args.getString(2);//环节名称
			String tkiid = args.getString(3);//工作项ID
			String templateName = args.getString(4);//工单分类
			String token = args.getString(5);//掌上运维平台登录的token
			boolean isReupload = args.getBoolean(6);//是否重新上传
			Bundle bundle = new Bundle();
			bundle.putString("formNo", formNo);
			bundle.putString("flowId", flowId);
			bundle.putString("htName", htName);
			bundle.putString("tkiid", tkiid);
			bundle.putString("templateName", templateName);
			bundle.putString("token", token);
			bundle.putBoolean("isReupload", isReupload);
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(
							"com.inspur.cameraupload",
							"com.inspur.cameraupload.login.LoginActivity"));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			PackageManager pm = this.cordova.getActivity().getPackageManager();
			List<ResolveInfo> activities = pm.queryIntentActivities(intent,
							PackageManager.MATCH_DEFAULT_ONLY);
			if (activities == null || activities.size() < 1) {
				  Toast.makeText(this.cordova.getActivity(), "未安装\"掌上拍照\"", Toast.LENGTH_LONG).show();
					return true;
			}
			this.cordova.getActivity().startActivity(intent);
			return true;
		}
    else if("startCallRecorder".equals(action)) {
      //启动通话录音
			String formNo = args.getString(0);//工单编号
			String flowId = args.getString(1);//工单流水号
			String htName = args.getString(2);//环节名称
			String tkiid = args.getString(3);//工作项ID
			String contacterTel = args.getString(4);//联系人电话
			String templateName = args.getString(5);//工单分类
			String token = args.getString(6);//掌上运维平台登录的token
			Bundle bundle = new Bundle();
			bundle.putString("formNo", formNo);
			bundle.putString("flowId", flowId);
			bundle.putString("htName", htName);
			bundle.putString("tkiid", tkiid);
			bundle.putString("contacterTel", contacterTel);
			bundle.putString("templateName", templateName);
			bundle.putString("token", token);
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(
							"com.inspur.callrecorder",
							"com.inspur.callrecorder.login.LoginActivity"));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			PackageManager pm = this.cordova.getActivity().getPackageManager();
			List<ResolveInfo> activities = pm.queryIntentActivities(intent,
							PackageManager.MATCH_DEFAULT_ONLY);
			if (activities == null || activities.size() < 1) {
				  Toast.makeText(this.cordova.getActivity(), "未安装\"通话录音\"", Toast.LENGTH_LONG).show();
					return true;
			}
			this.cordova.getActivity().startActivity(intent);
			return true;
		}
    else if("startLabelPrint".equals(action)) {
      //启动标签打印
			String houseId4Show = args.getString(0);//房号ID
			String houseName4Show = args.getString(1);//房号信息
			String hold_device_id4show = args.getString(2);//设备ID
			String hold_device_name4show = args.getString(3);//设备信息
			Bundle bundle = new Bundle();
			bundle.putString("houseId4Show", houseId4Show);
			bundle.putString("houseName4Show", houseName4Show);
			bundle.putString("hold_device_id4show", hold_device_id4show);
			bundle.putString("hold_device_name4show", hold_device_name4show);
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(
							"com.label.print",
							"com.label.print.login.LoginActivity"));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			PackageManager pm = this.cordova.getActivity().getPackageManager();
			List<ResolveInfo> activities = pm.queryIntentActivities(intent,
							PackageManager.MATCH_DEFAULT_ONLY);
			if (activities == null || activities.size() < 1) {
				  Toast.makeText(this.cordova.getActivity(), "未安装\"标签打印\"", Toast.LENGTH_LONG).show();
					return true;
			}
			this.cordova.getActivity().startActivity(intent);
			return true;
		}
    else if("openAndroidApp".equals(action)) {
      //启动其他应用
			String packageName = args.getString(0);//packageName
			String activityName = args.getString(1);//activityName
			String token = this.cordova.getActivity().getIntent().getStringExtra("token");
			System.out.println("=================================");
			System.out.println(packageName);
			System.out.println(activityName);
			System.out.println(token);
			System.out.println("=================================");
			Bundle bundle = new Bundle();
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(packageName,activityName));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			intent.putExtra("token", token);
			PackageManager pm = this.cordova.getActivity().getPackageManager();
			List<ResolveInfo> activities = pm.queryIntentActivities(intent,
							PackageManager.MATCH_DEFAULT_ONLY);
			if (activities == null || activities.size() < 1) {
				  Toast.makeText(this.cordova.getActivity(), "调用其他App错误：未安装该应用", Toast.LENGTH_LONG).show();
					return true;
			}
			this.cordova.getActivity().startActivity(intent);
			return true;
		}
		else if("openAndroidAppWithParam".equals(action)) {			
      //启动其他应用
			String packageName = args.getString(0);//packageName
			String activityName = args.getString(1);//activityName
			String params = args.getString(2);//activityName
			System.out.println("=================================");
			System.out.println(packageName);
			System.out.println(activityName);
			System.out.println(params);
			System.out.println(token);
			System.out.println("=================================");
			String token = this.cordova.getActivity().getIntent().getStringExtra("token");
			Bundle bundle = new Bundle();
			Intent intent = new Intent();
			intent.addCategory(Intent.CATEGORY_DEFAULT);
			intent.setComponent(new ComponentName(packageName,activityName));
			intent.putExtras(bundle);
			intent.putExtra("zsyw", "zsyw");
			intent.putExtra("token", token);
			if (params.length() > 0) {
				String[] keyValueList = params.split("&");
				for(int i = 0; i < keyValueList.length; i++){
					String[] keyAndValue = keyValueList[i].split("=");
					intent.putExtra(keyAndValue[0],keyAndValue[1]);
				}
			}
			PackageManager pm = this.cordova.getActivity().getPackageManager();
			List<ResolveInfo> activities = pm.queryIntentActivities(intent,
							PackageManager.MATCH_DEFAULT_ONLY);
			if (activities == null || activities.size() < 1) {
				  Toast.makeText(this.cordova.getActivity(), "调用错误：未安装该应用。", Toast.LENGTH_LONG).show();
					return true;
			}
			this.cordova.getActivity().startActivity(intent);
			return true;
		}

		return false;
	}
}
