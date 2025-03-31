package TraductorWebSQL.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "parole_italiane")
public class ItaWord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parola_italiana", nullable = false, unique = true)
	private Integer idItaWord;

	@Column(name = "parola_italiana", nullable = false, unique = true)
	private String itaWord;
}
