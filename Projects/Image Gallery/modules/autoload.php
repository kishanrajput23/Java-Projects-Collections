<?php

function __autoload($Class) {
    require("modules/".$Class.".Class.php");
}

?>