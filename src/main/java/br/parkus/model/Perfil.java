package br.parkus.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Perfil extends AbstractModel<Long> implements GrantedAuthority {

	private static final long serialVersionUID = 540280220280451752L;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "perfis")
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
