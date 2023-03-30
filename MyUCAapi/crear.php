<?php
require_once 'conexion.php';
if($_SERVER["REQUEST_METHOD"] == "POST"){
    
    $nombres = $_POST ["nombres"];
    $apellidos = $_POST["apellidos"];
    $fechaNac = $_POST["fechaNac"];
    $titulo = $_POST ["titulo"];
    $email = $_POST["email"];
    $facultad = $_POST["facultad"];

    
    $my_query = "insert into coordinador (nombres , apellidos , fechaNac , titulo , email , facultad ) values
    (' ".$nombres."' , '".$apellidos."', '".$fechaNac."' , '".$titulo."' , '".$email."', '".$facultad."')";
    $result = $mysql -> query($my_query);


    if($result == true){
        echo " Registro guardado sastisfactoriamente...";
    }else{

        echo " Error al guardar el registro...";
    }


}else{
    echo " Erro desconocido";
}
?>