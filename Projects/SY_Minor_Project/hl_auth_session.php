<?php
    session_start();
    if(!isset($_SESSION["hlemail"])) {
        header("Location: hl_login.php");
        exit();
    }
?>