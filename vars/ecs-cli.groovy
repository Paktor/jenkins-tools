#!/usr/bin/env groovy

/**
 * Execute ecs-cli command inside docker image
 *
 * @param scm
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/ecs-cli:latest')

    buildImage.pull()

    buildImage.inside() {
        sh "ecs-cli $arguments"
    }
}
