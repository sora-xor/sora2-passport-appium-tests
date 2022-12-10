pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '20'))
        timestamps()
        disableConcurrentBuilds()
    }
    agent {
        label 'mac-mcst-common-2'
    }
    environment {
	    LANG = 'en_US.UTF-8'
	    LANGUAGE = 'en_US.UTF-8'
	    LC_ALL = 'en_US.UTF-8'
	    no_proxy = 'local_host'
    }
    stages {        
        stage('Build App') {
            steps {
                dir("source") {
                    checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'sorabot-github-user', url: 'https://github.com/soramitsu/sora-passport-ios']]]
                    script {
                        sh ' echo "Removing Pods"'
                        sh ' rm -rf /Pods'
                        sh ' echo Removing old builds'
                        sh ' sudo rm -rf ~/Library/Developer/Xcode/DeriveredData/SoraPassport-*'
                        sh ' /usr/local/bin/pod cache clean --all'
                        sh ' /usr/local/bin/pod install --repo-update'
                        sh ' /usr/local/bin/pod update Firebase --no-repo-update'
                        sh ' /usr/local/bin/pod update XNetworking --no-repo-update'
                        sh ' xcodebuild -quiet -workspace SoraPassport.xcworkspace -scheme SoraPassport -sdk iphonesimulator -configuration Debug clean build'
                    }
                }
            }
        }
        
        stage('Install App On Simulators') {
            steps {
                script{
                    def APP_PATH = sh(script:"find ~/Library/Developer/Xcode/DerivedData/SoraPassport-*/Build/Products/Debug-iphonesimulator -name SoraPassport.app | head -n 1", returnStdout: true)
                    def DEVICE_ID = sh(script: '''xcrun simctl list | grep 'iPhone 14 Pro Max' | grep -m 1 -E -o -i "([0-9A-Z]{8}-([0-9A-Z]{4}-){3}[0-9A-Z]{12})"''', returnStdout: true)

                    if (APP_PATH.trim() && DEVICE_ID.trim()) {
                        sh "xcrun simctl boot "${DEVICE_ID}";"
                        sh "xcrun simctl install ${DEVICE_ID} ${APP_PATH};"
                    }
                    else {
                        sh "echo APP_PATH or DEVICE_ID not set"
                        sh "echo APP_PATH: ${APP_PATH} ${DEVICE_ID}"
                    }
                }
            }
        }


        stage('Test') {
             steps {
                 script {
                     sh """mvn clean install test "-DsuiteXmlFile=testng.xml" """
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
