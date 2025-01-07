FROM airhacks/glassfish
COPY ./target/geekpump.war ${DEPLOYMENT_DIR}
