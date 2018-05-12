angular.module('gremoNaElektrikoApp.buttonDirective',[])
.directive('buttonDirective', function () {
	return {
        template : "<h3>Ukupno kartica: {{karticaList.length}}</h3>"
    };
});