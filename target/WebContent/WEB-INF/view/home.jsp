<!DOCTYPE html>
<html>
<head>
	<title>FazerTest</title>
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<script type="text/javascript" src="resources/js/funcoes.js"></script>
	<meta charset="utf-8">
</head>
<body>
	<div id="cabecalho">
		<img src="">
		<h1 id="logo">FazerTest</h1>
		<nav id="menu">
		<button onclick="criarTeste()">Criar teste</button>  
		</nav>
	</div>
	<div id="sobre">
		<h3>Crie um teste rápido e fácil</h3>
		<p style="font-family: sans-serif;">escolha como serão as questões valor da nota, aqui você pode personalizar do seu jeito, depois é só <strong>compartilhar</strong> seu teste para ser respondido, simples e prático!</p>
	</div>
	<h3 id="msg">${msg }</h3>
	<h3 class="esconde" id="link">Link do teste:<a href="/MakeProvas/responder?teste=${teste.id}">http://localhost:8080/MakeProvas/responder?teste=${teste.id}</a></h3>

	<form enctype="multipart/form-data" method="POST" id="form" class="esconde" action="/MakeProvas/registra" >
		<h3 class="inputTitulo">Escolha um nome para seu teste: <input type="text" name="titulo" placeholder="nome da prova aqui" required></h3><h3 class="inputTitulo">Escolha o valor maximo da nota: <input type="number" name="valor" placeholder="valor da nota" required></h3>

	<div id="formquest" class="esconde">
		<div id="questoes">
			<p class="esconde" id="index">1</p>
		</div>
		<input type="submit" name="enviar" value="Finalizar teste" id="submit">
	</div>
	</form>
	<a onclick="adicionarQuestao()" href="#" id="quest" class="esconde">adicionar questao</a>
	<a onclick="salvaQuestoes()" href="#" id="quest2" class="esconde">Salvar Questoes</a>
</body>
	<script type="text/javascript">
	function link(id){
		if(id > 0){
			var link = document.getElementById("link").classList.remove("esconde");
		}
		console.log(link);
	}
	
	link(${teste.id});
	</script>
</html>