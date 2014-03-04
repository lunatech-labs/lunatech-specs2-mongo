specs2-mongo
============

This project contains tools for testing using [specs2](http://etorreborre.github.io/specs2/) and
[Embedded MongoDB](https://github.com/flapdoodle-oss/de.flapdoodle.embed.mongo).

It currently contains a single trait (`TempMongo`)that, when mixed into your Specification, starts and stops a mongod
instance for use in your tests. The  connection configuration is available in a val called `tempMongo`.

When the test is done, the database is destroyed along with the mongod instance.

How to use
----------
To use the trait:

### 1. Include as dependency
Add the following dependency to `libraryDependencies` in your `build.sbt` or `project/Build.scala` file:

```
"com.lunatech" %% "specs2-mongo" % "0.1.0"
```

### 2. Use the trait in your spec:

The following example is a specification for a Play 2 application

```scala
class MySpec extends Specification with TempMongo {

  "My spec" should {
    "have a mongo database accessible" in {
      running(FakeApplication(additionalConfiguration = tempMongo)) {
        // Test stuff goes here
      }
    }
  }

}
```

License
=======
Copyright 2014 Lunatech (http://www.lunatech.com).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
