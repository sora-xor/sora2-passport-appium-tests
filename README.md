# sora2-passport-appium-tests
Repository for Appium tests for Sora project.

## For the test run.

Please set up:
- JDK: https://jdk.java.net/18/
- X-code: https://apps.apple.com/us/app/xcode/id497799835?mt=12

- Node:
```
brew install node
 ```

- Appium:
```
npm install -g appium
```
- The iOs driver:
```
npm install appium-xcuitest-driver
```
- Next step is to set up the Sora Wallet app to the simulator.
Please download the Sora Wallet to Downloads folder and then run
> xcrun simctl list | grep 14

It should return something like this:
```
    iPhone 14 (85C6EDCA-0831-4075-B26D-A45C8295E203) (Shutdown) 
    iPhone 14 Plus (3B2693CF-150D-4E3F-8114-FF747E873882) (Shutdown) 
    iPhone 14 Pro (E529C846-CC49-43A3-9E38-7BEDF37286C3) (Shutdown) 
    iPhone 14 Pro Max (0284B3FC-F186-491F-9405-97E076CB6084) (Shutdown) 
    iPad mini (6th generation) (1494B97C-D292-41B8-A4A0-2CBD5E626A71) (Shutdown)
```
You'll need the long ID you have in brackets for the **iPhone 14 Pro Max**. So please replace my ID with yours in the install command.
```
xcrun simctl install 0284B3FC-F186-491F-9405-97E076CB6084 Downloads/SoraPassport.app
```

Almost done! And the last step is to download and run tests.
```git clone https://github.com/sora-xor/sora2-passport-appium-tests.git
cd sora2-passport-appium-tests
mvn clean install test -DsuiteXmlFile=testng.xml
```
And now you should see the Success message with tests results somewhere above:
```
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```
In case of problems please use Appium-doctor:
```
npm install -g appium-doctor
appium-doctor --ios
```

## For the test development.

Please set up everything above.
Also you will need:
- The development environment (I prefer Eclipse, it's available here: https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers)
- Appium server gui: https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
- Appium inspector: https://github.com/appium/appium-inspector

Please add testNG run configuration and add the PATH environment variable. The value can be found here:
```
echo $PATH
```

Now you can run tests from the Eclipse.
