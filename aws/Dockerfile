FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

RUN .local/bin/pip install awscli --upgrade --user --no-warn-script-location

COPY aws/wrappers/* /usr/local/bin/
