package br.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.JogoBo;
import br.com.model.Jogo;

public class JogoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        if (acao.equals("listar")) {
            req.setAttribute("jogos", new JogoBo().listar());
            req.getRequestDispatcher("/views/index.jsp").forward(req, resp);

        } else if (acao.equals("deletar")) {
            int id = Integer.parseInt(req.getParameter("id"));
            new JogoBo().deletar(id);
            resp.sendRedirect("jogo?acao=listar");

        } else if (acao.equals("editar")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("jogo", new JogoBo().findById(id));
            req.getRequestDispatcher("/views/editar.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        if (acao.equals("cadastrar")) {
            Jogo jogo = new Jogo();
            jogo.setNome(req.getParameter("nome"));
            jogo.setPlataforma(req.getParameter("plataforma"));
            new JogoBo().salvar(jogo);
            resp.sendRedirect("jogo?acao=listar");

        } else if (acao.equals("editar")) {

            Jogo jogo = new Jogo();
            jogo.setId(Integer.parseInt(req.getParameter("id")));
            jogo.setNome(req.getParameter("nome"));
            jogo.setPlataforma(req.getParameter("plataforma"));
            new JogoBo().editar(jogo);
            resp.sendRedirect("jogo?acao=listar");
        }

    }

}