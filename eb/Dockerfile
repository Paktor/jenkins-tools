FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

RUN .local/bin/pip install awscli awsebcli --upgrade --user --no-warn-script-location

COPY wrappers/aws /usr/local/bin/
COPY wrappers/eb /usr/local/bin/
