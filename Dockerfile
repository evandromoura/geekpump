FROM evandromoura/wildfly:24.0.1.Final.itm

	LABEL MAINTAINER Evandro Moura <evandro@trixti.com.br>

	USER root
	
	#CONEXAO
	COPY kubernetes/standalone.xml $JBOSS_HOME/standalone/configuration/standalone.xml
	COPY kubernetes/standalone.conf $JBOSS_HOME/bin/standalone.conf
	COPY kubernetes/postgresql-42.2.23.jre6.jar $JBOSS_HOME/standalone/deployments/

	#BUILD
	COPY /target/geekpump $JBOSS_HOME/standalone/deployments/geekpump.war
	
	#PORTAS
	EXPOSE 8080 8009 9990 7600 8888

	ENTRYPOINT $JBOSS_HOME/docker-entrypoint.sh