FROM jenkinstools/base

USER jenkins

WORKDIR $HOME

ARG packer_version=1.2.5

RUN curl -L https://releases.hashicorp.com/packer/${packer_version}/packer_${packer_version}_linux_amd64.zip -o packer_${packer_version}_linux_amd64.zip \
    && unzip packer_${packer_version}_linux_amd64.zip -d packer \
    && mv packer/packer .local/bin \
    && rm -rf packer_${packer_version}_linux_amd64.zip

COPY wrappers/* /usr/local/bin/
