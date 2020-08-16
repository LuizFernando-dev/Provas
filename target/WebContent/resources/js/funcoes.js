
function criarTeste(){
	var form = document.getElementById("form");
	var quest = document.getElementById("quest");
	var quest2 = document.getElementById("quest2");
	var link = document.getElementById("link");
	var msg = document.getElementById("msg");
	form.classList.remove("esconde");
	quest.classList.remove("esconde");
	quest2.classList.remove("esconde");
	link.classList.add("esconde");
	msg.classList.add("esconde");
}

function adicionarQuestao(){
	var index = Number(document.getElementById("index").innerHTML);
	var submit = document.getElementById("submit");
	submit.classList.add("esconde");
	
	var form = document.getElementById("formquest");
	var questoes = document.getElementById("questoes");
	form.classList.remove("esconde");

	var h3 = document.createElement("h3");
	h3.innerHTML = "Titulo da questao: ";
	var inputTitulo = document.createElement("input");
	inputTitulo.setAttribute("type", "text");
	inputTitulo.setAttribute("required", "");
	inputTitulo.setAttribute("name", "tituloQuest")
	h3.appendChild(inputTitulo);
	var br = document.createElement("br");
	var arquivo = document.createElement("input");
	arquivo.setAttribute("type", "file");
	arquivo.setAttribute("name", "arquivo");
	arquivo.setAttribute("id", "arq"+index);
	
	
	var alternativa = document.createElement("input");
	alternativa.setAttribute("name", "q1");
	alternativa.setAttribute("id", "q1" + index);
	alternativa.setAttribute("value", "Digite uma alternativa aqui");
	var radio = document.createElement("input");
	radio.setAttribute("name", "alt" + index);
	radio.setAttribute("value", "q1");
	radio.setAttribute("type", "radio");
	alternativa.setAttribute("type", "text");

	var br2 = document.createElement("br");
	var alt2 = document.createElement("input");
	alt2.setAttribute("name", "q2");
	alt2.setAttribute("type", "text");
	var rad2 = document.createElement("input");
	rad2.setAttribute("name", "alt"+ index);
	alt2.setAttribute("id", "q2" + index);
	rad2.setAttribute("value", "q2");
	rad2.setAttribute("type", "radio");
	alt2.setAttribute("value", "Digite uma alternativa aqui");

	var br3 = document.createElement("br");
	var alt3 = document.createElement("input");
	alt3.setAttribute("name", "q3");
	alt3.setAttribute("id", "q3" + index);
	alt3.setAttribute("type", "text");
	var rad3 = document.createElement("input");
	rad3.setAttribute("name", "alt"+ index);
	rad3.setAttribute("name", "alt"+ index);
	rad3.setAttribute("value", "q3");
	rad3.setAttribute("type", "radio");
	alt3.setAttribute("value", "Digite uma alternativa aqui");

	var br4 = document.createElement("br");
	var alt4 = document.createElement("input");
	alt4.setAttribute("name", "q4");
	alt4.setAttribute("id", "q4" + index);
	alt4.setAttribute("type", "text");
	var rad4 = document.createElement("input");
	rad4.setAttribute("name", "alt"+ index);
	rad4.setAttribute("value", "q4");
	rad4.setAttribute("type", "radio");
	alt4.setAttribute("value", "Digite uma alternativa aqui");
	
	var div = document.createElement("div");
	div.setAttribute("id", "questao"+index);

	div.appendChild(h3);
	div.appendChild(br);
	div.appendChild(arquivo);
	div.appendChild(br);
	div.appendChild(radio);
	div.appendChild(alternativa);
	div.appendChild(br2);
	div.appendChild(rad2);
	div.appendChild(alt2);
	div.appendChild(br3);
	div.appendChild(rad3);
	div.appendChild(alt3);
	div.appendChild(br4);
	div.appendChild(rad4);
	div.appendChild(alt4);
	questoes.appendChild(div);
	
	document.getElementById("index").innerHTML = index + 1;
	
	}

function salvaQuestoes(){	
	var index = Number(document.getElementById("index").innerHTML);
	var cont = 1;
	var boolean = true;

		while(cont < index){
				var resposta = document.querySelector('input[name=alt'+cont+']:checked');
				if(resposta != null){
					resposta = resposta.value;
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", resposta);
					input.setAttribute("value","resposta");
					var questao = document.getElementById("questao"+cont);
					questao.appendChild(input);
					console.log("resposta do radio: "+resposta);
					var quest = document.getElementById(resposta + cont);
					var q = document.getElementById(resposta + cont).value;
					quest.setAttribute("name", "resposta");
					cont++;
					console.log(q);
				}else{
					alert("Selecione uma aternativa nos campos abaixo");
					boolean = false;
					break;
				}
		}
		
		if(boolean){	
			var adicionar = document.getElementById("quest");
			adicionar.classList.add("esconde");
			var salva = document.getElementById("quest2");
			salva.classList.add("esconde");
			var submit = document.getElementById("submit");
			submit.classList.remove("esconde");
		}
}









