[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucarauj/JPA-Hibernate/blob/main/LICENSE) 

<h1 align="center"> Devendando o:</h1>

<p align="center"><img width="400px" src="https://github.com/lucarauj/assets/blob/main/JPA-Hibernate.png" /></p>

### 🛠 Dependências:

- Hibernate Entitymanager
- H2 Database
- Postgres

<br>

### 🖱 JPA persistence.xml Example:

https://examples.javacodegeeks.com/java-development/enterprise-java/jpa/java-persistence-xml-example/

<br>

### ⛏ Criando e configurando arquivo ```persistence.xml```:

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="rasfood" transaction-type="RESOURCE_LOCAL">
        <class><!-- Entity Manager Class Name --></class>

        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:rasfood" />
            <property name="javax.persistence.jdbc.user" value="admin" />
            <property name="javax.persistence.jdbc.password" value="admin" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
	    <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.format_sql" value="true"/>
        </properties>

    </persistence-unit>
</persistence>
```

<br>

### 📝 Anotações:

- @Column: usada para especificar o mapeamento entre um atributo de entidade básico e a coluna da tabela de banco de dados;
- @Entity: utilizada para informar que uma classe também é uma entidade;
- @Embeddable: usada para especificar tipos incorporáveis;
- @Embedded é usada para especificar que um determinado atributo de entidade representa um tipo incorporável;
- @EmbeddedId: usada para especificar que o identificador de entidade é um tipo incorporável;
- @GeneratedValue(strategy = GenerationType.IDENTITY)
- @Id: especifica o identificador da entidade, que é usado ao carregar a entidade em um determinado contexto de persistência;
- @ManyToOne(fetch = FetchType.LAZY): relacionamento muitos para um onde determinados objetos não serão carregados do banco até que sejam solicitado seu carregamento;
- @ManyToMany: uma ou mais linhas de uma entidade são associadas a mais de uma linha em outra entidade;
- @OneToMany: cada linha de uma entidade é referenciada a muitos registros filho em outra entidade;
- @Table: usada para especificar a tabela principal da entidade atualmente anotada;

<br>

### ⛏ Preparando arquivo ```persistence.xml``` para o Postgres:

```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
             xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="rasfood" transaction-type="RESOURCE_LOCAL">
        <class><!-- Entity Manager Class Name --></class>

        <properties>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:mem:rasfood" />
            <property name="javax.persistence.jdbc.user" value="admin" />
            <property name="javax.persistence.jdbc.password" value="admin" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
	    <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

<br>

### 🗜 Dependência adicionada no ```pom.xml```:
```
<dependency>
		    <groupId>org.postgresql</groupId>
		    <artifactId>postgresql</artifactId>
		    <version>42.6.0</version>
</dependency>
```

<br>

# 👨‍🎓 Aluno
Lucas Araujo

<a href="https://www.linkedin.com/in/lucarauj"><img alt="lucarauj | LinkdeIN" width="40px" src="https://user-images.githubusercontent.com/43545812/144035037-0f415fc7-9f96-4517-a370-ccc6e78a714b.png" /></a>
