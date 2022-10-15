<?php

// Getting index page name
$basename = substr(strtolower(basename($_SERVER['PHP_SELF'])),0,strlen(basename($_SERVER['PHP_SELF']))-4);;

if(!isset($_SESSION['user']) && $basename != "index"){
    header("Location: ". Index_Page_Link);
}

if($basename == "index") {
    if(!empty($_SESSION['user']))
        header("Location:".Gallery_Page_Link);
}

?>