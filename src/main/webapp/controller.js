issueApp.controller('IssueController', function ($scope, $http, $location) {

    $scope.iss = {};
    $scope.issues = {title: '', description: '', status: '', created_date: '', emp_id: ''};


    $scope.save = function () {
        $http({
            url: "http://localhost:8080/addissue",
            method: "GET",
            params: $scope.issues
        }).then(function (updatedData) {
                $scope.issueList.push(updatedData.data);
                //console.log(updatedData);
                alert("successfully Saved");
            },
            function (error) {
                alert('not success');
            });

        $scope.issues = " ";
    };

    var url = "http://localhost:8080/allissues";
    $http.get(url).success(function (response) {
        $scope.issueList = response;
    });

    $scope.empList=[
        {name:"All Employees"}
    ];
    var url = 'http://localhost:8080/emp';
    $http.get(url).success(function (response) {
        for(var i in response) {
            $scope.empList.push(response[i]);
        }
        $scope.empList.push({name:"No Assignee"})
    });

    $scope.selectedEmp = $scope.empList[0];

    $scope.showIssue = function (i) {
        $scope.iss.issue_id = i.issue_id;
        $scope.iss.title = i.title;
        $scope.iss.description = i.description;
        $scope.iss.status = i.status;
        $scope.iss.assignee = i.assignee;

    }

    $scope.showComments = function (issue) {
        $location.path('/Comments/' + issue.issue_id);
    }

    $scope.statusOptions= [
        {name:"All Status"},
        {name:"success"},
        {name:"pending"}
    ];

    $scope.selected= $scope.statusOptions[0];

    $scope.customFilter = function (i) {
        if($scope.selected.name === "All Status")
        {
            return true;
        }
        if (i.status === $scope.selected.name) {
            return true;
        } else {
            return false;
        }
    };

    $scope.empFilter = function (i) {
        if($scope.selectedEmp.name === "All Employees")
        {
            return true;
        }
        if(i.assignee == null) {
            if($scope.selectedEmp.name === "No Assignee") {
                return true;
            }else {
                return false;
            }
        }
        if (i.assignee.id === $scope.selectedEmp.id) {
            return true;
        } else {
            return false;
        }
    };

    $scope.selectedDate = "";
    $scope.dateFilter=function(i){
        if($scope.selectedDate == "")
        {
            return true;
        }


        if (i.created_date === $scope.selectedDate) {
            return true;
        }
        else
        {
            return false;
        }
    }
});


issueApp.controller('EmpController', function ($scope, $http, $location) {
    $scope.employee = {name: '', fatherName: '', address: '', email: '', phone: '', gender: ''};

    $scope.submit = function () {

        $http({
            url: "http://localhost:8080/addemp",
            method: "GET",
            params: $scope.employee
        }).then(
            function (success) {
                alert('successfully saved');
            },
            function (error) {
                alert('not success');
            });
        $scope.employee = " ";
    }
});


issueApp.controller('ViewController', function ($scope, $http) {
        var url = 'http://localhost:8080/emp';
        $http.get(url).success(function (response) {
            $scope.empList = response;
        });
    }
);


issueApp.controller('CommentsController', function ($scope, $http, $routeParams) {
    $scope.issueId = $routeParams.issueId;

    $http({
        url: "http://localhost:8080/issuedetails",
        method: "GET",
        params: {"issue_id": $scope.issueId}
    }).then(function (apiresponse) {
            $scope.iss = apiresponse.data;
            //console.log(apiresponse);//to print data on console
        },
        function (error) {
            alert('not success');
        });


    $scope.comments = {issue_id: $scope.issueId, comment: '', date: '', emp_id: 5};
    $scope.postcomments = function () {
        $http({
            url: " http://localhost:8080/addcomments", method: "GET", params: $scope.comments
        }).then(function (success) {
                $http({
                    url: "http://localhost:8080/issuedetails",
                    method: "GET",
                    params: {"issue_id": $scope.issueId}
                }).then(function (apiresponse) {
                        $scope.iss = apiresponse.data;
                    },
                    function (error) {
                    });
                alert('saved');
                $scope.comments.comment = "";
                $scope.comments.date = "";
            },
            function (error) {
                alert('not saved');
            });


    }


});


issueApp.controller('HeaderController', function ($scope, $location) {
    $scope.isActive = function (viewLocation) {
        return viewLocation === $location.path();
    };
});
