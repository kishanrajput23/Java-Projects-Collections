<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Donor Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
</head>
<body>
<?php
    require('db.php');
    // When form submitted, insert values into the database.
    if (isset($_REQUEST['username'])) {
        // removes backslashes
        $username = stripslashes($_REQUEST['username']);
        //escapes special characters in a string
        $username = mysqli_real_escape_string($con, $username);
        $email    = stripslashes($_REQUEST['email']);
        $email    = mysqli_real_escape_string($con, $email);
        $age    = stripslashes($_REQUEST['age']);
        $age    = mysqli_real_escape_string($con, $age);
        $weight   = stripslashes($_REQUEST['weight']);
        $weight    = mysqli_real_escape_string($con, $weight);
        $address   = stripslashes($_REQUEST['address']);
        $address   = mysqli_real_escape_string($con, $address);
        $mob    = stripslashes($_REQUEST['mno']);
        $mob    = mysqli_real_escape_string($con, $mob);
        $password = stripslashes($_REQUEST['password']);
        $password = mysqli_real_escape_string($con, $password);
        $gender    = stripslashes($_REQUEST['gender']);
        $gender    = mysqli_real_escape_string($con, $gender);
        $create_datetime = date("Y-m-d H:i:s");
        $query    = "INSERT into `users` (username,email,Age,Weight,Address,Mobile_No,password,Gender,create_datetime)
                     VALUES ('$username', '$email','$age','$weight','$address','$mob','" . md5($password) . "','$gender','$create_datetime')";
        $result   = mysqli_query($con, $query);
        if ($result) {
            echo "<div class='form'>
                  <h3>You are registered successfully.</h3><br/>
                  <p class='link'>Click here to <a href='login.php'>Login</a></p>
                  </div>";
        } else {
            echo "<div class='form'>
                  <h3>Required fields are missing.</h3><br/>
                  <p class='link'>Click here to <a href='registration.php'>registration</a> again.</p>
                  </div>";
        }
    } else {
?>
    <form class="form" action="" method="post">
        <h1 class="login-title">Donor Registration</h1>
        <input type="text" class="login-input" name="username" placeholder="Username" required/>
        <input type="text" class="login-input" name="email" placeholder="Email Address">
        <input type="text" class="login-input" name="age" placeholder="Enter Age">
        <input type="text" class="login-input" name="weight" placeholder="Enter Weight (in kg)">
        <input type="text" class="login-input" name="address" placeholder="Enter your address">
        <input type="text" class="login-input" minlength="10" maxlength="10" name="mno" placeholder="Enter Mobile Number">
        <input type="password" class="login-input" name="password" placeholder="Set Password (Strong password required)">
          Gender:<br><br>
          <input type="radio" name="gender" value="Male" id="dot-1">Male &nbsp; &nbsp;
          <input type="radio" name="gender" value="Female" id="dot-1">Female &nbsp; &nbsp;
          <input type="radio" name="gender" value="Other" id="dot-1">Other &nbsp; &nbsp;
          <br><br><br>

        <input type="submit" name="submit" value="Register" class="login-button" style="font-size:20px"><br><br><br>
        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
        &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
        &nbsp &nbsp &nbsp &nbsp &nbsp 
        <a href="bb_login.php" class="login">Click to Login</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
        <a href="index.html" class="navback">Back to home</a>

    </form>
<?php
    }
?>
</body>
<script>
    $(function() {
        $("input[name='mno']").on('input', function(e) {
            $(this).val($(this).val().replace(/[^0-9]/g, ''));
        });
    });
</script>

</html>