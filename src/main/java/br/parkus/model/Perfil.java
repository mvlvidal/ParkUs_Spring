package br.parkus.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class Perfil extends AbstractModel implements GrantedAuthority {

	private static final long serialVersionUID = 540280220280451752L;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "perfis")
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
