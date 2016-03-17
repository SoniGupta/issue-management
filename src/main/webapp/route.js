issueApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider.

        when('/Issue', {
            templateUrl: 'Views/Home.html',
            controller: 'IssueController',
            activetab: 'Issue'
        }).

        when('/addEmp', {
            templateUrl: 'Views/Employee.html',
            controller: 'EmpController',
            activetab: 'addEmp'
        }).
        when('/EmpDetails', {
            templateUrl: ' Views/View_Employees.html',
            controller: 'ViewController',
            activetab: 'EmpDetails'
        }).

        when('/Comments/:issueId', {
            templateUrl: 'Views/Comment.html',
            controller: 'CommentsController',
            activetab: 'Comments'
        }).



        otherwise({
            redirectTo: '/Issue'
        });
}]);
