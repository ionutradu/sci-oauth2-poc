<%-- 
    Document   : index
    Created on : Jan 26, 2017, 7:50:03 PM
    Author     : gabi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>[SCI] 3rd Party Login</title>

    <link rel="stylesheet" type="text/css" href="./App/Content/Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/Bootstrap/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/FontAwesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/JQuery-UI/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/JQuery-UI/jquery-ui.theme.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/Toastr/toastr.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/Theme/AdminLTE.min.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/Theme/skins/skin-blue.css">
    <link rel="stylesheet" type="text/css" href="./App/Content/site.css">
</head>
<body class="hold-transition skin-blue login-page">
    <div ng-app="app">

        <div ng-controller="HomeController" id="page-content" custom-theme-functions>
            <div class="login-box">
                <div class="login-logo">
                    <a><b>3rd Party</b> APP</a>
                </div>
                <!-- /.login-logo -->
                <div class="login-box-body">
                    <p class="login-box-msg"><b>OAuth2.0 POC App</b> will receive: your profile picture and public information. If you agree, please login:</p>
                    <form nonvalidate name="loginForm">
                        <div class="form-group has-feedback">
                            <input type="text" class="form-control" placeholder="Username" ng-model="formData.username" required />
                            <span class="glyphicon glyphicon-user form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" class="form-control" placeholder="Password" ng-model="formData.password" required />
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="row">
                            <!-- /.col -->
                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat" ng-disabled="loginForm.$invalid"
                                        ng-click="signIn(formData)">
                                    Sign In
                                </button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>
                </div>
                <!-- /.login-box-body -->
            </div>
            <!-- /.login-box -->

        </div>

    </div>

    <!--
        error page
      <section class="content">
            <div class="error-page">
                <h2 class="headline text-red">401</h2>
                <div class="error-content">
                    <h3><i class="fa fa-warning text-red"></i> You are unauthorized! Something went wrong.</h3>
                    <p>
                        The login procedure failed as either the username or password were not correct. Please try again
                        with up-to-date credentials
                    </p>
                </div>
            </div>
        </section>
    -->

    <script type="text/javascript" src="./App/Core/JQuery/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="./App/Core/JQuery/jquery-ui.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular-route.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular-resource.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular-sanitize.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular-cookies.min.js"></script>
    <script type="text/javascript" src="./App/Core/AngularJS/angular-animate.min.js"></script>
    <script type="text/javascript" src="./App/Core/Bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="./App/Core/Bootstrap/ui-bootstrap-tpls-2.4.0.min.js"></script>
    <script type="text/javascript" src="./App/Core/Underscore/underscore.min.js"></script>
    <script type="text/javascript" src="./App/Application/app.js"></script>
    <script type="text/javascript" src="./App/Core/Theme/custom.js"></script>
    <script type="text/javascript" src="./App/Application/services.js"></script>
    <script type="text/javascript" src="./App/Application/Home/HomeController.js"></script>

</body>
</html>
