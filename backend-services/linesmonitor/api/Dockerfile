FROM ubuntu:22.04

RUN apt-get update && apt-get install -y \
gnupg2 \
wget \
less \
curl \
unzip \
&& rm -rf /var/lib/apt/lists/*

COPY src/main/docker/entrypoint.sh /entrypoint.sh
COPY build/libs/api-1.0.0.jar /api-1.0.0.jar

RUN apt-get update && \
    apt-get install -y openjdk-17-jre-headless && \
    apt-get clean;

RUN set -e; \
    chmod 0755 /entrypoint.sh

RUN wget -q https://storage.googleapis.com/chrome-for-testing-public/129.0.6668.91/linux64/chrome-headless-shell-linux64.zip \
    && unzip chrome-headless-shell-linux64.zip -d / \
    && rm chrome-headless-shell-linux64.zip

RUN wget -q https://storage.googleapis.com/chrome-for-testing-public/129.0.6668.91/linux64/chromedriver-linux64.zip \
    && unzip chromedriver-linux64.zip -d / \
    && rm chromedriver-linux64.zip \
    && chmod +x /chromedriver-linux64/chromedriver


ENV DISPLAY=:99

#RUN export CHROMEDRIVER_VERSION=$(curl --silent https://chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
#    wget -q https://chromedriver.storage.googleapis.com/${CHROMEDRIVER_VERSION}/chromedriver_linux64.zip && \
#    unzip chromedriver_linux64.zip -d /usr/bin && \
#    chmod 755 /usr/bin/chromedriver && \
#    rm -f chromedriver_linux64.zip

WORKDIR /
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]