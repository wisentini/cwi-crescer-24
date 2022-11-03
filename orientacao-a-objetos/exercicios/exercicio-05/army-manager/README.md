# Army Manager

Com os constates conflitos na Síria, os terroristas do estado islamico, a disputa de territorio entre Japão e China pelas ilhas Senkaku/Diaoyu 
e a crise na Ucrânia, temos motivos para pensar que uma terceira guerra mundial pode eclodir a qualquer momento, então É BOM ESTARMO$ PREPARADO$.

Você será o responsavel por construir um sistema de simulação de custos de missoes militares, que deve atender as regras a seguir.

### Regras

#### Militares

Existem 8 tipos de militares:
- Elite
- EspecialistaDoAr
- EspecialistaTerrestre
- PilotoAviao
- PilotoCaminhao
- PilotoHelicoptero
- PilotoTanque
- Militar

Cada um conta com as seguintes habilidades:
- **Elite:** é capaz de pilotar qualquer coisa
- **Especialista Do Ar:** é capaz de pilotar qualquer veículo aereo
- **Especialista Terrestre:** é capaz de pilotar qualquer veículo terrestre
- **Piloto de Aviao / Caminhão / Helicoptero / Tanque:** só pilota seu respectivo veículo
- **Militar:** não sabe pilotar nenhum veículo.

Todos os tipos de militares tem um atributo de salário. Os militares que sabem pilotar algum veículo tem um atributo que é a validade da licença de pilotagem para o mesmo. Por exemplo:

- Piloto de Tanque
    - salário
    - data de validade da licença de pilotagem de tanques
    
- Especialista Terrestre
    - salário
    - data de validade da licença de pilotagem de tanques
    - data de validade da licença de pilotagem de caminhoes
    
**OBS: Pesquisem sobre a classe LocalDate do Java para os atributos de datas**

#### Veículos

Existem 4 tipos de veículos:
- Avião
- Caminhão
- Helicoptero
- Tanque

Todos os veículos tem os seguintes atributos:
- piloto
- tripulação (qualquer tipo de militar pode ser um tripulante)
- quilometragem por litro
- preço por litro do combustivel

A inicialização dos veículos devem obedecer as seguintes regras:
- Para inicializar um **avião**, deve ser informado no construtor um piloto capaz de pilotar um **avião** ou seja, um dos três tipos:
    - Elite
    - Especialista do Ar
    - Piloto de Avião
- Para inicializar um **tanque**, deve ser informado no construtor um piloto capaz de pilotar um **tanque**
- **O mesmo vale para todos os outros tipos de veículo**

##### Validação de tripulação

Todos os veículos devem ter um método **tripulacaoValida**, que retorna verdadeiro ou falso conforme as seguintes regras:
- **Todos os veículos:** A data de vencimento da licença do piloto deve ser maior que a data atual
- Avião:
    - No maximo uma pessoa na tripulação
- Caminhão:
    - No maximo 30 pessoas na tripulação, no minimo 5
- Helicoptero:
    - No maximo 10 pessoas na tripulação
- Tanque:
    - A tripulação sempre deve ter 3 pessoas

**Obs: Um piloto de elite pode estar com a licença de helicoptero em dia, mas a de caminhão vencida, por exemplo.**

#### Simulação Financeira

A classe de simulação financeira conta com os seguintes atributos:

- Distancia da viagem
- Veiculos da missão
- Duracao da missao (em meses)

E deve contar com os seguintes métodos:

- getCustoTotalMissao, calculado da seguinte maneira:

```
   somatorio do salario de todos os pilotos e tripulantes * duracao da missao + gasto total com combustivel de todos os veículos
```

O gasto com combustivel para um veículo é obtido através do calculo:

```
    distancia da viagem / quilometragem por litro do veiculo * preco do litro de combustivel para o veículo
```


- todasTripulacoesValidas, que retorna verdadeiro se a tripulação de todos os veículos que compoem a missão estiverem válidas;

# Exemplo de Teste

````
@Test
void deveCalcularOCustoTotalDaMissaoCorretamente() {

    ArrayList<Veiculo> veiculos = new ArrayList<>();

    veiculos.add(criarAviao());
    veiculos.add(criarTanque());
    veiculos.add(criarTanque());
    veiculos.add(criarTanque());
    veiculos.add(criarTanque());
    veiculos.add(criarTanque());

    SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1137, veiculos, 1);

    BigDecimal custoTotal = simulacao.getCustoTotalMissao();

    // Se esse teste falhar por centavos de diferença (pequenas diferenças de arredondamento) o valor do teste pode ser ajustado.
    assertEquals(BigDecimal.valueOf(213623.81), custoTotal);
    assertFalse(simulacao.todasTripulacoesValidas());
}

private Tanque criarTanque() {

    Elite piloto = new Elite(BigDecimal.valueOf(3000),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20),
            LocalDate.now().plusDays(20));

    ArrayList<Militar> tripulacao = new ArrayList<>();

    tripulacao.add(new PilotoTanqueImpl(BigDecimal.valueOf(2500), LocalDate.now().minusYears(1)));
    tripulacao.add(new Militar(BigDecimal.valueOf(600)));
    tripulacao.add(new Militar(BigDecimal.valueOf(600)));

    return new Tanque(piloto, tripulacao, 0.22, BigDecimal.valueOf(3.46));
}

private Aviao criarAviao() {

    EspecialistaDoAr piloto = new EspecialistaDoAr(BigDecimal.valueOf(7000), LocalDate.now().plusDays(-20), LocalDate.now().plusDays(20));

    ArrayList<Militar> tripulacao = new ArrayList<>();

    tripulacao.add(new Militar(BigDecimal.valueOf(2500)));

    return new Aviao(piloto, tripulacao, 0.14, BigDecimal.valueOf(10));
}
````

## Testes Obrigatórios

* Devem existir **obrigatóriamente** na solução entregue testes unitários com os seguintes nomes:

    - deveCalcularOCustoTotalDaMissaoCorretamente
    - deveCalcularOCustoTotalComCombustivelCorretamente
    - deveCalcularOCustoToralComSalariosCorretamente

## Bom exercicio!