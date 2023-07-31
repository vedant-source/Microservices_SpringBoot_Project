package com.user.service.countService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CountValueService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CountValueService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getUserCount() {
		String query = "SELECT COUNT(*) FROM micro_users";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}
}
