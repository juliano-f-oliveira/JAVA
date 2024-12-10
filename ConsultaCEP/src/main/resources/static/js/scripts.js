async function consultarCep() {
   
    try {
        // Faz a requisição para o endpoint do backend       
        let cep = document.getElementById("cep").value;
        
        const checkbox = document.getElementById("meuCheckbox");
        
        var url = `/api/consultacep-mock?cep=`+ cep;
        
        if (checkbox.checked) {
        	url = `/api/consultacep-ext?cep=`+ cep;
        }
        
        const response = await fetch(url);
        
        if (response.ok) {
            const result = await response.json();
            
            console.log(result);

            document.getElementById("resultado").innerText = "Município:" + result.localidade + 
													         " | UF:"+ result.uf + 
													         " | CEP:" + result.cep;
            
            //Atualizar tabela 
            atualizarTabelaConsultas();
            
        } else {
            document.getElementById("resultado").innerText = "Erro ao consultar o CEP.";
        }
    } catch (error) {
        document.getElementById("resultado").innerText = "Erro ao consultar o CEP.";
        console.error("Erro:", error);
    }
}


//Busca de eventos

async function atualizarTabelaConsultas() {
    try {
        const response = await fetch('/api/eventos');
        
        if (response.ok) {
            const consultas = await response.json();
            const tabela = document.getElementById("tabelaConsultas");
            tabela.innerHTML = ""; // Limpar a tabela antes de adicionar novas linhas
            
            consultas.forEach(consulta => {
                const row = tabela.insertRow();
                row.insertCell(0).innerText = consulta.cep;
                row.insertCell(1).innerText = consulta.resultado;
                row.insertCell(2).innerText = consulta.dataHora;
            });
        }
    } catch (error) {
        console.error("Erro ao atualizar tabela de consultas:", error);
    }
}

 // Atualizar tabela ao carregar a página
window.onload = atualizarTabelaConsultas;