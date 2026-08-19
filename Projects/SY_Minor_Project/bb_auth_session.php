<?php
    session_start();
    if(!isset($_SESSION["bbemail"])) {
        header("Location: bb_login.php");
        exit();
    }
?>