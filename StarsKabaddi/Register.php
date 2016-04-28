<?php
    $con = mysqli_connect("mysql.hostinger.in", "u429285046_abhi4", "Abhi@506", "u429285046_stark");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $email = $_POST["email"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "INSERT INTO user (name, username, email,password) VALUES (?,?,?,?)");
    mysqli_stmt_bind_param($statement, "siss", $name, $username,$email,$password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>