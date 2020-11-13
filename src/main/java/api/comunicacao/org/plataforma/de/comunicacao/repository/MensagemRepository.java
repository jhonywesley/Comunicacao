package api.comunicacao.org.plataforma.de.comunicacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.comunicacao.org.plataforma.de.comunicacao.models.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    
}
