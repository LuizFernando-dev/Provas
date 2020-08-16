function salvaQuestoes(){
	var cont = 1;
	var boolean = true;
	var index = document.getElementById("index").value;
	console.log(index);

		while(cont <= index){
				var resposta = document.querySelector('input[name=alt'+cont+']:checked');
				var hidden = document.getElementById("hidden"+cont);
				console.log(hidden);
				if(resposta.value == "resposta"){
					hidden.setAttribute("name", "resposta");
					hidden.setAttribute("value", "resposta");
					console.log("teste");
				}
				
				cont++;
		}
		
}

