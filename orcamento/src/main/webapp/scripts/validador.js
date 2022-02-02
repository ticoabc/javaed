/**
 * Validacao de Formulario
 *@author Tiago de Freitas
 */
 
 function validar() {
	//alert('teste')
	
	let disjprot = frmcoleta.disjprot.value
		
		if(disjprot === "Selecione"){
			alert('Selecione uma das opções')
			frmcoleta.disjprot.focus()
			return false			
		}else {
			document.forms["frmcoleta"].submit()
		}
}