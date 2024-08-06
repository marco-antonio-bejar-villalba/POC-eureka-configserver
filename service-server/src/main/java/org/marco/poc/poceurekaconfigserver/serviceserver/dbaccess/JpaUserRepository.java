package org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Integer> {
}
