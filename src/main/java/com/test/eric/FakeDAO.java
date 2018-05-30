package com.test.eric;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class FakeDAO {

	public List<User> getUserList() {
		return Stream.of("Chonpin","Jeremy","Eric").map( name-> new User(name)).collect(Collectors.toList());
	}
}
