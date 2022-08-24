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

- Next step is to set up the Sora Wallet app to the simulator.
Please download the Sora Wallet to Downloads folder and then run
> xcrun simctl list | grep 13

It should return something like this:
```
 Phone: iPhone 13 Pro (88560389-34FF-4E68-ACC0-26C20B2835E2) (Shutdown)
 Phone: iPhone 13 Pro Max (D7052F17-F875-4CD2-B6C7-22DF184A9DA3) (Shutdown)
 Phone: iPhone 13 mini (7480C6BA-6C91-4FA7-89CF-6553B5020E55) (Shutdown)
 Phone: iPhone 13 (CA6F8482-D442-4BB7-BD3D-312D3D0A16E6) (Booted)
```
You'll need the long ID you have in brackets for the **iPhone 13**. So please replace my ID with yours in the install command.
```
xcrun simctl install CA6F8482-D442-4BB7-BD3D-312D3D0A16E6 Downloads/SoraPassport.app
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
