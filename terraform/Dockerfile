FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

ARG TERRAFORM_VERSION=0.12.12

RUN curl -L https://releases.hashicorp.com/terraform/${TERRAFORM_VERSION}/terraform_${TERRAFORM_VERSION}_linux_amd64.zip -o terraform.zip \
  && unzip terraform.zip \
  && mv terraform $HOME/.local/bin \
  && rm  -rf terraform.zip

