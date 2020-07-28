package com.api.user.repository;

import com.api.user.entity.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhoneRepository extends JpaRepository<UserPhone, Long> {
}
