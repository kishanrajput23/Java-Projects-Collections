<?php

class Gallery {

    public function __construct() {}

    /**
    * Read folder names inside photo folder
    * @param
    *   NONE
    *
    * @return 
    *   $final (ARRAY)
    **/
    public function getAllGallery() {
        $final = []; // empty array
        $galleries = glob(Gallery_Folder."*"); // reading the gallery folder

        // filtering out the files
        foreach($galleries as $gallery) {
            if ($gallery === '.' or $gallery === '..') continue;

            if(is_dir($gallery))
                $final[] = explode("/",$gallery)[1];
        }

        return $final;
    }

    /**
    * Create folder using the name argument
    * @param
    *   $name (string)
    *
    * @return 
    *   Boolean
    **/
    public function addGallery($name) {
        if(!file_exists(Gallery_Folder.$name)) {
            if(mkdir(Gallery_Folder.$name)){
                return true;
            }
        }
        return false;
    }


    /**
    * Delete folder using the name argument
    * @param
    *   $name (string)
    *
    * @return 
    *   Boolean
    **/
    public function deleteGallery($name) {
        $dir = Gallery_Folder.$name;

         if(file_exists($dir)) {
            foreach(scandir($dir) as $file) {
                if ('.' === $file || '..' === $file) continue;
                if (is_dir("$dir/$file")) rmdir_recursive("$dir/$file");
                else unlink("$dir/$file");
            }
            
            if(rmdir($dir))
                return true;
        }
        return false;
    }


    /**
    * rename a gallery folder name
    * @param
    *   $currentName (string)
    *   $newName (string)
    *
    * @return 
    *   Boolean
    **/
    public function editGalleryName($currentName, $newName){
        if(file_exists(Gallery_Folder.$currentName)) {
            if(rename(Gallery_Folder.$currentName, Gallery_Folder.$newName)){
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