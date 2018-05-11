//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::TipPrikljucka

angular.module('gremoNaElektrikoApp.TipPrikljuckaService', [])
	.factory('TipPrikljuckaService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/tipPrikljucka');
		}
		
		factory.createTipPrikljucka = function(tipPrikljucka ) {
			return $http.post('/gremoNaElektriko/tipPrikljucka', tipPrikljucka);
		}

		factory.deleteTipPrikljucka = function(id) {
			return $http.delete('/gremoNaElektriko/tipPrikljucka/'+id);
		}
		
		factory.updateTipPrikljucka = function(tipPrikljucka) {
			return $http.put('/gremoNaElektriko/tipPrikljucka', tipPrikljucka);
		}
		
		return factory;
	});