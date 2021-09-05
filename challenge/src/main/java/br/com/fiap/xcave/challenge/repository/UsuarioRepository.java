package br.com.fiap.xcave.challenge.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import br.com.fiap.xcave.challenge.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Usuario save(Usuario usuario) {
        dynamoDBMapper.save(usuario);
        return usuario;
    }

    public Usuario getUsuarioById(String usuarioId) {
        return dynamoDBMapper.load(Usuario.class, usuarioId);
    }

    public List<Usuario> getAll() {
        DynamoDBScanExpression dynamoDBScanExpression = new DynamoDBScanExpression();
        return dynamoDBMapper.scan(Usuario.class, dynamoDBScanExpression);
    }

    public String delete(String usuarioId) {
        Usuario usuario = dynamoDBMapper.load(Usuario.class, usuarioId);
        dynamoDBMapper.delete(usuario);
        return "Usuario Deletado!";
    }

    public String update(String usuarioId, Usuario usuario) {
        dynamoDBMapper.save(usuario,
                new DynamoDBSaveExpression()
        .withExpectedEntry("usuarioId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(usuarioId)
                )));
        return usuarioId;
    }
}
