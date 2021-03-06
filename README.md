deploygate-maven-plugin
=======================

[![Build Status](https://travis-ci.org/hotchemi/deploygate-maven-plugin.svg?branch=master)](https://travis-ci.org/hotchemi/deploygate-maven-plugin)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.hotchemi/deploygate-maven-plugin/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.hotchemi/deploygate-maven-plugin)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-deploygate--maven--plugin-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/974)

This is the DeployGate plugin for maven.  
Through this plugin, you can use the deploygate API from maven easily.

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

Please check [Push API](https://deploygate.com/docs/api) for params information. 

- `ownerName` required.
- `token` required.
- `file` required.
- `message` optional.
- `distributionKey` optional.
- `releaseNote` optional.

```sh
% mvn deploygate:upload -DownerName="owner name" -Dtoken="token" -Dfile="file.apk" -Dmessage="message" -DdistributionKey="distributinKey" -DreleaseNote="releaseNote"
```

or

```xml
<plugin>
    <groupId>com.github,hotchemi</groupId>
    <artifactId>deploygate-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <ownerName>ownerName</ownerName>
        <token>token</token>
        <file>file.apk</file>
        <message>message</message>
        <distributionKey>distributionKey</distributionKey>
        <releaseNote>releaseNote</releaseNote>
    </configuration>
</plugin>
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
