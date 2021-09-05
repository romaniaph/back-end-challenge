package br.com.fiap.xcave.challenge.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "vaga")
@Data
public class Vaga {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String vagaId;

    @NotBlank(message = "O estabelecimento é obrigatória. Digite um estabelecimento.")
    private String estabelecimento;

    @DynamoDBAttribute
    private int posicao;

    @NotBlank(message = "O tipo é obrigatória. Digite um tipo.")
    @DynamoDBAttribute
    private String tipo;

    @NotBlank(message = "O status é obrigatório. Digite um status.")
    @DynamoDBAttribute
    private String status;

    @DynamoDBAttribute
    private Date data;
}