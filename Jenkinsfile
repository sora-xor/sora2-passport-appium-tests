
pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        timestamps()
        disableConcurrentBuilds()
    }
    agent {
        label 'mac-ios-1'
    }
    stages {
        
        stage('Checkout code') {
            steps {
                dir("source") {
                    checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[credentialsId: 'sorabot-github-user', url: 'https://github.com/soramitsu/sora-passport-ios']]]
                    script {
                        sh "xcodebuild -workspace SoraPassport.xcworkspace -scheme SoraPassport -sdk iphonesimulat"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh "export no_proxy=localhost"
                    sh "mvn clean install test -DsuiteXmlFile=testng.xml"
                }
            }
        }
    }

    post {                                                                                                                                                                                                                                                                                                                                                                                                                                                     
        always {
            junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
        }
    }
}