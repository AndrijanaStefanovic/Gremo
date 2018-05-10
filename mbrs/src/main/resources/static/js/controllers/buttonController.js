angular.module('gremoNaElektrikoApp.ButtonController', [])
    .controller('ButtonController', function ($scope, $http) {
    	
    	$scope.test = function() {
    		alert(1);
    	}
    });