# Back-End-Challenge

## Grupo xcave:

1. Pedro Henrico Romania Pires RM: 85439;
2. Rodrigo André Chiarelli Gonçalves RM: 85716;
3. Victor Luiz Dias Parisi RM: 84190;

## Lista de APIs
### USUARIO:
### @Post – Cadastrar usuário
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario
Exemplo de body:
```json
{
    "nome":"FIAP",
    "email":"teste@teste.com.br",
    "senha":"teste123"
}
```
Exemplo de Retorno:
```json
{
    "usuarioId": "5bffab88-fa4d-475d-b70a-f0e575b855b1",
    "nome":"FIAP",
    "email":"teste@teste.com.br",
    "senha":"teste123",
    "data": "2021-09-09T01:28:05.940+00:00"
}
```
Exemplo de Retorno se email já existir no banco:
```json
{
    "usuarioId": null,
    "nome":"FIAP",
    "email":"teste@teste.com.br",
    "senha":"teste123",
    "data": null
}
```
### @Get – Retorna todos os usuários
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario

### @Get – Retorna o usuário em caso do login do usuário estar correto ou null caso esteja incorreto
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/login/{{email}}/{{senha}}

### @Get - Ler usuário pelo ID
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario/{id}

### @Delete – Deletar o usuário pelo ID (retorna a string "Usuario Deletado!" em caso de sucesso ou "Usuario não encontrado!" em caso de não encontrar)
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario/{id}

### @Put – Atualizar o usuário pelo ID (retorna o usuarioId caso tenha sucesso, "Email já existente" caso já exista o email cadastrado com outro usuário ou "Usuario não encontrado!" caso não encontre o ID)
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario/{id}
Exemplo de body:
```json
{
     "usuarioId": "403663e1-b1a7-431e-bcb8-ca631cad750e",
     "nome": "FIAP",
     "email": "teste@teste.com.br",
     "senha": "teste123"
}
```

### VAGA:
### @Post – Cadastrar vaga
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/
Exemplo de body:
```json
{
    "estabelecimento":" supermercado ",
    "posicao":1,
    "tipo":"normal",
    "status":"ativo"
}
```
Exemplo de Retorno:
```json
{
    "usuarioId": "5bffab88-fa4d-475d-b70a-f0e575b855b1",
    "estabelecimento":" supermercado ",
    "posicao":1,
    "tipo":"normal",
    "status":"ativo",
    "data": "2021-09-09T01:28:05.940+00:00"
}
```
Exemplo de Retorno se email já existir no banco:
```json
{
    "usuarioId": null,
    "estabelecimento":"supermercado",
    "posicao":1,
    "tipo":"normal",
    "status":"ativo",
    "data": null
}
```
### @Get – Retorna todas as vagas
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga

### @Get – Retorna todas as vagas de determinado estabelecimento
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/estabelecimento/{estabelecimento}

### @Get - Ler vaga pelo ID
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}

### @Delete – Deletar a vaga pelo ID (retorna a string "Vaga Deletada!" em caso de sucesso ou "Vaga não encontrada!" em caso de não encontrar)
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}

### @Put – Atualizar a vaga pelo ID (retorna o vagaId caso tenha sucesso, "Vaga já existente" caso já exista a vaga cadastrada com o mesmo estabelecimento e posição ou "Vaga não encontrada!" caso não encontre o ID)
#### ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}
```json
{
    "vagaId": "9cdb5960-7891-4040-a7f0-d1efbd655c9b",
    "estabelecimento": "supermercado",
    "posicao": 12,
    "tipo": "deficiente",
    "status": "inativo"
}
```