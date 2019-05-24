angular.module('PolyTask', []).controller('mainController',function($scope,$http){

    $http({
        method: 'GET',
        url: '/feed'
    }).then(function successCallback(response) {
        console.log("Sucess ?");
        $scope.laliste = response.data;
        console.log(response);
    }, function errorCallback(response) {
        console.error('Error get : ' + response.error);
    });


    $scope.createTask = function(){
        console.log("test create task");
        console.log($scope.Story.text)
        $http({
            method: 'POST',
            url: '/task/',
            data : $scope.Story.text
        }).then(function successCallback(response) {
            $scope.Story = {};
            $scope.laliste = response.data;
        }, function errorCallback(response) {
            console.error(response.error);
        });
    };

    $scope.delete_task = function(id_task){
        $http({
            method:'POST',
            url:'/delete/',
            data :id_task
        }).then(function successCallback(response) {
            $scope.laliste=response.data;
        },function errorCallback(response){
            console.error(response.error)
        })
    };

    $scope.modif_task= function(id_task){
        $http({
            method: 'POST',
            url: '/modif/' + id_task,
            data: "test"

        }).then(function successCallback(response) {
            //$scope.Com = {};
            $scope.laliste = response.data;
        }, function errorCallback(response) {
            console.error(response.error);
        })
    };

    $scope.done= function(id_task){
        $http({
            method: 'POST',
            url: '/done/',
            data: id_task

        }).then(function successCallback(response) {
            $scope.laliste = response.data;
        }, function errorCallback(response) {
            console.error(response.error);
        })
    };


});

