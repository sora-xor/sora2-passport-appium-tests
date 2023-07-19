// @Library('jenkins-library@feature/SUP-4541') _
@Library('jenkins-library@feature/DOPS-2170') _

// Job properties
def jobParams = [
  choice(
    choices: ['iOS', 'android'],
    name: 'platform',
    description: 'Platform'
  ),
]

if ( "${params.platform}" == "iOS" ) {
  def pipeline = new org.ios.AppTestPipeline(
    steps: this,
    jobParams: jobParams,
    label: "mac-ios-1"
    )
  pipeline.runPipeline('sora')
} else {
  def pipeline = new org.android.AppTestPipeline(
    steps: this,
//     testCmd: 'ktlint clean runModuleTests jacocoTestReport',
    jobParams: jobParams,
    dockerImage: 'build-tools/android-build-box-jdk11:latest'
  )
  pipeline.runPipeline('sora')
}

