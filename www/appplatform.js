var AppPlatform = {};

AppPlatform.setPackageName = function(name, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','setPackageName',[name])
};
AppPlatform.getToken = function(cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','getToken',[])
};
AppPlatform.startCamera = function(formNo,flowId,htName,tkiid,templateName,token,isReupload, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','startCamera',[formNo,flowId,htName,tkiid,templateName,token,isReupload])
};
AppPlatform.startCallRecorder = function(formNo,flowId,htName,tkiid,contacterTel,templateName,token, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','startCallRecorder',[formNo,flowId,htName,tkiid,contacterTel,templateName,token])
};
AppPlatform.startLabelPrint = function(houseId4Show,houseName4Show,hold_device_id4show,hold_device_name4show, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','startLabelPrint',[houseId4Show,houseName4Show,hold_device_id4show,hold_device_name4show])
};

module.exports = AppPlatform;
