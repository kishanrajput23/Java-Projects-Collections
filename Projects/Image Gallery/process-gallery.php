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

$galleryOBJ = new Gallery();

if ( $_SERVER["REQUEST_METHOD"] == "POST" ) {
    $action = $_POST['action'];

    switch($action) {
        case 'addGallery':
            if($_SESSION['type'] == "admin") {
                $galleryName = htmlspecialchars(trim($_POST['galleryName']));

                $result = $galleryOBJ->addGallery($galleryName);

                if($result == true){
                    $response['success'] = true;
                }
            }
            else {
                $response['success'] = false;
            }

            echo json_encode($response);
            break; //END 'saveCart'

        case "deleteGallery":
            if($_SESSION['type'] == "admin") {
                $galleryName = htmlspecialchars(trim($_POST['galleryName']));
                
                $result = $galleryOBJ->deleteGallery($galleryName);
                
                if($result == true){
                    $response['success'] = true;
                }
            }
            else {
                $response['success'] = false;
            }

            echo json_encode($response);
            break;

        case "editGallery":
            if($_SESSION['type'] == "admin") {
                $galleryName = htmlspecialchars(trim($_POST['galleryName']));
                $newGalleryName = htmlspecialchars(trim($_POST['newName']));
                
                $result = $galleryOBJ->editGalleryName($galleryName,$newGalleryName);
                
                if($result == true){
                    $response['success'] = true;
                }
            }
            else {
                $response['success'] = false;
            }
            
            echo json_encode($response);
            break;
        default:
            break; // END 'default'

    } // End Switch
}
?>