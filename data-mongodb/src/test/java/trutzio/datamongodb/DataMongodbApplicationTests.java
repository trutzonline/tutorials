package trutzio.datamongodb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataMongodbApplicationTests {

	@Test
	void testConnection(@Autowired UserRepository userRepository) {
		userRepository.deleteAll();
		var user = new User(new ObjectId(), "Dummy User");
		userRepository.save(user);
		assertEquals(1L, userRepository.count());
	}

}
