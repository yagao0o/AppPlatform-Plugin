### 安装
``cordova plugin add https://github.com/yagao0o/AppPlatform-Plugin.git``
### 使用方法：
- cordova 2:
``
window.plugins.AppPlatform.setPackageName('instance-name', callback)
``

- typescript:

``
window.plugins.AppPlatform.setPackageName('instance-name', callback)
``

### 移除应用图标
添加Android平台后, 在AndroidManifest.xml中, 移除自带的应用图标显示，需要手动删除
```
<intent-filter android:label="@string/launcher_name">
    <action android:name="android.intent.action.MAIN" />
    <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
```
