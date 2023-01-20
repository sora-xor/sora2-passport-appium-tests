@Library('jenkins-library') _

// Job properties
def jobParams = [
  choice(
    choices: ['iOS', 'android'],
    name: 'platform',
    description: 'Platform'
  )
]

if ( "${params.platform}" == "iOS" ) {
  def pipline = new org.ios.AppTestPipeline(
    steps: this,
    jobParams: jobParams,
    label: "mac-ios-1",
    )
  pipline.runPipeline('sora')
} else {
  echo "pipeline for android"
//   def pipline = new org.android.AppTestPipeline(
//     steps: this,
//     jobParams: jobParams,
//     label: "mac-ios-1",
//     )
//   pipline.runPipeline('sora')
}
