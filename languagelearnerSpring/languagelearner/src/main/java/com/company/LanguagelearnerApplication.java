package com.company;

import com.company.dao.inter.UserDaoInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;

@SpringBootApplication
public class LanguagelearnerApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("userDao")
	private UserDaoInter userDao;

	@Autowired
	@Qualifier("mynames")
	HashMap<String, String> names;

	public static void main(String[] args) {
		SpringApplication.run(LanguagelearnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("size="+userDao.getAll().size());
	}
}
