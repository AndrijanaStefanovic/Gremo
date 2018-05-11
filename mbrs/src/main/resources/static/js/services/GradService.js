//Fri May 11 23:51:24 CEST 2018
//Generisano na osnovu sablona: jsservice.ftl
//Element modela: GremoNaElektriko::Grad

angular.module('gremoNaElektrikoApp.GradService', [])
	.factory('GradService', function($http) {
		var factory = {};
		
		factory.findAll = function() {
			return $http.get('/gremoNaElektriko/grad');
		}
		
		factory.createGrad = function(grad ) {
			return $http.post('/gremoNaElektriko/grad', grad);
		}

		factory.deleteGrad = function(id) {
			return $http.delete('/gremoNaElektriko/grad/'+id);
		}
		
		factory.updateGrad = function(grad) {
			return $http.put('/gremoNaElektriko/grad', grad);
		}
		
		return factory;
	});