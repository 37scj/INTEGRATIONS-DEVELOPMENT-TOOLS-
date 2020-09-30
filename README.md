# INTEGRATIONS-DEVELOPMENT-TOOLS

  Desenvolva uma solução para o agronegócio que coleta dados via sensores de temperatura
  e umidade. Esses sensores ficarão instalados em um drone com uma altíssima autonomia
  de energia, pois conta com pequenos, porém muito eficientes painéis fotovoltaicos.
  A cada 10 segundos são enviados para o droneDTO broker os dados de temperatura e
  umidade capturado naquele instante.
  Além da primeira função também é possível acionar o rastreamento do drone. Esta
  funcionalidade resulta na localização do equipamento em um mapa.

# Fluxo

###  Servico 1 : droneBackend 
  - http://localhost:8090/swagger-ui.html

1. Recebemos os valores que sao inseridos em tela
1. Persistencia das informações (H2 em arquivo ~/)
1. Consumimos a mensagem da fila
1. Conforme a regra envia um email a cada minuto coma lista de drones na condição. 
    1. Temperatura >= 35 ou <=0 ou Umidade <= 15 


###  Servico 2: droneProducer
   - http://localhost:8091/swagger-ui.html
   
Simulação do serviço do drone

1. Produz uma mensagem na fila AMQP 
       
###  Servico 3: Localizacao google maps

1. Visualizar os drones no googlemaps (atualização a cada 10s)

# Imagem RabbitMQ

### Instale a imagem do RabbitMQ com docker

  - docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
  - docker exec -it rabbitmq bash -> Ativar o plugin para poder mover mensagens para outras filas 
  	- $ rabbitmq-plugins enable rabbitmq_shovel rabbitmq_shovel_management
### Docker compose

 Use o arquivo docker na raíz do projeto.
    docker-compose up -d

# Paineis

## Painel do RabbitMQ
  - http://localhost:15672/#/
  - user e password : guest
  
# H2
 - H2 Console  http://localhost:8090/h2-console
    - jdbc:h2:~/fiapstockdatabase;DB_CLOSE_ON_EXIT=FALSE

# Adicionando pre-drones na aplicação :

- Pre-adicionando drones na base
  - Altere na properties.yml a propriedade ddl-auto do hibernate para criar as tabela automaticamente para : create-drop 
  - Crie um arquivo "data.sql" dentro de : /src/main/resources
  - Passe a seguinte instrução no arquivo data.sql: 
                  insert into tb_drone (latitude, longitude, nome, temperatura, tracking, umidade, id) values (123213.0, 3213123.0,'Drone',-1.6, false, 25.3, 1);
      
# Usando o Exchange Direct 

- Ao Executar o projeto as filas sao criadas automaticamente
- Criacao do exchange do tipo direct que recebe a mensagem enviada pelo produtor e encaminha a mensagem para a fila destinada do produtor.


# Usando patterns de deadLetter

 - Caso o consumidor esteja inativo, nos atribuimos todas as mensagens 
  que nao foi realizada para uma fila de espera , podendo ser movidas novamente para serem consumidas
