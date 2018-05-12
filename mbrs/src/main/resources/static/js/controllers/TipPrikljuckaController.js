//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: jscontroller.ftl
//Element modela: GremoNaElektriko::TipPrikljucka
angular.module('gremoNaElektrikoApp.TipPrikljuckaController',[])
    .controller('TipPrikljuckaController', function ($scope, TipPrikljuckaService ) {
    
    	$scope.tipPrikljuckaList = [];
    	$scope.sortType     = 'nazivTipaPrikljucka';
    	$scope.sortReverse  = false;  
    
    	TipPrikljuckaService.findAll()
    		.then(function successCallback(response) {
    			$scope.tipPrikljuckaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})


    	$scope.openCreateModal = function() {
    		$scope.tipPrikljucka = {};
    		$('#createTipPrikljuckaModal').modal('toggle');
    	}
    		
    	$scope.createTipPrikljucka = function() {

    	TipPrikljuckaService.createTipPrikljucka($scope.tipPrikljucka )
    			.then(function successCallback(response) {
    				$scope.tipPrikljuckaList.push(response.data);
    				 $('#createTipPrikljuckaModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteTipPrikljucka = function(tipPrikljucka) {
    		TipPrikljuckaService.deleteTipPrikljucka(tipPrikljucka.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.tipPrikljuckaList.indexOf(tipPrikljucka);
    					$scope.tipPrikljuckaList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(tipPrikljucka) {
    		$scope.tipPrikljucka = angular.copy(tipPrikljucka);
    		$('#updateTipPrikljuckaModal').modal('toggle');
    	}
    	
    	$scope.updateTipPrikljucka = function() {
    		TipPrikljuckaService.updateTipPrikljucka($scope.tipPrikljucka)
    			.then(function successCallback(response) {
    				$('#updateTipPrikljuckaModal').modal('toggle');
    				TipPrikljuckaService.findAll()
    					.then(function successCallback(response) {
    						$scope.tipPrikljuckaList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	
    });