## Documentação de Autenticação – API Key

A API utiliza autenticação baseada em **API Key** para controlar o acesso às rotas da aplicação. Todas as requisições devem incluir uma chave de autenticação válida no header da requisição. Caso a chave não seja enviada ou seja inválida, a API retornará erro de acesso.

### Header obrigatório

Todas as requisições devem conter o seguinte header:

```
x-api-key: 123456789
```

### Exemplo de requisição – Listar times

**Método:** GET
**URL:** `http://localhost:8080/times`

**Headers:**

```
x-api-key: 123456789
```

**Resposta esperada (200 OK):**

```json
[
  {
    "id": 1,
    "nome": "Corinthians",
    "campeonatos": []
  }
]
```

### Exemplo de requisição – Criar time

**Método:** POST
**URL:** `http://localhost:8080/times`

**Headers:**

```
x-api-key: 123456789
Content-Type: application/json
```

**Body:**

```json
{
  "nome": "Corinthians"
}
```

**Resposta esperada (200 OK):**

```json
{
  "id": 1,
  "nome": "Corinthians",
  "campeonatos": []
}
```

### Possíveis respostas da API

**200 OK**
A requisição foi processada com sucesso.

**401 Unauthorized**
Retornado quando:

* O header `x-api-key` não foi enviado.
* A API Key informada é inválida.

**Mensagem de erro exemplo:**

```
API Key inválida ou não fornecida
```

### Observação

Todas as rotas da API exigem a presença do header `x-api-key`. Sem esse header, o acesso à aplicação é bloqueado pelo filtro de autenticação implementado no backend.
