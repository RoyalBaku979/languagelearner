package com.company;

import com.company.dao.impl.UserDaoInter;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class LanguagelearnerApplication implements CommandLineRunner {

	@Autowired
	private UserDaoInter userDao;


	public static void main(String[] args) {
		SpringApplication.run(LanguagelearnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<User> list= userDao.getAll();//custom method
		System.out.println(list);
		list=userDao.getAll();
		System.out.println(list);
		list=userDao.getAll();
		System.out.println(list);


//		userDao.remove(new User(4));
		list=userDao.getAll();
		System.out.println(list);
		list=userDao.getAll();
		System.out.println(list);
		list=userDao.getAll();
		System.out.println(list);


	}
}
