package br.com.luxfacta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luxfacta.model.entidades.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

}
