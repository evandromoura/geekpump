package br.com.geekpump.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "grupamento_muscular", schema = "public")

public class GrupamentoMuscular {
		
		@Id
		@SequenceGenerator(name="GRUPAMENTO_MUSCULAR_ID_GENERATOR", sequenceName="grupamento_muscular_id_seq", allocationSize = 1)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPAMENTO_MUSCULAR_ID_GENERATOR")	
		private Integer id;
		
		private String nome;
		
		private String imagem;
		
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getImagem() {
			return imagem;
		}
		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GrupamentoMuscular other = (GrupamentoMuscular) obj;
			return Objects.equals(id, other.id);
		}

}
