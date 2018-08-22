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

# Install Docker
RUN curl -fsSL get.docker.com | sh

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

USER jenkins

WORKDIR $HOME

RUN curl -O https://bootstrap.pypa.io/get-pip.py \
  && python3 get-pip.py --user
