package state.artigo;

import java.time.LocalDate;

public class EstadoRascunho implements Estado {

	public Artigo artigo;

	public EstadoRascunho(Artigo artigo) {
		this.artigo = artigo;
	}

	@Override
	public void publicar() {
		GerenteDeSeguranca seguranca = GerenteDeSeguranca.getInstance();

		if (seguranca.isAutor()) {
			this.artigo.transitarEstadoPara(new EstadoRevisando(artigo));
			this.artigo.getLogHistorico().add("Tansitado para REVISANDO em + " + LocalDate.now());
			return;
		} else {
			throw new RuntimeException("Usuario não tem permissão para publicar");
		}

	}

	@Override
	public void reprovar() {
		// TODO Auto-generated method stub

	}

}
