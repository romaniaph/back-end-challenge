package br.com.fiap.xcave.challenge.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "usuario")
@Data
public class Usuario {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String usuarioId;

    @NotBlank(message = "O nome é obrigatório. Digite um nome.")
    @DynamoDBAttribute
    private String nome;

    @Email
    @DynamoDBAttribute
    private String email;

    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
    @DynamoDBAttribute
    private String senha;

    @DynamoDBAutoGeneratedTimestamp
    @DynamoDBAttribute
    private Date data;

}