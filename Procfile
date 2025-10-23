web: java -javaagent:java-agent/opentelemetry-javaagent.jar -jar target/BeanstalkJavaExample-1.0-SNAPSHOT.jar


java   -jar target/*.jar

OTEL_LOGS_EXPORTER=otlp \         
OTEL_EXPORTER_OTLP_ENDPOINT=https://ingest.us.signoz.cloud \
OTEL_EXPORTER_OTLP_HEADERS="signoz-ingestion-key=30b60f80-fac7-4c81-9aae-c301073aae54" \
OTEL_RESOURCE_ATTRIBUTES=service.name=sample_java_app \
