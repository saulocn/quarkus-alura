package br.com.saulocn.alura.repository;

import br.com.saulocn.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}
