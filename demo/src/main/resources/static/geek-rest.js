async function asyncCriarGeek(dadosGeek, proxsucesso, proxerro) {
    const URL = `/api/geeks`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosGeek),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerGeeks(proxsucesso, proxerro) {
    const URL = `/api/geeks`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerGeekById(id, proxsucesso, proxerro) {
    const URL = `/api/geeks/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarGeek(dadosGeek, proxsucesso, proxerro) {
    const URL = `/api/geeks/${dadosGeek.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosGeek),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarGeek(id, proxsucesso, proxerro) {
    const URL = `/api/geeks/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}
