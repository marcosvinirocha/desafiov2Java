# desafiov2 Project

Esse projeto foi desenvolvido em Java usando Quarkus , Hibernate e Postgress

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

> Certifique se o docker se está instalado e pousuir um container com postgres ou o mesmo instalado na maquina.

## Running the application in dev mode

Para rodar esse projeto use esse comando:

```shell
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Documentação da API

#### Retorna todos os itens

```http
GET /finalizar
```

#### Retorna todos os status em aprovação

```http
GET /finalizar/status
```

#### Salva todos os dados

```http
POST /finalizar/status
```

#### Apaga todos os dados em "Aprovação"

```http
DELETE /finalizar/
```

## Packaging and running the application

The application can be packaged using:

```shell
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 

```shell
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 

```shell
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/desafiov2-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

# 
