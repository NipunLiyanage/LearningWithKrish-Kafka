package com.example.KafkaDemo.controller;


import com.example.KafkaDemo.agents.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(path="api/kafkaController")
@CrossOrigin
public class KafkaController {

    Producer kafkaProducer;

    public KafkaController(Producer kafkaProducer){
        this.kafkaProducer=kafkaProducer;
    }

    //http://localhost:8085/api/kafkaController/publish?message=
    @GetMapping(path="/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.send(message);
        return ResponseEntity.ok("Message is sent");
    }



}
