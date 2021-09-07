# Back-End-Challenge

Grupo xcave:

Pedro Henrico Romania Pires RM: 85439
Rodrigo André Chiarelli Gonçalves RM: 85716
Victor Luiz Dias Parisi RM: 84190

APIs
@Post – Cadastrar vaga
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/
{
    "estabelecimento":"teste2",
    "posicao":1,
    "tipo":"normal",
    "status":"ativo"
}

@Get – Pegar todas as vagas
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga

@Get - Ler vaga pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}

@Get – Pegar vagas pelo estabelecimento
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{estabelecimento}

@Delete – Deletar a vaga pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}

@Put – Atualizar a vaga pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/vaga/{id}
{
    "estabelecimento":"teste2",
    "posicao":1,
    "tipo":"normal",
    "status":"ativo"
}

@Post – Cadastrar usuario
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuário
{
    "nome":"teste",
    "email":"teste@teste.com.br",
    "senha":"teste123"
}

@Get – Pegar todos os usuario
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuario

@Get - Ler usuário pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuário/{id}

@Delete – Deletar o usuário pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuário/{id}

@Put – Atualizar o usuário pelo ID
ec2-54-94-108-33.sa-east-1.compute.amazonaws.com:8083/usuário/{id}
{
    "nome":"teste",
    "email":"teste@teste.com.br",
    "senha":"teste123"
}

