#!/usr/bin/env groovy

/**
 * Docker login for AWS ECS
 *
 * @param scm
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/aws:latest')

    buildImage.pull()

    def output

    buildImage.inside() {
        output = sh(returnStdout: true, script: "aws $arguments").trim()
    }

    return output
}
