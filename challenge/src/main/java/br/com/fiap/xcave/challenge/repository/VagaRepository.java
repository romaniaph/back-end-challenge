package br.com.fiap.xcave.challenge.repository;

import br.com.fiap.xcave.challenge.entity.Vaga;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VagaRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Vaga save(Vaga vaga) {
        dynamoDBMapper.save(vaga);
        return vaga;
    }

    public Vaga getVagaById(String vagaId) {
        return dynamoDBMapper.load(Vaga.class, vagaId);
    }

    public List<Vaga> getVagaByEstabelecimento(String estabelecimento) {
        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Vaga.class, dynamoDBScanExpression.withFilterExpression(estabelecimento));
    }

    public List<Vaga> getAll() {
        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Vaga.class, dynamoDBScanExpression);
    }

    public String delete(String vagaId) {
        Vaga vaga = dynamoDBMapper.load(Vaga.class, vagaId);
        dynamoDBMapper.delete(vaga);
        return "Vaga Deletada!";
    }

    public String update(String vagaId, Vaga vaga) {
        dynamoDBMapper.save(vaga,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("vagaId",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(vagaId)
                                )));
        return vagaId;
    }
}
