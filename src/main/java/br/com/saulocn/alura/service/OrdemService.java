package br.com.saulocn.alura.service;

import br.com.saulocn.alura.model.Ordem;
import br.com.saulocn.alura.model.Usuario;
import br.com.saulocn.alura.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("Usuario diferente do userId informado");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
