angular.module('gremoNaElektrikoApp.StavkaCenovnikaController',[])
    .controller('StavkaCenovnikaController', function ($scope, StavkaCenovnikaService , TipPrikljuckaService , CenovnikService ) {
    
    	$scope.stavkaCenovnikaList = [];
    	$scope.tipPrikljuckaList = [];	
    	$scope.cenovnikList = [];	
    	$scope.sortType     = 'cena';
    	$scope.sortReverse  = false;  
    	$scope.searchKeyword = "";
    
    	StavkaCenovnikaService.findAll()
    		.then(function successCallback(response) {
    			$scope.stavkaCenovnikaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})

		TipPrikljuckaService.findAll()
    		.then(function successCallback(response) {
    			$scope.tipPrikljuckaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})
    		
		CenovnikService.findAll()
    		.then(function successCallback(response) {
    			$scope.cenovnikList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})
    		

    	$scope.openCreateModal = function() {
    		$scope.stavkaCenovnika = {};
    		$scope.stavkaCenovnika.tipPrikljucka = {};
    		$scope.stavkaCenovnika.cenovnik = {};
    		$('#createStavkaCenovnikaModal').modal('toggle');
    	}
    		
    	$scope.createStavkaCenovnika = function() {

    	StavkaCenovnikaService.createStavkaCenovnika($scope.stavkaCenovnika , $scope.stavkaCenovnika.tipPrikljucka.id , $scope.stavkaCenovnika.cenovnik.id )
    			.then(function successCallback(response) {
    				$scope.stavkaCenovnikaList.push(response.data);
    				 $('#createStavkaCenovnikaModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteStavkaCenovnika = function(stavkaCenovnika) {
    		StavkaCenovnikaService.deleteStavkaCenovnika(stavkaCenovnika.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.stavkaCenovnikaList.indexOf(stavkaCenovnika);
    					$scope.stavkaCenovnikaList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(stavkaCenovnika) {
    		document.getElementById("updateSelectTipPrikljucka").value = stavkaCenovnika.tipPrikljucka.id;
    		document.getElementById("updateSelectCenovnik").value = stavkaCenovnika.cenovnik.id;
    		$scope.stavkaCenovnika = angular.copy(stavkaCenovnika);
    		$('#updateStavkaCenovnikaModal').modal('toggle');
    	}
    	
    	$scope.updateStavkaCenovnika = function() {
    		$scope.stavkaCenovnika.tipPrikljucka.id = document.getElementById("updateSelectTipPrikljucka").value;
    		$scope.stavkaCenovnika.cenovnik.id = document.getElementById("updateSelectCenovnik").value;
    		StavkaCenovnikaService.updateStavkaCenovnika($scope.stavkaCenovnika)
    			.then(function successCallback(response) {
    				$('#updateStavkaCenovnikaModal').modal('toggle');
    				StavkaCenovnikaService.findAll()
    					.then(function successCallback(response) {
    						$scope.stavkaCenovnikaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.filterFunction = function(stavkaCenovnika) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = stavkaCenovnika.tipPrikljucka.nazivTipaPrikljucka+" "+stavkaCenovnika.cenovnik.datum+" "+" ";
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });