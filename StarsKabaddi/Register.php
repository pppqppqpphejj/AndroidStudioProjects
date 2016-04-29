<?php
    $con = mysqli_connect("mysql.hostinger.in", "u429285046_abhi4", "Abhi@506", "u429285046_stark");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $email = $_POST["email"];
    

    $statement = mysqli_prepare($con, "INSERT INTO user (name, username, password, email) VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement, "siss", $name, $username,$password,$email);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>