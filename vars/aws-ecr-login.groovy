#!/usr/bin/env groovy

/**
 * Docker login for AWS ECS
 *
 * @param scm
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/ecs-cli:latest')

    buildImage.pull()

    buildImage.inside() {
        sh "eval $(aws ecr get-login $arguments)"
    }
}
