angular.module('gremoNaElektrikoApp.GradController',[])
    .controller('GradController', function ($scope, GradService ) {
    
    	$scope.gradList = [];
    	$scope.sortType     = 'nazivGrada';
    	$scope.sortReverse  = false;  
    
    	GradService.findAll()
    		.then(function successCallback(response) {
    			$scope.gradList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})


    	$scope.openCreateModal = function() {
    		$scope.grad = {};
    		$('#createGradModal').modal('toggle');
    	}
    		
    	$scope.createGrad = function() {

    	GradService.createGrad($scope.grad )
    			.then(function successCallback(response) {
    				$scope.gradList.push(response.data);
    				 $('#createGradModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteGrad = function(grad) {
    		GradService.deleteGrad(grad.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.gradList.indexOf(grad);
    					$scope.gradList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(grad) {
    		$scope.grad = angular.copy(grad);
    		$('#updateGradModal').modal('toggle');
    	}
    	
    	$scope.updateGrad = function() {
    		GradService.updateGrad($scope.grad)
    			.then(function successCallback(response) {
    				$('#updateGradModal').modal('toggle');
    				GradService.findAll()
    					.then(function successCallback(response) {
    						$scope.gradList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	
    });