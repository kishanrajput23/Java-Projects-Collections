/***************************** Authentication Actions  ******************************/
$("#loginbtn").on("click", function(){
    var user = $("#username").val();
    var password = $("#password").val();
    var nextURL = $("#nextURL").val();

    $("#loader").html('<img src="loader.gif">');

    $.post("process-auth.php", {action: 'login', username: user, password: password}, function (response) {
      
      $("#loader").html('');
      var response = JSON.parse(response);

      if (response.success) {        
        window.location.href = nextURL;
      } 
      else {
         $("#loader").html('<p class="alert alert-danger">Invalid username/password</p>');
      }
    });
});


$("#logoutbtn").on("click", function(){

    $.post("process-auth.php", {action: 'logout'}, function (response) {
      
      window.location.href = "index.php";
      
    });
});


/***************************** Gallery Actions  ******************************/
// Add Gallery Action
$("#addGallerybtn").on("click", function(){
    var galleryName = $("#galleryName").val();

    if(galleryName != "") {      
      $("#loader").html('<img src="loader.gif">');

      $.post("process-gallery.php", {action: 'addGallery', galleryName: galleryName}, function (response) {
        
        $("#loader").html('');
        var response = JSON.parse(response);

        if (response.success) {        
            location.reload();
        } 
        else {
          console.log("Error Adding Gallery");
        }
      });
    }
});

// Delete Gallery Action
$("#deleteGallerybtn").on("click", function(){
    var galleryName = $(this).data("galleryname");

    if(galleryName != "") {      
      $("#loader").html('<img src="loader.gif">');

      $.post("process-gallery.php", {action: 'deleteGallery', galleryName: galleryName}, function (response) {
        
        $("#loader").html('');
        var response = JSON.parse(response);

        if (response.success) {        
            location.reload();
        } 
        else {
          console.log("Error Adding Gallery");
        }
      });
    }
});


// Edit Gallery Action
$(document).on("click", '#editGallerybtn', function(){
    var galleryName = $(this).data("name");
    $("#oldGalleryName").val(galleryName);
});

// Edit Gallery Modal Action
$("#editGalleryModalBtn").on("click", function(){
    var newName = $("#newGalleryName").val();
    var galleryName = $("#oldGalleryName").val();

    if(galleryName != "") {      
      $("#loader").html('<img src="loader.gif">');

      $.post("process-gallery.php", {action: 'editGallery', galleryName: galleryName, newName: newName}, function (response) {
        
        $("#loader").html('');
        var response = JSON.parse(response);

        if (response.success) {        
            location.reload();
        } 
        else {
          console.log("Error Adding Gallery");
        }
      });
    }
});



/***************************** Photos Actions  ******************************/
// Delete Photo Action
$("#deletePhotobtn").on("click", function(){
    var galleryName = $(this).data("galleryname");
    var photoName = $(this).data("photoname");

    
    if(galleryName != "") {      

      $.post("process-photos.php", {action: 'deletePhoto', galleryName: galleryName, photoName: photoName}, function (response) {
        
        var response = JSON.parse(response);

        if (response.success) {        
            location.reload();
            //console.log("success");
        } 
        else {
          console.log("Error Deleting Photo");
        }
      });
    }
});


$(document).on("click", '#popImage', function(){
    var imgSrc = $(this).data("imgsrc");
    $('#imagepreview').attr('src', imgSrc); 
    $('#imagemodal').modal('show');
});

// $('#popImage').on('click', function() {
// 			$('.imagepreview').attr('src', $(this).find('img').attr('src'));
// 			$('#imagemodal').modal('show');   
// 		});		