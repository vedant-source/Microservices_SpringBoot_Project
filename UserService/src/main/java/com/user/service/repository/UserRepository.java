package com.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.service.dto.User;

public interface UserRepository extends JpaRepository <User, String> {

}
