var demoApp = angular.module('TodoApp', []);

demoApp.controller('MainController', function ($scope, $http) {
    $scope.taches={};
    var elmt={
        title : "manger",
        value : true
    };

    var elmt2={
        title : "dormir",
        value : false
    };

    $scope.taches[0]=elmt;
    $scope.taches[1]=elmt2;
});