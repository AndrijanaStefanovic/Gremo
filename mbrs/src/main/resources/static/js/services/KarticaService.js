//Sat May 12 11:32:37 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::Kartica

angular.module('gremoNaElektrikoApp.KarticaService', [])
	.factory('KarticaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/kartica');
		}
		
		factory.createKartica = function(kartica ) {
			return $http.post('/gremoNaElektriko/kartica', kartica);
		}

		factory.deleteKartica = function(id) {
			return $http.delete('/gremoNaElektriko/kartica/'+id);
		}
		
		factory.updateKartica = function(kartica) {
			return $http.put('/gremoNaElektriko/kartica', kartica);
		}
		
		return factory;
	});