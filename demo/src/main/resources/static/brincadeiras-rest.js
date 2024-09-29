async function asyncCriarBrincadeira(dadosBrincadeira, proxsucesso, proxerro) {
    const URL = `/api/brincadeiras`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosBrincadeira),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerBrincadeiras(proxsucesso, proxerro) {
    const URL = `/api/brincadeiras`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerBrincadeiraById(id, proxsucesso, proxerro) {
    const URL = `/api/brincadeiras/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarBrincadeira(dadosBrincadeira, proxsucesso, proxerro) {
    const URL = `/api/brincadeiras/${dadosBrincadeira.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosBrincadeira),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarBrincadeira(id, proxsucesso, proxerro) {
    const URL = `/api/brincadeiras/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}
