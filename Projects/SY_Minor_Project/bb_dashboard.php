<?php
//include auth_session.php file on all user panel pages
include("bb_auth_session.php");
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Dashboard - Blood Bank Area</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
    <div class="form">
        <p>Hey, <?php echo $_SESSION['bbemail']; ?>!</p>
        <p>Blood Bank Logged in successfully !!!</p>
        <p><a href="bb_logout.php">Logout</a></p>
    </div>
</body>
</html>