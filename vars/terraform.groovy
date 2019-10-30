#!/usr/bin/env groovy

/**
 * Execute terraform
 */
def call(arguments) {
    def buildImage = docker.image('jenkinstools/terraform')

    buildImage.pull()

    def output

    buildImage.inside() {
        output = sh(returnStdout: true, script: "terraform $arguments").trim()
    }

    return output
}
