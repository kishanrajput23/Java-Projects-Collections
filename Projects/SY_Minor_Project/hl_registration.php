<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Hospital Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
    </script>
</head>
<body>
<?php
    require('db.php');
    // When form submitted, insert values into the database.
    if (isset($_REQUEST['hlname'])) {
        // removes backslashes
        $name = stripslashes($_REQUEST['hlname']);
        $name = mysqli_real_escape_string($con, $name);
        //escapes special characters in a string
        $id   = stripslashes($_REQUEST['hlid']);
        $id   = mysqli_real_escape_string($con, $id);
        $email    = stripslashes($_REQUEST['hlemail']);
        $email    = mysqli_real_escape_string($con, $email);
        $address   = stripslashes($_REQUEST['hladdress']);
        $address   = mysqli_real_escape_string($con, $address);
        $incname   = stripslashes($_REQUEST['incharge_name']);
        $incname  = mysqli_real_escape_string($con, $incname);
        $mob    = stripslashes($_REQUEST['incharge_mno']);
        $mob    = mysqli_real_escape_string($con, $mob);
        $nat   = stripslashes($_REQUEST['nationality']);
        $nat   = mysqli_real_escape_string($con, $nat);
        $beds   = stripslashes($_REQUEST['beds']);
        $beds   = mysqli_real_escape_string($con, $beds);
        $wards   = stripslashes($_REQUEST['wards']);
        $wards   = mysqli_real_escape_string($con, $wards);
        $icu   = stripslashes($_REQUEST['icu']);
        $icu  = mysqli_real_escape_string($con, $icu);
        $approved    = stripslashes($_REQUEST['approved']);
        $approved    = mysqli_real_escape_string($con, $approved);
        $password = stripslashes($_REQUEST['password']);
        $password = mysqli_real_escape_string($con, $password);
        $img = stripslashes($_REQUEST['bmc_certificate']);
        $img = mysqli_real_escape_string($con, $img);
        $create_datetime = date("Y-m-d H:i:s");

        $query    = "INSERT into `hospitals` (Hospital_id,Name,Email,Address,Incharge_Name,Incharge_Contact,Nationality_of_incharge,
        No_of_beds,No_of_wards,ICU_Units,Approved_by_SMCOM,Password,BMC_Certificate,create_datetime)
                     VALUES ('$id','$name', '$email','$address','$incname','$mob','$nat','$beds','$wards','$icu','$approved','" . md5($password) . "','$img','$create_datetime')";
        $result   = mysqli_query($con, $query);
        if ($result) {
            echo "<div class='form'>
                  <h3>Hospital registered successfully.</h3><br/>
                  <p class='link'>Click here to <a href='hl_login.php'>Login</a></p>
                  </div>";
        } else {
            echo "<div class='form'>
                  <h3>Required fields are missing.</h3><br/>
                  <p class='link'>Click here to <a href='hl_registration.php'>registration</a> again.</p>
                  </div>";
        }
    } else {
?>
    <form class="form" action="" method="post">
        <h1 class="login-title">Hospital Registration</h1>
        <input type="text" class="login-input" name="hlid" placeholder="Hospital id" required/>
        <input type="text" class="login-input" name="hlname" placeholder="Name of Hospital" required/>
        <input type="text" class="login-input" name="hlemail" placeholder="Email Address (Hospital)" required>
        <input type="text" class="login-input" name="hladdress" placeholder="Address of Hospital" required>
        <input type="text" class="login-input" name="incharge_name" placeholder="Name of applicant (In-charge)" required>
        <input type="text" class="login-input" minlength="10" maxlength="10" name="incharge_mno" required placeholder="Contact Number (In-charge)">
        <span style="font-size:22px">Nationality of In-charge:</span>
        <select name = "nationality" required>
            <option value="select" selected disabled>Select Nationality</option>
            <option value = "Indian">Indian</option>
            <option value = "Foreign">Foreign</option>
        </select><br><br>
        <input type="number" class="login-input" name="beds" placeholder="No of beds available" required>
        <input type="number" class="login-input" name="wards" placeholder="No of wards available" required>
        <input type="number" class="login-input" name="icu" placeholder="No of ICU units available" required>  
        Approved by State Medical Council of Maharashtra (SMCOM):<br><br>
        <input type="radio" name="approved" value="Yes" id="dot-1">Yes &nbsp; &nbsp;
        <input type="radio" name="approved" value="No" id="dot-1">No &nbsp; &nbsp;
        <br><br><br>
          
        <input type="password" class="login-input" required name="password" placeholder="Set Password (Strong password required)">
        <br><br>
        Upload BMC Registration Certificate: <input type="file" id="img" name="bmc_certificate" required accept="image/*"><br><br><br><br>
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
        $("input[name='incharge_mno']").on('input', function(e) {
            $(this).val($(this).val().replace(/[^0-9]/g, ''));
        });
    });
</script>

</html>