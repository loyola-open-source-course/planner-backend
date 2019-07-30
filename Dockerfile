FROM openjdk:8-jre-alpine

COPY ./build/unpacked/BOOT-INF/lib      /app/lib
COPY ./build/unpacked/META-INF          /app/META-INF
COPY ./build/unpacked/BOOT-INF/classes  /app

EXPOSE 80

ENTRYPOINT [ "java", \
             "-Djava.security.egd=file:/dev/./urandom", \
             "-XX:+UnlockExperimentalVMOptions", \
             "-XX:+UseCGroupMemoryLimitForHeap", \
             "-cp", "app:app/lib/*", \
             "com.loyola.planner.Application" \
]