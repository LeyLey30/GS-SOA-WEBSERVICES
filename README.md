
Gustavo Bonani RM553493
Vinicius Caetano RM552904
Wesley Leopoldino RM553496


O projeto é composto por um backend Java/Spring Boot, organizado em camadas:

✔️ 1. Gestão de Tarefas (Core do sistema)

O backend implementa:

Criação, edição, listagem e exclusão de tarefas.

Classificação por:

Status (TO_DO, IN_PROGRESS, DONE)

Prioridade (LOW, MEDIUM, HIGH, CRITICAL)

Mapeamento entre DTOs, entidades e serviços.

Esses recursos permitem montar rotinas personalizadas para equilibrar compromissos pessoais e profissionais.

✔️ 2. Persistência e Migrações

O projeto utiliza:

Spring Data JPA

Banco configurado via docker-compose.yml

Migração inicial: V1__create_tasks_table.sql

Isso garante estrutura escalável para armazenamento de dados do usuário.

✔️ 3. APIs e Arquitetura de Serviços

O backend expõe endpoints REST por meio do TaskController.

Ele também possui:

ExternalIntegrationService: preparado para conectar o app com serviços externos
(ex: calendários, IA, aplicativos corporativos, automação).

WebClientConfig: configuração para chamadas HTTP a APIs externas.

✔️ 4. Tratamento Global de Erros

GlobalExceptionHandler garante respostas padronizadas e claras para aplicações frontend ou mobile.

✔️ 5. Preparação para Expansões Futuras

O código está estruturado para:

adicionar gamificação (pontos, streaks, conquistas),

integrar IA para organizar agenda,

sincronizar compromissos de trabalho e pessoais,

gerar recomendações inteligentes para equilibrar rotina.
