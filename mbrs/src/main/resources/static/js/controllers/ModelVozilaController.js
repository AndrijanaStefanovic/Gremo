//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: jscontroller.ftl
//Element modela: GremoNaElektriko::ModelVozila

angular.module('gremoNaElektrikoApp.ModelVozilaController',[])
    .controller('ModelVozilaController', function ($scope, ModelVozilaService , TipPrikljuckaService , MarkaVozilaService ) {
    
    	$scope.modelVozilaList = [];
    	$scope.tipPrikljuckaList = [];	
    	$scope.markaVozilaList = [];	
    	$scope.sortType     = 'nazivModelaVozila';
    	$scope.sortReverse  = false;  
    	$scope.searchKeyword = "";
    
    	ModelVozilaService.findAll()
    		.then(function successCallback(response) {
    			$scope.modelVozilaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})

		TipPrikljuckaService.findAll()
    		.then(function successCallback(response) {
    			$scope.tipPrikljuckaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})
    		
		MarkaVozilaService.findAll()
    		.then(function successCallback(response) {
    			$scope.markaVozilaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})
    		

    	$scope.openCreateModal = function() {
    		$scope.modelVozila = {};
    		$scope.modelVozila.tipPrikljucka = {};
    		$scope.modelVozila.markaVozila = {};
    		$('#createModelVozilaModal').modal('toggle');
    	}
    		
    	$scope.createModelVozila = function() {

    	ModelVozilaService.createModelVozila($scope.modelVozila , $scope.modelVozila.tipPrikljucka.id , $scope.modelVozila.markaVozila.id )
    			.then(function successCallback(response) {
    				$scope.modelVozilaList.push(response.data);
    				 $('#createModelVozilaModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteModelVozila = function(modelVozila) {
    		ModelVozilaService.deleteModelVozila(modelVozila.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.modelVozilaList.indexOf(modelVozila);
    					$scope.modelVozilaList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(modelVozila) {
    		document.getElementById("updateSelectTipPrikljucka").value = modelVozila.tipPrikljucka.id;
    		document.getElementById("updateSelectMarkaVozila").value = modelVozila.markaVozila.id;
    		$scope.modelVozila = angular.copy(modelVozila);
    		$('#updateModelVozilaModal').modal('toggle');
    	}
    	
    	$scope.updateModelVozila = function() {
    		$scope.modelVozila.tipPrikljucka.id = document.getElementById("updateSelectTipPrikljucka").value;
    		$scope.modelVozila.markaVozila.id = document.getElementById("updateSelectMarkaVozila").value;
    		ModelVozilaService.updateModelVozila($scope.modelVozila)
    			.then(function successCallback(response) {
    				$('#updateModelVozilaModal').modal('toggle');
    				ModelVozilaService.findAll()
    					.then(function successCallback(response) {
    						$scope.modelVozilaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.filterFunction = function(modelVozila) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = modelVozila.tipPrikljucka.nazivTipaPrikljucka+" "+modelVozila.markaVozila.nazivMarkeVozila+" "+" ";
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });