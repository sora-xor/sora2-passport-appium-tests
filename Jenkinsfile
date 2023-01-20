@Library('jenkins-library') _

// Job properties
def jobParams = [
  choice(
    choices: ['iOS', 'android'],
    name: 'platform',
    description: 'Platform'
  )
]
def jobLibrary = "org.ios.AppTestPipeline"

def pipline = new "${jobLibrary}"(
  steps: this,
  jobParams: jobParams,
  label: "mac-ios-1",
)

pipline.runPipeline('sora')
