name := "common-scala-impl"
organization := "cn.yuc.common"  // 组织名称
version := "0.1"

scalaVersion := "2.11.12"

idePackagePrefix := Some("cn.yuc.common")

libraryDependencies ++= Seq(
  "org.scala-lang"%"scala-compiler"%scalaVersion.value
)