@Library('jenkins-library@feature/DOPS-1945') _

// Job properties
def jobParams = []

def pipline = new org.ios.AppTestPipeline(
    steps: this,
    jobParams: jobParams,
    label: "mac-ios-1",
)
pipline.runPipeline('sora')
