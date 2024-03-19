package net.javaback.Hotelbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacote")
public class Pacote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private double preco;

    @Column(name = "descricao", length = 5000) // Defina o comprimento máximo do texto longo
    private String descricao;

    public String getPrecoFormatado() {
        // Cria um DecimalFormat para formatar o preço com vírgulas e pontos de acordo com o padrão local
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("1,000.00", symbols);

        // Retorna o preço formatado como uma string
        return df.format(this.preco);
    }
}
