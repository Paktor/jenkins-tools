FROM jenkinstools/base

USER root

RUN apt-get update \
    && apt-get install -y git \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

USER jenkins

WORKDIR $HOME

RUN pip install awscli awsebcli --upgrade --user
