package br.com.luxfacta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.luxfacta.model.entidades.PollOption;

@Repository
public interface PollOptionRepository extends JpaRepository<PollOption, Long> {

	@Query("SELECT p FROM PollOption p where (p.poll.id =:poll_id)")
	List<PollOption> obterOpcoesPorEnquete(@Param("poll_id") long poll_id);

	@Query("SELECT SUM(p.votes) FROM PollOption p where (p.poll.id =:poll_id)")
	Integer obterViews(@Param("poll_id") long poll_id);
}
