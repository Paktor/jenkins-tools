FROM jenkinstools/base

USER root

RUN apt-get update \
    && apt-get install -y git \
    && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

USER jenkins

WORKDIR $HOME

RUN .local/bin/pip install awscli awsebcli --upgrade --user --no-warn-script-location

COPY eb/wrappers/* /usr/local/bin/
