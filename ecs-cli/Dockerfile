FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

RUN curl -o $HOME/.local/bin/ecs-cli http://s3.amazonaws.com/amazon-ecs-cli/ecs-cli-linux-amd64-latest \
    && chmod +x $HOME/.local/bin/ecs-cli
