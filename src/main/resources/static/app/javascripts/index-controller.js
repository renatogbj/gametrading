/**
 * Created by Renato Borges on 18/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope'];

function IndexController($scope) {
    
	$scope.gameSelected = {
		name: 'Mortal Kombat X',
		image: 'app/images/mkx.jpg',
		description: 'Joguinho de porrada bem bacana.'
	};
	
	$scope.games = [
        {
        	name: 'Mortal Kombat X',
        	image: 'app/images/mkx.jpg',
        	description: 'Joguinho de porrada bem bacana.'
        },
        {
        	name: 'Far Cry 4',
        	image: 'app/images/fc4.jpg',
        	description: 'Viajando pelas grandiosas montanhas do Himalaia.'
        },
        {
        	name: 'Call of Duty: Advanced Warfare',
        	image: 'app/images/codaw.jpg',
        	description: 'Mete bala.'
        },
        {
        	name: 'Shadows of Mordor',
        	image: 'app/images/som.jpg',
        	description: 'Senhor dos Aneis 4.'
        }
    ];
	
	$scope.setGame = function(gameSelected) {
		$scope.gameSelected = gameSelected;
	};
	
}