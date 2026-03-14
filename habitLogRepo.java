package com.mind.trail.MindTrail;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface habitLogRepo extends MongoRepository<habitLogEntity, ObjectId> {
    
}
