plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kotlin-js-demos"

include(":01-basic:01-hello-world")
include(":01-basic:02-bootstrap")
include(":02-frameworks:02-fritz2:01-fritz2-basic")
include(":02-frameworks:02-fritz2:02-fritz2-router")
include(":02-frameworks:05-compose:01-compose-hello")
include(":02-frameworks:05-compose:02-routing-compose")
