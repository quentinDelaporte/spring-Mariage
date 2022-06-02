package com.delaporte.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InviteRepository extends CrudRepository<Invite, String> {
    void deleteById(Long id);
    Optional<Invite> findById(Long Id);
}
