#!/usr/bin/env groovy

/**
 * Execute eb command inside docker image
 *
 * @param scm
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/eb:latest')

    buildImage.pull()

    buildImage.inside() {
        sh "eb $arguments"
    }
}
