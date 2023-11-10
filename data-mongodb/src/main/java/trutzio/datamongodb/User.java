package trutzio.datamongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.MongoId;

public record User(@MongoId ObjectId id, String name) {
}
