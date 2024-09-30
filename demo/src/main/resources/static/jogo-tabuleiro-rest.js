async function asyncCriarJogoTabuleiro(dadosJogoTabuleiro, proxsucesso, proxerro) {
    const URL = `/api/jogos-tabuleiro`;
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosJogoTabuleiro),
        headers: { 'Content-type': 'application/json' }
    };

    fetch(URL, postRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncLerJogosTabuleiro(proxsucesso, proxerro) {
    const URL = `/api/jogos-tabuleiro`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncLerJogoTabuleiroById(id, proxsucesso, proxerro) {
    const URL = `/api/jogos-tabuleiro/${id}`;
    fetch(URL)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonresponse => proxsucesso(jsonresponse))
        .catch(proxerro);
}

async function asyncAlterarJogoTabuleiro(dadosJogoTabuleiro, proxsucesso, proxerro) {
    const URL = `/api/jogos-tabuleiro/${dadosJogoTabuleiro.id}`;
    const putRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosJogoTabuleiro),
        headers: { 'Content-type': 'application/json' }
    };
    fetch(URL, putRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => resposta.json())
        .then(jsonResponse => proxsucesso())
        .catch(proxerro);
}

async function asyncApagarJogoTabuleiro(id, proxsucesso, proxerro) {
    const URL = `/api/jogos-tabuleiro/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })
        .then(resposta => proxsucesso())
        .catch(proxerro);
}
