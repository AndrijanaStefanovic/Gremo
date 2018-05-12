//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: jscontroller.ftl
//Element modela: GremoNaElektriko::RadnoVreme
angular.module('gremoNaElektrikoApp.RadnoVremeController',[])
    .controller('RadnoVremeController', function ($scope, RadnoVremeService , StanicaService ) {
    
    	$scope.radnoVremeList = [];
    	$scope.stanicaList = [];	
    	$scope.sortType     = 'danUNedelji';
    	$scope.sortReverse  = false;  
    	$scope.searchKeyword = "";
    
    	$scope.initDateTimePickerVremeOtvaranja = function() {
			$('#dateTimeVremeOtvaranja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
			$('#updateDateTimeVremeOtvaranja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
		}
		
    	$scope.initDateTimePickerVremeZatvaranja = function() {
			$('#dateTimeVremeZatvaranja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
			$('#updateDateTimeVremeZatvaranja').datetimepicker({
				format: 'DD-MM-YYYY HH:mm'
			});
		}
		
    	RadnoVremeService.findAll()
    		.then(function successCallback(response) {
    			$scope.radnoVremeList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})

		StanicaService.findAll()
    		.then(function successCallback(response) {
    			$scope.stanicaList = response.data;
    		}, function errorCallback(response){
    			toastr.error("Doslo je do greske.");
    		})
    		

    	$scope.openCreateModal = function() {
    		$scope.radnoVreme = {};
    		$scope.radnoVreme.stanica = {};
    		$('#createRadnoVremeModal').modal('toggle');
    	}
    		
    	$scope.createRadnoVreme = function() {
    		var vremeOtvaranja = $('#dateTextFieldVremeOtvaranja').val();
    		$scope.radnoVreme.vremeOtvaranja = moment(vremeOtvaranja, 'DD-MM-YYYY HH:mm');
    		var vremeZatvaranja = $('#dateTextFieldVremeZatvaranja').val();
    		$scope.radnoVreme.vremeZatvaranja = moment(vremeZatvaranja, 'DD-MM-YYYY HH:mm');

    	RadnoVremeService.createRadnoVreme($scope.radnoVreme , $scope.radnoVreme.stanica.id )
    			.then(function successCallback(response) {
    				$scope.radnoVremeList.push(response.data);
    				 $('#createRadnoVremeModal').modal('toggle');
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}

    	$scope.deleteRadnoVreme = function(radnoVreme) {
    		RadnoVremeService.deleteRadnoVreme(radnoVreme.id)
    			.then(function successCallback(response) {
    				if(response.data != "OK") {
    					toastr.error("Nije moguce brisanje.");
    				} else {
    					var index = $scope.radnoVremeList.indexOf(radnoVreme);
    					$scope.radnoVremeList.splice(index, 1); 
    				}
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.openUpdateModal = function(radnoVreme) {
    		document.getElementById("updateSelectStanica").value = radnoVreme.stanica.id;
			$("#updateDateTextFieldVremeOtvaranja").val(moment(radnoVreme.vremeOtvaranja).format('DD-MM-YYYY HH:mm'));
			$("#updateDateTextFieldVremeZatvaranja").val(moment(radnoVreme.vremeZatvaranja).format('DD-MM-YYYY HH:mm'));
    		$scope.radnoVreme = angular.copy(radnoVreme);
    		$('#updateRadnoVremeModal').modal('toggle');
    	}
    	
    	$scope.updateRadnoVreme = function() {
    		$scope.radnoVreme.stanica.id = document.getElementById("updateSelectStanica").value;
    		var vremeOtvaranja = $('#updateDateTextFieldVremeOtvaranja').val();
    		$scope.radnoVreme.vremeOtvaranja = moment(vremeOtvaranja, 'DD-MM-YYYY HH:mm');
    		var vremeZatvaranja = $('#updateDateTextFieldVremeZatvaranja').val();
    		$scope.radnoVreme.vremeZatvaranja = moment(vremeZatvaranja, 'DD-MM-YYYY HH:mm');
    		RadnoVremeService.updateRadnoVreme($scope.radnoVreme)
    			.then(function successCallback(response) {
    				$('#updateRadnoVremeModal').modal('toggle');
    				RadnoVremeService.findAll()
    					.then(function successCallback(response) {
    						$scope.radnoVremeList = response.data;
    					}, function errorCallback(response){
    						toastr.error("Doslo je do greske.");
    				})
    			}, function errorCallback(response){
    				toastr.error("Doslo je do greske.");
    			})
    	}
    	
    	$scope.filterFunction = function(radnoVreme) {
    		if($scope.searchKeyword == "")
    			return true;
    		var check = radnoVreme.stanica.adresaStanice+" "+" ";
    		if(check.includes($scope.searchKeyword))
    	    {
    	       	return true; 
    	    }
    		return false;
    	};
    	
    });