# Epic Task – Projeto com Design Patterns

Este projeto é um app web interativo feito com **Spring Boot + Thymeleaf**, onde o usuário pode **completar desafios diários** e **ganhar recompensas** com bônus variáveis.

A versão atual do código **não aplica Design Patterns**. O desafio do aluno é **refatorar o código para aplicar os padrões Factory Method e Strategy**, melhorando a manutenibilidade e organização da lógica de negócios.



## 🚀 Funcionalidades

- Cadastro e listagem de desafios
- Conclusão de desafios com geração de recompensa
- Regras de bônus variáveis conforme o contexto (dia da semana, tipo do desafio)
- Inventário de recompensas recebidas



## 🧠 Atividades

1. Clonar o projeto localmente e rodá-lo com Spring Boot.
2. Analisar a classe `DesafioService`:
   - Contém `if-else` para decidir qual recompensa gerar
   - Contém regras de cálculo de bônus misturadas na mesma função
3. Aplicar os Design Patterns:
   - ✅ **Factory Method** para gerar objetos `Recompensa` com base no tipo do desafio
   - ✅ **Strategy** para encapsular a lógica de cálculo do bônus em classes diferentes
4. Refatorar o projeto mantendo todas as funcionalidades originais funcionando.

---

## 📦 Como baixar e executar

1. Clone este repositório:

```bash
git clone https://github.com/seu-usuario/desafios-diarios.git
cd desafios-diarios
```

2. Importe o projeto em sua IDE favorita (IntelliJ, Eclipse, VS Code...)

3. Rode a aplicação (`DesafiosApplication.java`) ou via terminal:

```bash
./mvnw spring-boot:run
```

4. Acesse no navegador:

```
http://localhost:8080
```


## 🧑‍💻 Autor

Este projeto foi desenvolvido como exercício prático da disciplina de Programação Orientada a Objetos.
