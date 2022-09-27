
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