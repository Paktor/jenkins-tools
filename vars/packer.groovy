#!/usr/bin/env groovy

/**
 * Execute packer command inside docker image
 *
 * @param scm
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/packer:latest')

    buildImage.pull()

    buildImage.inside() {
        sh "packer $arguments"
    }
}
