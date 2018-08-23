FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

RUN .local/bin/pip install awscli --upgrade --user --no-warn-script-location

RUN mkdir -p $HOME/.local/bin \
    && curl -o $HOME/.local/bin/ecs-cli http://s3.amazonaws.com/amazon-ecs-cli/ecs-cli-linux-amd64-latest \
    && chmod +x $HOME/.local/bin/ecs-cli

COPY wrappers/* /usr/local/bin/
