### 安装
``cordova plugin add https://github.com/yagao0o/AppPlatform-Plugin.git``
### 使用之前  
由于使用原有的javascript和TypeScript调用方式略有不同，在使用TypeScript时，要使用 ``declare var AppPlatform`` 声明这个全局变量，才可以在代码中引用插件的内容。
### 使用方法：
1. 登录掌上运维平台
  ```
  AppPlatform.setPackageName(instance-name, callback)
  ```
  参数：应用包名称。
  返回：Json格式的userinfo,参考Android版本掌上运维平台接入手册。

2. 获取用户登录的Token
  ```
  AppPlatform.getToken(callback)
  ```
  参数：无。
  返回：用户掌上运维平台登录的Token。

3. 打开掌上拍照
  ```
  AppPlatform.startCamera(formNo, flowId, htName, tkiid, templateName, token, isReupload, callback)
  ```
  参数：工单编号,工单流水号,环节名称,工作项ID,工单分类,掌上运维平台登录的token,是否重新上传。
  返回：无。

4. 启动通话录音
  ```
  AppPlatform.startCallRecorder(formNo, flowId, htName, tkiid, contacterTel, templateName, token, callback)
  ```
  参数：工单编号,工单流水号,环节名称,工作项ID,联系人电话,工单分类,掌上运维平台登录的token。
  返回：无。

5. 打开标签打印
  ```
  AppPlatform.startLabelPrint(houseId4Show, houseName4Show, hold_device_id4show, hold_device_name4show, callback)
  ```
  参数：房号ID,房号信息,设备ID,设备信息。
  返回：无。

6. 启动其他App
  ```
  AppPlatform.openAndroidApp(packageName, activityName, callback)
  ```
  参数：packageName,activityName
  返回：无。

7. 带参数启动其他App 
  ```
  AppPlatform.openAndroidAppWithParam(packageName, activityName, params, callback)
  ```
  参数：packageName,activityName, params (格式：key1=value1&key2=value2)
  返回：无。
### 移除应用图标
添加Android平台后, 在AndroidManifest.xml中, 移除自带的应用图标显示，需要手动删除
```
<intent-filter android:label="@string/launcher_name">
    <action android:name="android.intent.action.MAIN" />
    <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```
