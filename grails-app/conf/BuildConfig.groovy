grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		grailsCentral()
		mavenCentral()
		mavenRepo([
			name: 'repo.transmartfoundation.org-public',
			root: 'https://repo.transmartfoundation.org/content/repositories/public/'
	])
    }
	dependencies {
		compile 'net.sf.opencsv:opencsv:2.3'
		compile 'org.rosuda:Rserve:1.7.3'
		compile 'org.mapdb:mapdb:0.9.7'
		/* serializable ImmutableMap only on guava 16 */
		compile group: 'com.google.guava', name: 'guava', version: '16.0-dev-20140115-68c8348'
		compile 'org.transmartproject:transmart-core-api:1.0-SNAPSHOT'

	}
    plugins {
	
		compile(':transmart-java:1.0-SNAPSHOT')
		compile(':biomart-domain:1.0-SNAPSHOT')
		compile(':search-domain:1.0-SNAPSHOT')
		compile (':transmart-legacy-db:0.3-SNAPSHOT')
		//compile(':spring-security-core:1.1.2')
		compile (':spring-security-core:2.0-RC2')
		//compile ':spring-security-ldap:2.0-RC2')
		compile(':rdc-rmodules:0.4-snapshot')
		compile (':quartz:1.0-RC2')
		compile(':mail:1.0')
		build(":release:2.2.1",
			":rest-client-builder:1.0.3") {
		export = false
	}
		
    }
}
