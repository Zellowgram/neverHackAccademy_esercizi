package TraductorWebSQL.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TraductorWebSQL.entities.Language;
@Repository
public interface LanguageRep extends JpaRepository<Language, Integer> {
	Optional<Language> findBySiglaLingua(String siglaLingua);
}
