async function asyncCriarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = '/api/avaliacoes'; // Corrigido para usar aspas simples
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-Type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso(jsonResponse)) // Passando a resposta JSON
        .catch(proxerro);
}

async function asyncLerAvaliacoes(proxsucesso, proxerro) {
    const URL = '/api/avaliacoes'; // Corrigido para usar aspas simples
    fetch(URL)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerAvaliacaoById(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${id}`; // Usando template string para interpolação
    fetch(URL)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${dadosAvaliacao.id}`; // Usando template string para interpolação
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-Type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso(jsonResponse)) // Passando a resposta JSON
        .catch(proxerro);
}

async function asyncApagarAvaliacao(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${id}`; // Usando template string para interpolação
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { 
            if (!resposta.ok) throw Error(resposta.status); 
            return resposta; 
        })
        .then(() => proxsucesso()) // Chamar sucesso sem dados adicionais
        .catch(proxerro);
}
