async function asyncCriarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta.json();
        })
        .then(jsonResponse => {
            proxsucesso(jsonResponse);
        })
        .catch(proxerro);
}

async function asyncLerAvaliacoes(proxsucesso, proxerro) {
    const URL = `/api/avaliacoes`;
    fetch(URL)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta.json();
        })
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerAvaliacaoById(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${id}`;
    fetch(URL)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta.json();
        })
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarAvaliacao(dadosAvaliacao, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${dadosAvaliacao.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosAvaliacao),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta.json();
        })
        .then(jsonResponse => proxsucesso(jsonResponse))
        .catch(proxerro);
}

async function asyncApagarAvaliacao(id, proxsucesso, proxerro) {
    const URL = `/api/avaliacoes/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => {
            if (!resposta.ok) throw Error(resposta.status);
            return resposta;
        })
        .then(() => proxsucesso())
        .catch(proxerro);
}
