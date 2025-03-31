package TraductorWebSQL.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TraductorWebSQL.entities.ItaWord;
@Repository
public interface ItaWordRep extends JpaRepository<ItaWord, Integer> {
	Optional<ItaWord> findByItaWord(String itaWord);
}
