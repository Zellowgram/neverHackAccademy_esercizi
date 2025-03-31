package TraductorWebSQL.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parole_estere")
public class AlienWord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_parola_estera")
	private Integer idAlienWord;

	@Column(name = "parola_estera")
	private String alienWord;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linguaggio_della_parola_da_tradurre", referencedColumnName = "id_lingua", nullable = false)
	private Language linguaggio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parola_italiana_da_tradurre", referencedColumnName = "id_parola_italiana", nullable = false)
	private ItaWord itaWord;

}
