angular.module('gremoNaElektrikoApp.MarkaVozilaController',[])
    .controller('MarkaVozilaController', function ($scope, MarkaVozilaService ) {
    
    	$scope.markaVozilaList = [];
    	$scope.sortType     = 'naziv';
    	$scope.sortReverse  = false;  
    
    	MarkaVozilaService.findAll()
    		.then(function successCallback(response) {
    			$scope.markaVozilaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})


    	$scope.openCreateModal = function() {
    		$scope.markaVozila = {};
    		$('#createMarkaVozilaModal').modal('toggle');
    	}
    		
    	$scope.createMarkaVozila = function() {

    	MarkaVozilaService.createMarkaVozila($scope.markaVozila )
    			.then(function successCallback(response) {
    				$scope.markaVozilaList.push(response.data);
    				 $('#createMarkaVozilaModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteMarkaVozila = function(markaVozila) {
    		MarkaVozilaService.deleteMarkaVozila(markaVozila.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.markaVozilaList.indexOf(markaVozila);
    					$scope.markaVozilaList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(markaVozila) {
    		$scope.markaVozila = angular.copy(markaVozila);
    		$('#updateMarkaVozilaModal').modal('toggle');
    	}
    	
    	$scope.updateMarkaVozila = function() {
    		MarkaVozilaService.updateMarkaVozila($scope.markaVozila)
    			.then(function successCallback(response) {
    				$('#updateMarkaVozilaModal').modal('toggle');
    				MarkaVozilaService.findAll()
    					.then(function successCallback(response) {
    						$scope.markaVozilaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	
    });