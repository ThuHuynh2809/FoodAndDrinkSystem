/*
 * @ (#) UserRepository.java     1.0     5/26/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.userservice.repositories;

import com.example.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:03 AM 5/26/2024
 * @version: 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
