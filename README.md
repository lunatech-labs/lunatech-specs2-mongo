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

- ### Include as dependency
Add the following dependency to `libraryDependencies` in your `build.sbt` or `project/Build.scala` file:

```
"com.lunatech" %% "specs2-mongo" % "0.1.0"
```

- ### Use the trait in your spec:

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
