package ru.geekbrains.spring_framework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_framework.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
