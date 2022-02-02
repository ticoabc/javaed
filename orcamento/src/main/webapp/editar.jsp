<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PHO - Engenharia</title>
	<link rel="icon" href="imagens/1.placa.png">
	<link rel="stylesheet" href="style.css">	
</head>
<body>
	<h2>
     <fieldset>
      <legend><b>Editar Parâmetros</b></legend>
          </fieldset>
    </h2>
      <div class="container">
        <fieldset>
	<p><b>1.Padrão de Entrada da Unidade Consumidora</b></p>
	<form name="frmcoleta" action="update">
		<div class="row">
			<tr>
         		<td><input type="text" name="id" id="caixa2" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
         	</tr>
         <div class="colunas">
        	<label for="fname">Disjuntor de Proteção (A)</label>
        	</div>
         <div class="colunas2">
        	<select id="disjprot" name="disjprot">
        			<%--value="<%out.print(request.getAttribute("disjprot"));%>"--%>
        			<option value="Selecione">Selecione</option>
                	<option value="40">40</option>
                    <option value="50">50</option>
                    <option value="63">63</option>
                    <option value="70">70</option>
                    <option value="80">80</option>
                    <option value="100">100</option>
                    <option value="125">125</option>
                    <option value="150">150</option>
                    <option value="175">175</option>
                    <option value="200">200</option>
               </select>
             </div>
           </div>
           	<br>
        	<br>
        <div class="row">
    	<input type="button" value="Salvar" class="Botao1" onclick="validar()">
    	</div>
    	 		</form>
    	 		<script src="scripts/validador.js"></script>
    		</fieldset> 	
		</div>
	</body>
</html>