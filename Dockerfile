# syntax=docker/dockerfile:1

# ===== 1) 빌드 스테이지: JDK + Gradle 래퍼로 실행 가능한 jar 생성 =====
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# (1) Gradle 래퍼와 빌드 스크립트를 먼저 복사한다.
#     소스(src)와 분리해서 복사해야, 소스만 바뀌었을 때 의존성 레이어를 캐시 재사용한다.
COPY gradlew ./
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew

# (2) 의존성을 미리 받아 레이어로 굳힌다. (네트워크 일시 오류로 빌드가 깨지지 않게 || true)
RUN ./gradlew dependencies --no-daemon || true

# (3) 소스 복사 후 jar 빌드. 이미지 빌드 단계에서는 테스트를 생략한다.
COPY src src
RUN ./gradlew bootJar --no-daemon -x test

# ===== 2) 런타임 스테이지: JRE만 있는 가벼운 이미지에 jar만 복사 =====
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app

# 보안상 root 대신 전용 사용자로 실행한다.
RUN useradd -r -u 1001 appuser
USER appuser

# 빌드 스테이지에서 만들어진 jar 하나만 가져온다. (소스/빌드도구는 최종 이미지에 안 들어감)
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
