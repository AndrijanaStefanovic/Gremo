//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::RadnoVreme

angular.module('gremoNaElektrikoApp.RadnoVremeService', [])
	.factory('RadnoVremeService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/radnoVreme');
		}
		
		factory.createRadnoVreme = function(radnoVreme , stanicaId) {
			return $http.post('/gremoNaElektriko/radnoVreme'+'/'+stanicaId, radnoVreme);
		}

		factory.deleteRadnoVreme = function(id) {
			return $http.delete('/gremoNaElektriko/radnoVreme/'+id);
		}
		
		factory.updateRadnoVreme = function(radnoVreme) {
			return $http.put('/gremoNaElektriko/radnoVreme', radnoVreme);
		}
		
		return factory;
	});