<?php

    require_once('database.php');

    $trip_title         = $_POST["trip_title"];
    $trip_from          = $_POST["from"];
    $trip_to            = $_POST["to"];
    $crew               = $_POST["crew"];
    $start_time         = $_POST["start_time"];
    $end_time           = $_POST["end_time"];
    $engine_runtime     = $_POST["engine_runtime"];
    $tank_filled        = $_POST["tank_filled"];

    $db = DBConnector::getConnection();

    $db->query("INSERT INTO trip  (id, boat_ID, title, trip_from, trip_to, start_time, end_time, engine_runtime, skipper, tank_filled)
            VALUES (1, 1, $trip_title, $trip_from, $trip_to, $start_time, $end_time, $engine_runtime, $tank_filled);");

    $db->close();

?>