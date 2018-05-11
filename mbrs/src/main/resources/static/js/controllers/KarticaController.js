angular.module('gremoNaElektrikoApp.KarticaController',[])
    .controller('KarticaController', function ($scope, KarticaService ) {
    
    	$scope.karticaList = [];
    	$scope.sortType     = 'imeVlasnika';
    	$scope.sortReverse  = false;  
    
    	KarticaService.findAll()
    		.then(function successCallback(response) {
    			$scope.karticaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})


    	$scope.openCreateModal = function() {
    		$scope.kartica = {};
    		$('#createKarticaModal').modal('toggle');
    	}
    		
    	$scope.createKartica = function() {

    	KarticaService.createKartica($scope.kartica )
    			.then(function successCallback(response) {
    				$scope.karticaList.push(response.data);
    				 $('#createKarticaModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteKartica = function(kartica) {
    		KarticaService.deleteKartica(kartica.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.karticaList.indexOf(kartica);
    					$scope.karticaList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(kartica) {
    		$scope.kartica = angular.copy(kartica);
    		$('#updateKarticaModal').modal('toggle');
    	}
    	
    	$scope.updateKartica = function() {
    		KarticaService.updateKartica($scope.kartica)
    			.then(function successCallback(response) {
    				$('#updateKarticaModal').modal('toggle');
    				KarticaService.findAll()
    					.then(function successCallback(response) {
    						$scope.karticaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	
    });