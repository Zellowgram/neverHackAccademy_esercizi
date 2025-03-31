package TraductorWebSQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TraductorWebSQL.entities.AlienWord;
@Repository
public interface AlienWordRep extends JpaRepository<AlienWord, Integer>{

}
