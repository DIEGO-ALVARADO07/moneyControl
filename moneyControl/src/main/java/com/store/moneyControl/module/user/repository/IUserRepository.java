package com.store.moneyControl.module.user.repository;

import com.store.moneyControl.module.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
}
