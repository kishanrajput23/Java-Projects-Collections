<?php

   $Name=$_POST['full_name'];
   $Email=$_POST['email'];
   $Location=$_POST['location'];
   $City=$_POST['city'];
   $Blood_groups = $_POST['blood_groups'];
   $Contact=$_POST['mob_no'];
   $Gender=$_POST['gender'];
  

   $servername = "localhost"; 
   $username = "root";
   $password = "";
   $db="donation_desk"; //database name
  

   $conn = new mysqli($servername, $username, $password,$db);

   
    //Insert query
    $sql= "INSERT INTO `blood_request` (`Full_Name`,`Email`,`Location`,`City`,`Blood_Group`,`Contact`,`Gender`) 
    VALUES ('$Name','$Email','$Location','$City','$Blood_groups','$Contact','$Gender')";
      
      
   	if($conn->query($sql))
    {
        include('success_modal.html');
    }
   	
    else
    {
        echo "Error: ".$sql."<br>".$conn->error;
    }

   	$conn->close();

?>