//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::MarkaVozila

angular.module('gremoNaElektrikoApp.MarkaVozilaService', [])
	.factory('MarkaVozilaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/markaVozila');
		}
		
		factory.createMarkaVozila = function(markaVozila ) {
			return $http.post('/gremoNaElektriko/markaVozila', markaVozila);
		}

		factory.deleteMarkaVozila = function(id) {
			return $http.delete('/gremoNaElektriko/markaVozila/'+id);
		}
		
		factory.updateMarkaVozila = function(markaVozila) {
			return $http.put('/gremoNaElektriko/markaVozila', markaVozila);
		}
		
		return factory;
	});