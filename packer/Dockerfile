FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

ARG PACKER_VERSION=1.2.5

RUN curl -L https://releases.hashicorp.com/packer/${PACKER_VERSION}/packer_${PACKER_VERSION}_linux_amd64.zip -o packer_${PACKER_VERSION}_linux_amd64.zip \
    && unzip packer_${PACKER_VERSION}_linux_amd64.zip -d packer \
    && mv packer/packer $HOME/.local/bin \
    && rm -rf packer_${PACKER_VERSION}_linux_amd64.zip
