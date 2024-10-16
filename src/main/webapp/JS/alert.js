function mostrarAlerta(event) {
	event.preventDefault();// Impede o envio do formulário para que o alerta seja exibido
	alert("Formulário enviado com sucesso!");
	event.target.submit();
}