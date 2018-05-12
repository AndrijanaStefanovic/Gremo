//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::StavkaCenovnika

angular.module('gremoNaElektrikoApp.StavkaCenovnikaService', [])
	.factory('StavkaCenovnikaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/stavkaCenovnika');
		}
		
		factory.createStavkaCenovnika = function(stavkaCenovnika , tipPrikljuckaId, cenovnikId) {
			return $http.post('/gremoNaElektriko/stavkaCenovnika'+'/'+tipPrikljuckaId+'/'+cenovnikId, stavkaCenovnika);
		}

		factory.deleteStavkaCenovnika = function(id) {
			return $http.delete('/gremoNaElektriko/stavkaCenovnika/'+id);
		}
		
		factory.updateStavkaCenovnika = function(stavkaCenovnika) {
			return $http.put('/gremoNaElektriko/stavkaCenovnika', stavkaCenovnika);
		}
		
		return factory;
	});