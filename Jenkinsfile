@Library('jenkins-library@feature/DOPS-1945') _

// Job properties
def jobParams = []

def pipline = new org.ios.AutoTest(
    steps: this,
    jobParams: jobParams,
    label: "mac-ios-2",
    appPushNoti: true
)
pipline.runPipeline('sora')