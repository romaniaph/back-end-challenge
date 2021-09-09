package br.com.fiap.xcave.challenge.repository;

import br.com.fiap.xcave.challenge.entity.Usuario;
import br.com.fiap.xcave.challenge.entity.Vaga;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VagaRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Vaga save(Vaga vaga) {
        if(!checaVagaByEstabelecimentoAndPosicao(vaga.getEstabelecimento(), vaga.getPosicao())) {
            dynamoDBMapper.save(vaga);
        }
        return vaga;
    }

    public Vaga getVagaById(String vagaId) {
        return dynamoDBMapper.load(Vaga.class, vagaId);
    }

    public List<Vaga> getVagaByEstabelecimento(String estabelecimento) {

        List<Vaga> vagas = getAll();

        List<Vaga> vagasRetorno = new ArrayList<Vaga>();

        for (Vaga vaga : vagas) {
            if (vaga.getEstabelecimento().equals(estabelecimento)) {
                vagasRetorno.add(vaga);
            }
        }

        return vagasRetorno;

    }

    public boolean checaVagaByEstabelecimentoAndPosicao(String estabelecimento, int posicao) {

        List<Vaga> vagas = getAll();

        for (Vaga vaga : vagas) {
            if (vaga.getEstabelecimento().equals(estabelecimento) && vaga.getPosicao() == posicao) {
                return true;
            }
        }
        return false;
    }

    public boolean checaVagaByEstabelecimentoAndPosicaoAndId(String estabelecimento, int posicao, String id) {

        List<Vaga> vagas = getAll();

        for (Vaga vaga : vagas) {
            if (vaga.getEstabelecimento().equals(estabelecimento) && vaga.getPosicao() == posicao ) {
                return true;
            }
        }
        return false;
    }

    public List<Vaga> getAll() {
        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Vaga.class, dynamoDBScanExpression);
    }

    public String delete(String vagaId) {
        Vaga vaga = dynamoDBMapper.load(Vaga.class, vagaId);
        try{
            dynamoDBMapper.delete(vaga);
            return "Vaga Deletada!";
        }catch (Exception e){
            return "Vaga não encontrada!";
        }
    }

    public String update(String vagaId, Vaga vaga) {
        try{
            if(!checaVagaByEstabelecimentoAndPosicao(vaga.getEstabelecimento(), vaga.getPosicao()) ||
                    checaVagaByEstabelecimentoAndPosicaoAndId(vaga.getEstabelecimento(), vaga.getPosicao(), vagaId)) {
                dynamoDBMapper.save(vaga,
                        new DynamoDBSaveExpression()
                                .withExpectedEntry("vagaId",
                                        new ExpectedAttributeValue(
                                                new AttributeValue().withS(vagaId)
                                        )));
                return vagaId;
            }
        }catch (Exception e){
            return "Vaga não encontrada!";
        }
        return "Vaga já existente";
    }
}