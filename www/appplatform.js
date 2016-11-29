var AppPlatform = {};

AppPlatform.setPackageName = function(name, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','setPackageName',[name])
};

module.exports = AppPlatform;
