FROM jenkins/jenkins:lts

USER root

RUN export DOCKER_VERSION=$(curl --silent --fail --retry 3 https://download.docker.com/linux/static/stable/x86_64/ | grep -o -e 'docker-[.0-9]*-ce\.tgz' | sort -r | head -n 1) \
  && DOCKER_URL="https://download.docker.com/linux/static/stable/x86_64/${DOCKER_VERSION}" \
  && echo Docker URL: $DOCKER_URL \
  && curl --silent --show-error --location --fail --retry 3 --output /tmp/docker.tgz "${DOCKER_URL}" \
  && ls -lha /tmp/docker.tgz \
  && tar -xz -C /tmp -f /tmp/docker.tgz \
  && mv /tmp/docker/docker /usr/local/bin/docker \
  && chown root:root /usr/local/bin/docker \
  && chmod +s /usr/local/bin/docker \
  && rm -rf /tmp/docker /tmp/docker.tgz

ARG COMPOSE_VERSION=1.22.0

RUN curl --silent --show-error --location --fail --retry 3 --output /usr/local/bin/docker-compose https://github.com/docker/compose/releases/download/${COMPOSE_VERSION}/docker-compose-Linux-x86_64 \
  && chown root:root /usr/local/bin/docker-compose \
  && chmod +sx /usr/local/bin/docker-compose \
  && docker-compose --version

USER jenkins
