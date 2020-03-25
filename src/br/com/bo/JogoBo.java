package br.com.bo;

import java.util.List;

import br.com.dao.JogoDao;
import br.com.model.Jogo;

public class JogoBo {

    public List<Jogo> listar() {
        return new JogoDao().listar();
    }

    public void deletar(Integer id) {
        new JogoDao().deletar(id);
    }

    public void salvar(Jogo jogo) {
        new JogoDao().salvar(jogo);
    }

    public Jogo findById(Integer id) {
        return new JogoDao().findById(id);
    }

    public void editar(Jogo jogo) {
        new JogoDao().editar(jogo);
    }

}