<?php

class Photos {

    public function __construct() {}

    /**
    * Read photos names inside photo folder
    * @param
    *   NONE
    *
    * @return 
    *   $final (ARRAY)
    **/
    public function getAllGalleryPhotos($gallery) {
        $final = []; // empty array
        $photos = scandir(Gallery_Folder.$gallery."/"); // reading the gallery folder

        // filtering out the files        
        foreach($photos as $photo) {
            if ($photo === '.' or $photo === '..') continue;

            $final[] = $photo;
        }
        return $final;
    }


    /**
    * Delete image using the name argument
    * @param
    *   $name (string)
    *
    * @return 
    *   Boolean
    **/
    public function deleteGalleryPhotos($gallery,$photo) {
         if(file_exists(Gallery_Folder.$gallery."/".$photo)) {
            if(unlink(Gallery_Folder.$gallery."/".$photo)){
                return true;
            }
        }
        return false;
    }


    public function show($data) {
        echo "<pre>";
        print_r($data);
        echo "</pre>";
        exit;
    }
} // End Gallery Class
?>