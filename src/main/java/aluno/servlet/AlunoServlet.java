package aluno.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aluno.domain.Aluno;

@WebServlet(urlPatterns= "/alunoController")
public class AlunoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	List<Aluno> alunos = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*resp.setCharacterEncoding("UTF-8");
		for (Aluno aluno : alunos) {
			resp.getWriter().println("Nome: " + aluno.getNome() + ", Idade: " + aluno.getIdade());			
		}*/
		req.getRequestDispatcher("alunos.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("nome") == null || req.getParameter("idade") == null) {
			resp.getWriter().println("Informe os dados no formulário");
			return;
		}
		
		
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		Aluno aln = new Aluno();
		aln.setNome(nome);
		aln.setIdade(Integer.parseInt(idade));
		alunos.add(aln);
		resp.getWriter().print("Aluno Adicionado... Nome : " + aln.getNome() + ", Idade: " + aln.getIdade());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().print("index.html");
	}
}