package api.comunicacao.org.plataforma.de.comunicacao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import api.comunicacao.org.plataforma.de.comunicacao.models.Mensagem;
import api.comunicacao.org.plataforma.de.comunicacao.repository.MensagemRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PlataformaDeComunicacaoApplicationTests {

	@Autowired
	MensagemRepository mensagemRepository;

	@Test
	public void testPost() throws Exception {
		Mensagem mensagem = new Mensagem("15/05", "14:30", "jose", "salvou", "whats");
		this.mensagemRepository.save(mensagem);
		Assertions.assertThat(mensagem.getId()).isNotNull();
		Assertions.assertThat(mensagem.getData()).isEqualTo("15/05");
		Assertions.assertThat(mensagem.getDestinatario()).isEqualTo("jose");
		Assertions.assertThat(mensagem.getHora()).isEqualTo("14:30");
		Assertions.assertThat(mensagem.getMensagem()).isEqualTo("salvou");
		Assertions.assertThat(mensagem.getTipo()).isEqualTo("whats");
	}
	@Test
	public void testUpdate() throws Exception {
		Mensagem mensagem = new Mensagem("15/05", "14:30", "jose", "salvou", "whats");
		mensagem = this.mensagemRepository.save(mensagem);
		mensagem.setMensagem("alterada");
		mensagem = this.mensagemRepository.save(mensagem);
		Assertions.assertThat(mensagem.getMensagem()).isEqualTo("alterada");
	}
	@Test
	public void testGet() throws Exception {
		Assertions.assertThat(mensagemRepository.findAll()).isNotEmpty();
	}
	@Test
	public void testDelete() throws Exception {
		long num = 18;
		boolean verificacao = mensagemRepository.existsById(num);
        if(verificacao){
            this.mensagemRepository.deleteById(num);
        }else{
			throw new ObjectNotFoundException("Objeto não encontrado");
        }
	}

}
