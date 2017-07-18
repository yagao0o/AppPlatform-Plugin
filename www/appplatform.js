var AppPlatform = {};

AppPlatform.setPackageName = function(name, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','setPackageName',[name])
};
AppPlatform.getTel = function(name, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','getTel',[name])
};

module.exports = AppPlatform;
