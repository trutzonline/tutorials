package trutzio.datamongodb;

import org.bson.codecs.ObjectIdGenerator;
import org.bson.types.ObjectId;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataMongodbApplication implements ApplicationRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DataMongodbApplication.class, args);
	}

	public DataMongodbApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var user = new User(new ObjectId(), "Christian");
		userRepository.save(user);
		userRepository.findAll().stream().forEach(System.out::println);
	}

}
