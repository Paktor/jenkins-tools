FROM ubuntu:bionic

# make Apt non-interactive
RUN echo 'APT::Get::Assume-Yes "true";' > /etc/apt/apt.conf.d/90jenkins \
  && echo 'DPkg::Options "--force-confnew";' >> /etc/apt/apt.conf.d/90jenkins

ENV DEBIAN_FRONTEND=noninteractive

# Set timezone to UTC by default
RUN ln -sf /usr/share/zoneinfo/Etc/UTC /etc/localtime

RUN apt-get update \
    && mkdir -p /usr/share/man/man1 \
    && apt-get install -y --no-install-recommends apt-utils \
    && apt-get install -y ca-certificates locales curl sudo python3-distutils unzip \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Use unicode
RUN locale-gen en_US.UTF-8 || true
ENV LANG=en_US.UTF-8

ENV JENKINS_HOME /var/jenkins_home
ENV HOME /home/jenkins

VOLUME ${JENKINS_HOME}

ARG user=jenkins
ARG group=jenkins
ARG uid=1000
ARG gid=1000

# Jenkins is run with user `jenkins`, uid = 1000
# If you bind mount a volume from the host or a data container, 
# ensure you use the same uid
RUN groupadd --gid ${gid} ${group} \
  && useradd --uid ${uid} --gid ${gid} --shell /bin/bash --create-home ${user} \
  && echo 'jenkins ALL=NOPASSWD: ALL' >> /etc/sudoers.d/50-jenkins \
  && echo 'Defaults    env_keep += "DEBIAN_FRONTEND"' >> /etc/sudoers.d/env_keep 

COPY base/wrappers/* /usr/local/bin/

USER jenkins

WORKDIR $HOME

RUN curl -O https://bootstrap.pypa.io/get-pip.py \
  && python3 get-pip.py --user --no-warn-script-location

# Install docker
RUN set -ex \
  && export DOCKER_VERSION=$(curl --silent --fail --retry 3 https://download.docker.com/linux/static/stable/x86_64/ | grep -o -e 'docker-[.0-9]*-ce\.tgz' | sort -r | head -n 1) \
  && DOCKER_URL="https://download.docker.com/linux/static/stable/x86_64/${DOCKER_VERSION}" \
  && echo Docker URL: $DOCKER_URL \
  && curl --silent --show-error --location --fail --retry 3 --output /tmp/docker.tgz "${DOCKER_URL}" \
  && ls -lha /tmp/docker.tgz \
  && tar -xz -C /tmp -f /tmp/docker.tgz \
  && mv /tmp/docker/* ${HOME}/.local/bin \
  && rm -rf /tmp/docker /tmp/docker.tgz

# docker compose
RUN COMPOSE_URL="https://circle-downloads.s3.amazonaws.com/circleci-images/cache/linux-amd64/docker-compose-latest" \
  && curl --silent --show-error --location --fail --retry 3 --output ${HOME}/.local/bin/docker-compose $COMPOSE_URL \
  && chmod +x ${HOME}/.local/bin/docker-compose

