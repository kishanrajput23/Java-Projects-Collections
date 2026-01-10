<?php
include "includes/_process_include.php";

$galleryName = htmlspecialchars(trim($_POST['galleryName']));
$image       = $_FILES['image'];

$goBackLink = "<a href='".Photos_Page_Link."?gallery=".$galleryName."'>Go back to Gallery</a>";

$target_dir = Gallery_Folder.$galleryName."/";

$target_file = $target_dir . basename($image["name"]);

$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);

// Check if image file is a actual image or fake image
if($imageFileType != "jpg" && $imageFileType != "jpeg") {
    echo "Sorry, only JPG and JPEG files are allowed.";
    echo "<br />".$goBackLink;
    exit;
}

if(isset($galleryName)) {
    
    if (file_exists($target_file)) {
        echo "Sorry, file already exists.";
        echo "<br />".$goBackLink;
        exit;
    }

    if (move_uploaded_file($image["tmp_name"], $target_file)) {
        header("location: ".Photos_Page_Link."?gallery=".$galleryName);
    } else {
        echo "Sorry, there was an error uploading your file.";
        echo "<br />".$goBackLink;
        exit;
    }
}

?>