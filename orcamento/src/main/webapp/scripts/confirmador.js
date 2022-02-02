/**
 * Confirmacao de exclusao de um orçamento
 *@author Tiago de freitas
 *@param id 
 */
 
 function confirmar(id){
	let resposta = confirm("Deseja excluir este orçamento")
	if  (resposta===true){
		//alert(id)
		window.location.href = "delete?id=" + id
	}
}