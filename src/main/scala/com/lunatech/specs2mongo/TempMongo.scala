package com.lunatech.specs2mongo

import de.flapdoodle.embed.mongo.config.{RuntimeConfigBuilder, MongodConfigBuilder}
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.mongo.{Command, MongodStarter}
import de.flapdoodle.embed.process.config.io.ProcessOutput
import de.flapdoodle.embed.process.config.IRuntimeConfig
import org.specs2.mutable.Specification
import org.specs2.specification.core.Fragments

trait TempMongo extends Specification {

  def mongoVersion = Version.Main.V3_0

  private lazy val runtimeConfig: IRuntimeConfig = new RuntimeConfigBuilder()
    .defaults(Command.MongoD)
    .processOutput(ProcessOutput.getDefaultInstanceSilent)
    .build()

  private lazy val mongodConfig = new MongodConfigBuilder()
    .version(mongoVersion)
    .build

  private lazy val mongodExecutable = MongodStarter.getInstance(runtimeConfig).prepare(mongodConfig)

  lazy val tempMongo = Seq("mongodb.servers" -> List(s"${mongodConfig.net().getServerAddress.getHostName}:${mongodConfig.net().getPort}")).toMap

  override def map(fs: => Fragments): Fragments = step(mongodExecutable.start()) ^ fs ^ step(mongodExecutable.stop())
}
