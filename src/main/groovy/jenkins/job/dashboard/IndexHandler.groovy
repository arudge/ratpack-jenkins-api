package jenkins.job.dashboard

import groovy.util.logging.Slf4j
import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler
import ratpack.http.client.HttpClient

@Slf4j
class IndexHandler extends GroovyHandler {

    @Override
    protected void handle(GroovyContext context) {

        HttpClient httpClient = context.get(HttpClient)
        httpClient.get(new URI('http://jenkins.nodejs.org/api/json?depth=1')).then({
            context.response.headers.add('Content-Type', 'application/json')
            context.render(it.body.text)
        })
    }
}
