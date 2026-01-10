<?php
include "includes/_process_include.php";

// structure JSON response
$response = array();
$response['success']  = false;
$response['messages'] = array();

if (!array_key_exists("action", $_POST)) {
    $response["messages"][] = 'Invalid action';
    echo json_encode($response);
    exit();
}

$photosOBJ = new Photos();

if ( $_SERVER["REQUEST_METHOD"] == "POST" ) {
    $action = $_POST['action'];

    switch($action) {
        case 'deletePhoto':
            if($_SESSION['type'] == "admin") {
                $galleryName = htmlspecialchars(trim($_POST['galleryName']));
                $photoName   = htmlspecialchars(trim($_POST['photoName']));

                $result = $photosOBJ->deleteGalleryPhotos($galleryName,$photoName);

                if($result == true){
                    $response['success'] = true;
                }               
            }
            else{
                $response['success'] = false;
            }
            echo json_encode($response);
            break; //END 'saveCart'

        default:
            break; // END 'default'

    } // End Switch
}
?>