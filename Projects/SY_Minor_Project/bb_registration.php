<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>Blood Bank Registration</title>
    <link rel="stylesheet" href="style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
</head>
<body>
<?php
    require('db.php');
    // When form submitted, insert values into the database.
    if (isset($_REQUEST['bbname'])) {
        // removes backslashes
        $name = stripslashes($_REQUEST['bbname']);
        //escapes special characters in a string
        $name = mysqli_real_escape_string($con, $name);
        $id   = stripslashes($_REQUEST['bbid']);
        $id   = mysqli_real_escape_string($con, $id);
        $email    = stripslashes($_REQUEST['bbemail']);
        $email    = mysqli_real_escape_string($con, $email);
        $address   = stripslashes($_REQUEST['bbaddress']);
        $address   = mysqli_real_escape_string($con, $address);
        $mob    = stripslashes($_REQUEST['bbmno']);
        $mob    = mysqli_real_escape_string($con, $mob);
        $approved    = stripslashes($_REQUEST['approved']);
        $approved    = mysqli_real_escape_string($con, $approved);
        $vehicle   = stripslashes($_REQUEST['bb_vehicle']);
        $vehicle    = mysqli_real_escape_string($con, $vehicle);
        $password = stripslashes($_REQUEST['password']);
        $password = mysqli_real_escape_string($con, $password);
        $img = stripslashes($_REQUEST['bmc_certificate']);
        $img = mysqli_real_escape_string($con, $img);
        $create_datetime = date("Y-m-d H:i:s");

        $query    = "INSERT into `blood_bank` (Blood_Bank_id,Name,Email,Address,Contact_No,SMCOM_Approved,Vehicle_Available,password,BMC_Certificate,create_datetime)
                     VALUES ('$id','$name', '$email','$address','$mob','$approved','$vehicle','" . md5($password) . "','$img','$create_datetime')";
        $result   = mysqli_query($con, $query);
        if ($result) {
            echo "<div class='form'>
                  <h3>Blood Bank registered successfully.</h3><br/>
                  <p class='link'>Click here to <a href='bb_login.php'>Login</a></p>
                  </div>";
        } else {
            echo "<div class='form'>
                  <h3>Required fields are missing.</h3><br/>
                  <p class='link'>Click here to <a href='bb_registration.php'>registration</a> again.</p>
                  </div>";
        }
    } else {
?>
    <form class="form" action="" method="post">
        <h1 class="login-title">Blood Bank Registration</h1>
        <input type="text" class="login-input" name="bbid" placeholder="Blood Bank id" required/>
        <input type="text" class="login-input" name="bbname" placeholder="Name of Blood Bank" required/>
        <input type="text" class="login-input" name="bbemail" placeholder="Email Address (Blood Bank)">
        <input type="text" class="login-input" name="bbaddress" placeholder="Address of Blood Bank">
        <input type="text" class="login-input" minlength="10" maxlength="10" name="bbmno" placeholder="Contact Number (Blood Bank)">
          Approved by State Medical Council of Maharashtra (SMCOM):<br><br>
          <input type="radio" name="approved" value="Yes" id="dot-1">Yes &nbsp; &nbsp;
          <input type="radio" name="approved" value="No" id="dot-1">No &nbsp; &nbsp;
          <br><br><br>
          Blood Bank vehicle available:<br><br>
          <input type="radio" name="bb_vehicle" value="Yes" id="dot-1">Yes &nbsp; &nbsp;
          <input type="radio" name="bb_vehicle" value="No" id="dot-1">No &nbsp; &nbsp;
          <br><br><br>
          <input type="password" class="login-input" name="password" placeholder="Set Password (Strong password required)">
          Upload BMC Registration Certificate: <input type="file" id="img" name="bmc_certificate" required accept="image/*"><br><br><br>
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
        $("input[name='bbmno']").on('input', function(e) {
            $(this).val($(this).val().replace(/[^0-9]/g, ''));
        });
    });
</script>

</html>