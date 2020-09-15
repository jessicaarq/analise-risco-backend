package br.com.tst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tst.domain.Veiculo;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
