<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="LoginPage.css">
<link rel="StyleSheet" type="text/css" href="js/dijit/themes/tundra/tundra.css">
</head>
<body>
<script type="text/javascript" src="js/dojo/dojo.js"></script>
<script>
            dojo.require("dojo.parser");
            dojo.require("dijit.form.TextBox");
            
            function validate(  ) {
                var f = document.getElementById("Login_form");
                if (f.UserID.value == "" ||f.password.value == "") {
                        alert("All fields are required.");
                        return false;
                }

                return true;
            }
    </script>
<div class="wrapper">
	<div class="form-wrapper">
		<h1>Login Page</h1>
		<form id="Login_form" onsubmit="return validate()"
            action="LoginController"  method="post">
		<div class="UserName">
			<label>UserID</label>
			<input type="text" dojoType="dijit.form.TextBox"  name="UserID" it.form.TextBoxid="UserName" placeholder="Enter the UserName">
		</div>
		
		<div class="Password">
			<label>Password</label>
			<input type="password" dojoType="dijit.form.TextBox" name="password" placeholder="Enter the Password">
		</div>
		<div class="Login">
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
		</div>
		</form>
	</div>
</div>
</body>
</html>