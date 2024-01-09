@Library('jenkins-library') _

// Job properties
def jobParams = [
  choice(
    choices: ['iOS', 'android'],
    name: 'platform',
    description: 'Platform'
  ),
//  choice( choices: ['dev', 'stage'], name: 'env', description: 'Environment')
]

if ( "${params.platform}" == "iOS" ) {
  def pipeline = new org.ios.AppTestPipeline(
    steps: this,
    jobParams: jobParams,
    label: "mac-ios-2"
    )
  pipeline.runPipeline('sora')
} else {
  def pipeline = new org.android.AppTestPipeline(
    steps: this,
//     testCmd: 'ktlint clean runModuleTests jacocoTestReport',
    jobParams: jobParams,
    dockerImage: 'build-tools/android-build-box-jdk17'
  )
  pipeline.runPipeline('sora')
}

