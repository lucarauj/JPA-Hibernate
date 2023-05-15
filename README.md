# JPA-Hibernate
Projeto feito em Aula ministrada pela Rasmoo Cursos de tecnologia.


### Dependências:

- Hibernate Entitymanager
- H2 Database

https://examples.javacodegeeks.com/java-development/enterprise-java/jpa/java-persistence-xml-example/
### Criando e configurando arquivo ```persistence.xml```:

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

### Anotações:

- @Entity
- @Table
- @Id
- @GeneratedValue(strategy = GenerationType.IDENTITY)
- @Column
- @ManyToOne(fetch = FetchType.LAZY)
- @ManyToMany
- @OneToMany
- @Embaddable
- @Embedded

### Preparando arquivo ```persistence.xml``` para o Postgres:

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

### Dependência adicionada no ```pom.xml```:
```
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```