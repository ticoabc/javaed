package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
      
		/** The dao. */
		DAO dao = new DAO();
		
		/** The orcamento. */
		JavaBeans orcamento = new JavaBeans();
       
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();        
    }
    
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//testando a conexão
		//dao.testeConexao();
		
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/main")) {
			coletas(request, response);
		}else if(action.equals("/insert")) {
			novaColeta(request, response);
		}else if(action.equals("/select")) {
			listarOrca(request, response);
		}else if(action.equals("/update")) {
			editarOrca(request, response);
		}else if(action.equals("/delete")) {
			deletarOrca(request, response);
		}else if(action.equals("/report")) {
			gerarOrca(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	/**
	 * Coletas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//listar orçamentos
	protected void coletas(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				//response.sendRedirect("coleta.jsp");

		//Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarOrca();
		
		//Encaminhando a lista ao documento coleta.jsp
		request.setAttribute("orcamentos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("coleta.jsp");
		rd.forward(request, response);
		
		//testando se a lista está recebendo os dados
		/*for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getDisjprot());
		}*/
	}
	
	/**
	 * Nova coleta.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//Novo orçamento
	protected void novaColeta(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//testando o recebimento
		//System.out.println(request.getParameter("disjprot"));
		
		//setando as variáveis JavaBeans
		orcamento.setDisjprot(request.getParameter("disjprot"));
		
		//Invocando o método insereOrca passando o objeto orcamento
		dao.insereOrca(orcamento);
		
		//redirecionamento para o documento coleta.jsp
		response.sendRedirect("main");
		}
	
	/**
	 * Listar orca.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//Listar orçamento
	protected void listarOrca(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//Recebimento do id do orçamento que será editado
		//String id = request.getParameter("id");

		//setando a variável JavaBeans
		orcamento.setId(request.getParameter("id"));
		
		//Executar o método selecionaOrca (DAO)
		dao.selecionaOrca(orcamento);

		//setando os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("id", orcamento.getId());
		request.setAttribute("disjprot", orcamento.getDisjprot());
		
		//Encaminhando ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		
				//teste de recbimento
				//System.out.println(orcamento.getId());
				//System.out.println(orcamento.getDisjprot());
				
				//teste de envio do id 
				//System.out.println(id);
		}
		
		/**
		 * Editar orca.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		//Editar orçamento
		protected void editarOrca(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			//setando as variáveis JavaBeans
			orcamento.setId(request.getParameter("id"));
			orcamento.setDisjprot(request.getParameter("disjprot"));
			
			//executar método alterar orçamento
			dao.alterarOrca(orcamento);
			
			//redirecionando para o documento coleta.jsp (atualizando as informaçoes)
			response.sendRedirect("main");
			
			//teste de recbimento
			//System.out.println(request.getParameter("id"));
			//System.out.println(request.getParameter("disjprot"));			
		}
		
		/**
		 * Deletar orca.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		//Deletar orçamento
		protected void deletarOrca(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//recbimento do id do orçamento
			//String id = request.getParameter("id");			
			
			//setando a variável JavaBeans
			orcamento.setId(request.getParameter("id"));
				
			//executar método deletar Orçamento
			dao.deletarOrca(orcamento);
					
			//redirecionando para o documento coleta.jsp (atualizando as informações)
			response.sendRedirect("main");
					
			//teste de recbimento
			//System.out.println(id);						
		}
		
		/**
		 * Gerar orca.
		 *
		 * @param request the request
		 * @param response the response
		 * @throws ServletException the servlet exception
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		//Gerar orçamento PDF
		protected void gerarOrca(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
					
					Document documento = new Document();
					
					try {
						
						//tipo de conteúdo
						response.setContentType("apllication/pdf");

						//nome do documento
						response.addHeader("Content-Disposition", "inline; filename=" + "orcamentos.pdf");
						
						//criando o documento PDF
						PdfWriter.getInstance(documento, response.getOutputStream());

						//Abrir o documento -> conteúdo
						documento.open();
						documento.add(new Paragraph("Lista de Orçamentos:"));
						documento.add(new Paragraph(" "));
						
						//Criando uma tabela
						PdfPTable tabela = new PdfPTable(1);
						
						//Caeçalho
						PdfPCell col1 = new PdfPCell(new Paragraph("Disjuntor de Proteção"));
						tabela.addCell(col1);
						
						//Populando a tabela com os dados
						ArrayList<JavaBeans> lista = dao.listarOrca();
					
						for (int i = 0; i < lista.size(); i++) {
							
							tabela.addCell(lista.get(i).getDisjprot());

							//System.out.println(lista.get(i).getId());
							//System.out.println(lista.get(i).getDisjprot());
						}
						
						documento.add(tabela);						
						documento.close();
						
					} catch (Exception e) {
						System.out.println(e);
						documento.close();
					}
					
					//recbimento do id do orçamento
					//String id = request.getParameter("id");			
					
					//setando a variável JavaBeans
					//orcamento.setId(id);
						
					//executar método deletar Orçamento
					//dao.deletarOrca(orcamento);
							
					//redirecionando para o documento coleta.jsp (atualizando as informações)
					//response.sendRedirect("main");
							
					//teste de recbimento
					//System.out.println(id);						
				}
}