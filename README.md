deploygate-maven-plugin
=======================

This is the DeployGate plugin for maven.  
This plugin, you can use the deploygate API from maven easily.

For issue tracking see the [GitHub issues page](https://github.com/hotchemi/deploygate-maven-plugin/issues).

## Install

Add plugin to your pom.xml.

```xml
<plugin>
    <groupId>com.github.hotchemi</groupId>
    <artifactId>deploygate-maven-plugin</artifactId>
    <version>1.0.0</version>
</plugin>
```

## Usage

Execute following command to upload to deploygate.

```sh
mvn deploygate:upload 
```

### Params

Please check [Push API](https://deploygate.com/docs/api) for param information. 

- `ownerName` required.
- `token` required.
- `file` required.
- `message` optional.
- `distributionKey` optional.
- `releaseNote` optional.

```sh
% mvn deploygate:upload -DownerName="owner name" -Dtoken="token" -Dfile="sample.apk" -Dmessage="message" -DdistributionKey="distributinKey" -DreleaseNote="release note"
```

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request

## ChangeLog

- 2014/09/21 1.0.0 release.

## Licence

```
 Copyright 2014 Shintaro Katafuchi

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
```