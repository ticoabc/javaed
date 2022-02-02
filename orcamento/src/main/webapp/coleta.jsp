<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="model.JavaBeans"%>
    <%@ page import="java.util.ArrayList"%>
    <% 
    	@SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("orcamentos");
    	
    	//testando se a lista está recebendo os dados
		/*for (int i = 0; i < lista.size(); i++) 
			{
			out.println(lista.get(i).getId());
			out.println(lista.get(i).getDisjprot());	
			}*/
	%>
		
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>PHO - Sistemas Fotovoltáicos</title>
	<link rel="icon" href="imagens/1.placa.png">
	<link rel="stylesheet" href="style.css">
</head>
<body>
		<h1>Coleta de Dados</h1>
		<a href="novo.html" class="Botao1"> Novo </a>
		<a href="report" class="Botao2"> Relatório</a>		
		<table id="tabela">
			<thead>
				<tr>
					<th>Id</th>
					<th>Disjuntor de Proteção</th>
					<th>Opções</th>
				</tr>
			</thead>
				<tbody>
					<%for (int i = 0; i < lista.size(); i++) { %>
						<tr>
							<td><%=lista.get(i).getId()%></td>
							<td><%=lista.get(i).getDisjprot()%></td>
							<td><a href="select?id=<%=lista.get(i).getId()%>" class="Botao1">Editar</a>
								<a href="javascript: confirmar(<%=lista.get(i).getId()%>)"  class="Botao2">Excluir</a>
							</td>
						</tr>
					<%} %>
				</tbody>
		</table>		
		<script src="scripts/confirmador.js"></script>
</body>
</html>