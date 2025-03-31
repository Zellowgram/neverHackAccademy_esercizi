package TraductorWebSQL.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "lingue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lingua", nullable = false, unique = true)
	private Integer idLingua;

	@Column(name = "linguaggio", nullable = false, unique = true)
	private String linguaggio;

	@Column(name = "sigla_lingua", nullable = false, unique = true)
	private String siglaLingua;

}
