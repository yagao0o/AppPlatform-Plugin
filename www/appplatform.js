var AppPlatform = {};

AppPlatform.setPackageName = function(name, cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','setPackageName',[name])
};
// AppPlatform.init = function(cb){
// 	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','init',[])
// };
AppPlatform.getInfo = function(cb){
	cordova.exec(function(result){cb(null,result)},cb, 'AppPlatform','getInfo',[])
};

module.exports = AppPlatform;