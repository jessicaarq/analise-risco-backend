package br.com.tst.service.helper;

import br.com.tst.domain.Veiculo;
import br.com.tst.domain.enumerate.Risco;
import org.springframework.stereotype.Service;

@Service
public class VeiculoHelper {

    public void calcRisco(Veiculo veiculo){
        if(veiculo.getAno() >= 2015){
            veiculo.setRisco(Risco.ALTO.getDescricao());
        }if(veiculo.getAno() < 2015 && veiculo.getAno() >= 2010){
            veiculo.setRisco(Risco.MEDIO.getDescricao());
        }if(veiculo.getAno() < 2010){
            veiculo.setRisco(Risco.BAIXO.getDescricao());
        }
    }

}
