<?php
include "includes/_process_include.php";
include "includes/_header.php";
include "includes/_login_check.php";

$galleryObj = new Gallery();
$result = $galleryObj->getAllGallery();
?>

 <div class="row">

    <div class="col-lg-12">
        <h1 class="page-header">Galleries</h1>
    </div>

    <?php 
    if($_SESSION['type'] == "admin") {
    ?>
    <div class="row">  
        <div class="col-lg-4">
            <div class="input-group">
            <input type="text" id="galleryName" class="form-control" placeholder="Add Gallery">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="addGallerybtn">Add</button>
            </span>
            <div id="loader"></div>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->
    <?php  } ?>

    <br />   
    <div id="galleriesList" >
    <?php
        if(!empty($result)) {
        foreach($result as $gallery) {            
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
                        <li><a href="" data-name="<?=$gallery?>" data-toggle="modal" data-target="#myModal" data-name="<?=$gallery?>" id="editGallerybtn">Edit Name</a></li>
                        <li><a href="" data-galleryname="<?=$gallery?>" id="deleteGallerybtn">Delete Gallery</a></li>
                    </ul>
                </div> <!-- End Dropdown action -->
            <?php } ?>
                <a class="thumbnail" href="<?=Photos_Page_Link?>?gallery=<?=$gallery?>">
                    <img class="img-responsive" src="default-thumbnail.jpg" alt="">
                    <p><?=$gallery?></p>
                </a>
                                    
            </div>
        <?php
        }
        } else{
            echo '<div class="col-lg-3"><p class="alert alert-info">No Galleries Found</p></div>';
        }
    ?>
    </div>
</div> <!-- End row -->

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Gallery Name</h4>
      </div>
      <div class="modal-body">
        <div class="row">  
        <div class="col-lg-8">
            <div class="input-group">
            <input type="text" id="newGalleryName" class="form-control" placeholder="Add Gallery">
            <input type="hidden" id="oldGalleryName" class="form-control">
            <span class="input-group-btn">
                <button class="btn btn-default" type="button" id="editGalleryModalBtn">Edit</button>
            </span>
            <div id="loader"></div>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->
      </div>      
    </div>

  </div>
</div>

<?php
include "includes/_footer.php";
?>