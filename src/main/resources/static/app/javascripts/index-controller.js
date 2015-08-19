/**
 * Created by Renato Borges on 18/08/2015.
 */
angular.module('gametradingApp')
    .controller('IndexController', IndexController);

IndexController.$inject = ['$scope'];

function IndexController($scope) {
    $scope.pessoa = 'renato';
}