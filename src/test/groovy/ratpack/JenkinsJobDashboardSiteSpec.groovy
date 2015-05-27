package ratpack

import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.ServerBackedApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.AutoCleanup
import spock.lang.Specification

class JenkinsJobDashboardSiteSpec extends Specification {

    @AutoCleanup
    ServerBackedApplicationUnderTest aut = new GroovyRatpackMainApplicationUnderTest()

    @Delegate
    TestHttpClient client = testHttpClient(aut)


    void 'main site check'() {
        when:
        get('')

        then:
        assert response.statusCode == 200
    }
}
