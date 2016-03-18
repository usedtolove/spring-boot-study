/**
 * Created by hjl on 2016/3/17.
 */

angular.module('hello', [])
    .controller('home', function ($http) {
        var self = this;
        $http.get("/resource").success(function (data) {
            console.log("data:" + data);
            self.greeting = data;
        });
    })
