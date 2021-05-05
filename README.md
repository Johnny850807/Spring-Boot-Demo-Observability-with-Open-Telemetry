1. clone
`https://github.com/Johnny850807/Spring-Boot-Demo-Observability-with-Open-Telemetry.git`
`cd Spring-Boot-Demo-Observability-with-Open-Telemetry`

2. Install docker's loki plugin
`docker plugin install grafana/loki-docker-driver:latest --alias loki --grant-all-permissions`

3. Build

`./mvnw package -DskipTests`
`docker-compose build`

4. Run:

`docker-compose -f infra.yml up -d`
`docker-compose up`

5. Issue a sign-up request:

After the spring boot application has been started, issue a sign-up request by 
`curl -X POST -H 'Content-Type: application/json' -d '{"name": "test", "email":"johnny@gmail.com", "password":"password"}' http://localhost:8080/api/users/signUp`

6. Navigation using Grafana:

Then go to the Grafana's dashboard: http://localhost:3000/

Go to the `Explore` page and select the loki data source, 
type in the query label `{compose_service="user-service"}`, 
and then you should see a log message produced by the sign-up request. Something like:
`2021-05-05 14:47:43 2021-05-05 06:47:43 - com.example.demo.UserController - SignUp: User{id=null, name='test', email='johnny@gmail.com', password='********'} traceID=81c01158ca964468a4c0b5817863d672`

After you found the message, click on the message, grafana will expand it and show the fields of the message.
You can find a blue `Tempo` button on the TraceID field. Click it, and then the distributed tracing panel will show up at the right-hand side.
