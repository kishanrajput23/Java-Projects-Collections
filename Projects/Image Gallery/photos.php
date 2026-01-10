<?php
include "includes/_process_include.php";
include "includes/_header.php";
include "includes/_login_check.php";

$gallery = htmlspecialchars(trim($_GET['gallery']));

$photosObj = new Photos();
$result    = $photosObj->getAllGalleryPhotos($gallery);

?>

<div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">Photos</h1>
    </div>

    <?php 
    if($_SESSION['type'] == "admin") {
    ?>
    <form action="image_upload.php" method="post" enctype="multipart/form-data"> 
    <div><strong>Only Jpeg allowed</strong></div>   
    <div class="row">  
        <div class="col-lg-6">
            <div class="input-group">            
                <input type="file" name="image" class="form-control" placeholder="Upload photo" accept="image/jpeg">
                <input type="hidden" name="galleryName" value="<?= $gallery ?>">
                <span class="input-group-btn">                   
                    <button class="btn btn-default" type="submit">Upload</button>
                </span>
                </div><!-- /input-group -->
             
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->
    </form>
    <?php } ?>
    <hr >

    <?php
        if(!empty($result)) {
        foreach($result as $photo) {
        ?>
            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
                <?php
                if($_SESSION['type'] == "admin") {
                ?>
                <!-- Dropdown action -->
                <div class="btn-group">
                    <button class="btn btn-default btn-xs dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Actions <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)" data-galleryname="<?=$gallery?>" data-photoname="<?=$photo?>" id="deletePhotobtn">Delete Photo</a></li>
                    </ul>
                </div> <!-- End Dropdown action -->
                <?php } ?>
                <a class="thumbnail" href="javascript:void(0)" id="popImage" data-imgsrc="<?=Gallery_Folder.$gallery."/".$photo?>">
                    <img class="img-responsive" src="<?=Gallery_Folder.$gallery."/".$photo?>" alt="">
                </a>
            </div>
        <?php
        }
        } else{
            echo '<div class="col-lg-3"><p class="alert alert-info">No Photos Found</p></div>';
        }
    ?>
</div> <!-- End row -->



<div id="imagemodal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">      
      <div class="modal-body">
        <img src="" id="imagepreview" class="img-responsive" >
      </div>      
    </div>

  </div>
</div>

<?php
include "includes/_footer.php";
?>