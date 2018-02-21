package com.coderbd.mongodbjavaobjembeded;

import com.coderbd.mongodbjavaobjembeded.documents.Address;
import com.coderbd.mongodbjavaobjembeded.documents.Department;
import com.coderbd.mongodbjavaobjembeded.documents.Hobby;
import com.coderbd.mongodbjavaobjembeded.documents.Person;
import com.coderbd.mongodbjavaobjembeded.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PersonRepository.class)
public class MongodbjavaobjembededApplication implements CommandLineRunner {
	@Autowired
	private PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(MongodbjavaobjembededApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//personRepository.deleteAll();

		final Address address = new Address("19 Imaginary Road", "Imaginary Place", "Imaginary City", "UK");

		final Hobby badminton = new Hobby("Badminton");
		final Hobby tv = new Hobby("TV");
		final List<Hobby> hobbies = Arrays.asList(badminton, tv);


		final Department department = new Department("Software");

		final Person seju = new Person("Sejuti", "Islam", LocalDateTime.now(), address, "Winner", 100, hobbies, department);
		personRepository.insert(seju);

		System.out.println("Find by first name");
		personRepository.findByFirstName("John").forEach(System.out::println);

		System.out.println("Find by country (UK)");
		personRepository.findByCountry("UK").forEach(System.out::println);

		address.setCountry("US");
	//	personRepository.save(john);
		System.out.println("Find by country (US)");
		personRepository.findByCountry("US").forEach(System.out::println);

		System.out.println("Find by Department (Admin)");
		department.setDepartmentName("Admin");
		final Person reza = new Person("Mr...", "Sami", LocalDateTime.now(), null, "Winner", 100, hobbies, department);
		personRepository.save(reza);
		reza.setAddress(address);
		personRepository.save(reza);

		personRepository.findByDepartmentName("Admin").forEach(System.out::println);
	}
}
