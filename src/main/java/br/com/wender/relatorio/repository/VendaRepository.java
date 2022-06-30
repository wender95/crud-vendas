package br.com.wender.relatorio.repository;

import br.com.wender.relatorio.model.Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {
}
