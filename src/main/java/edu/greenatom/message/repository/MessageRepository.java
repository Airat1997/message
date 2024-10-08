package edu.greenatom.message.repository;

import edu.greenatom.message.model.Message;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, UUID> {

}
