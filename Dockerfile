# 1. JDK 이미지 기반
FROM openjdk:21-jdk-slim

# 2. 컨테이너 내부 작업 디렉토리
WORKDIR /app

# 3. 빌드된 JAR 복사
#   (Gradle 빌드 시 build/libs/myapp-0.0.1-SNAPSHOT.jar 생성됨)
COPY build/libs/*.jar app.jar

# 4. 포트 오픈(생략 가능 - 해당 컨테이너는 8080포트를 사용한다는 의미)
EXPOSE 8087

# 5. 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]