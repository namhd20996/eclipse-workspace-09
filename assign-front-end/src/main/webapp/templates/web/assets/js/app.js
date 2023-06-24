
var myApp = angular.module('myApp', ['ngRoute']);
myApp.config(function ($routeProvider) {
    $routeProvider
        .when('/subjects', {
            templateUrl: 'templates/web/subjects.html',
            controller: 'myController'
        })
        .when('/quiz/:id/:name', {
            templateUrl: 'templates/web/quiz-app.html',
            controller: 'quizController'
        })
})

myApp.controller('myController', myController);
myApp.controller('quizController', quizController);

function myController($scope, $http) {
    $scope.subjects = [];
    $http.get('templates/web/assets/db/Subjects.js').then(function (respone) {
        $scope.subjects = respone.data;
    })
}

function quizController($routeParams, $http, quizFactory) {
    $http.get('templates/web/assets/db/Quizs/' + $routeParams.id + '.js').then(function (respone) {
        quizFactory.questions = respone.data;
    })
}

myApp.directive('quizPoly', function (quizFactory, $routeParams) {
    return {
        restrict: 'AE',
        scope: {},
        templateUrl: 'templates/web/template-quiz.html',
        link: function (scope, element, attr) {
            scope.start = function () {
                quizFactory.getQuestions().then(function () {
                    scope.subjectName = $routeParams.name;
                    scope.id = 1;
                    scope.quizOver = false;
                    scope.inProgess = true;
                    scope.getQuestion();
                })
            }

            scope.reset = function () {
                scope.inProgess = false;
                scope.score = 0;
            }

            scope.getQuestion = function () {
                var quiz = quizFactory.getQuestion(scope.id);
                if (quiz) {
                    scope.question = quiz.Text;
                    scope.options = quiz.Answers;
                    scope.answer = quiz.AnswerId;
                    scope.answerMode = true;
                } else {
                    scope.quizOver = true;
                }
            }

            scope.checkAnswer = function () {
                if (!$('input[name="answer"]:checked').length) return;
                var ans = $('input[name="answer"]:checked').val();
                if (ans == scope.answer) {
                    scope.score++;
                    scope.correctAnswer = true;
                } else {
                    scope.correctAnswer = false;
                }
                scope.answerMode = false;
            }

            scope.nextQuestion = function () {
                scope.id++;
                scope.getQuestion();
            }

            scope.reset();
        }
    }
})

myApp.factory('quizFactory', function ($http, $routeParams) {
    return {
        getQuestions: function () {
            return $http.get('templates/web/assets/db/Quizs/' + $routeParams.id + '.js').then(function (respone) {
                questions = respone.data;
            })
        },
        getQuestion(id) {
            var randomItem = questions[Math.floor(Math.random() * questions.length)];
            var count = questions.length;
            if (count > 10) {
                count = 10;
            }
            if (id < count) {
                return randomItem;
            } else {
                return false;
            }
        }
    }
})

