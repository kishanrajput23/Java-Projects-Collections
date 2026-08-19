<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Blood Requests</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style type="text/css">
        .bs-example{
            margin: 20px;
            border:red 4px solid;
	        border-style:dashed;
            
        }

        body {
	        margin:auto;
	        padding:20px;
            background-image: radial-gradient(#fff, #ffb0b0);
            width:1300px;
        }
        
        td {
	        text-align:center;
	        padding:10px;
        }

        table {
	        margin:auto;
	        border:red 2px solid;
        }

        h1 {
	        color:red;
	        text-align:center;
        }

        th {
	        color:red;
	        font-size:20px;
            font-family: cursive;
            text-align:center;
        }

        .navback{
            display: inline-block;
            background: #dc143c;
            color: #fff;
            padding: 5px 15px;
            padding-left: 20px;
            border-radius: 20px;
            transition: 0.5s;
            flex-basis: 50%;
            min-width: 2px;
        }

        .navback:hover{
            background: #0011ff;
            color:white;
            text-decoration: none;
        }

    </style>

    <script type="text/javascript">
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();   
        });
    </script>
</head>
<body>
    <br><br>
    <div class="bs-example">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header clearfix"><br><br>
                        <u><h1 class="pull-left">Blood Requests</h1></u><br><br>
                    </div>
                    <?php
                    include_once 'db.php';
                    $result = mysqli_query($con,"SELECT * FROM blood_request");
                    ?>
 
                    <?php
                    if (mysqli_num_rows($result) > 0) {
                    ?>
                      <table border="1" cellspacing="5" cellpadding="5" width="100%">
                       
                      <tr>
                        <th>Name</th>
                        <th>Location</th>
                        <th>City</th>
                        <th>Blood Group</th>
                        <th>Gender</th>
                        <th>Contact</th>
                      </tr>
                    <?php
                    $i=0;
                    while($row = mysqli_fetch_array($result)) {
                    ?>
                    <tr>
                        <td><?php echo $row["Full_Name"]; ?></td>
                        <td><?php echo $row["Location"]; ?></td>
                        <td><?php echo $row["City"]; ?></td>
                        <td><?php echo $row["Blood_Group"]; ?></td>
                        <td><?php echo $row["Gender"]; ?></td>
                        <td><?php echo $row["Contact"]; ?></td>
                    </tr>
                    <?php
                    $i++;
                    }
                    ?>
                    </table>
                     <?php
                    }
                    else{
                        echo "No result found";
                    }
                    ?>
                </div>
            </div> <br> 
            <span style="padding-left:480px;"><a href="index.html" class="navback">Back to home</span></a> <br><br>
        </div>
    </div>
</body>
</html>