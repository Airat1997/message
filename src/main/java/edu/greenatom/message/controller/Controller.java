package edu.greenatom.message.controller;

import edu.greenatom.message.model.Message;
import edu.greenatom.message.repository.MessageRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/message")
public class Controller {

    @Autowired
    private final MessageRepository messageRepository;

    public Controller(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Message message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(path = "/all_messages")
    public ResponseEntity<Iterable<Message>> getMessages() {
        return new ResponseEntity<>(messageRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<UUID> postMessage(@RequestBody Message message) {
        messageRepository.save(message);
        return new ResponseEntity<>(message.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping
    ResponseEntity<Void> deleteMessage(@PathVariable UUID id) {
        messageRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}